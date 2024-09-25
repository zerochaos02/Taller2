import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        ejecutarMenu(registro);
    }

    public static void mostrarMenu() {//Mostrar el menú
        System.out.println("---------------------------------");
        System.out.println("""
                    Menú
                    1) Agregar persona.
                    2) Mostrar la cantidad de personas mayores de edad.
                    3) Mostrar la cantidad de personas menores de edad.
                    4) Mostrar la cantidad de personas de tercera edad.
                    5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                    6) Salir.
                    """);
        System.out.println("---------------------------------");
        System.out.println("Ingrese una opción: ");
    }

    public static void ejecutarMenu(String[][] registro) {//Ejecutar el menú
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionValida();
            try {
                ejecutarOpcion(opcion, registro, scanner);
            } catch (Exception e) {
                System.out.println("Error al ejecutar la opción: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    public static int leerOpcionValida() {//Leer una opción válida
        int a = -1;
        do {
            try {
                a = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        } while (a <= 0 || a > 6);
        return a;
    }

    public static void ejecutarOpcion(int opcion, String[][] registro, Scanner scanner) {//Ejecutar una opción
        switch (opcion) {
            case 1:
                agregarPersona(registro, scanner);
                break;
            case 2:
                int mayoresDeEdad = contarMayoresDeEdad(registro);
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
                break;
            case 3:
                int menoresDeEdad = contarMenoresDeEdad(registro);
                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
                break;
            case 4:
                int terceraEdad = contarTerceraEdad(registro);
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
                break;
            case 5:
                int[] estadosCiviles= contarEstadoCivil(registro);
                System.out.println("Hay " + estadosCiviles[0] + " casados/as.");
                System.out.println("Hay " + estadosCiviles[1] + " solteros/as.");
                break;
            case 6:
                salir();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static String leerCadena(String mensaje, Scanner scanner) {//Leer una cadena
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje, Scanner scanner) {//Leer un entero
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                break;
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return valor;
    }

    private static boolean hayCupo(String[][] registro) {//Verificar si hay cupo
        for (String[] persona : registro) {
            if (persona[0] == null) {
                return true;
            }
        }
        return false;
    }

    private static int obtenerUltimoEspacio(String[][] registro) {//Obtener el último espacio disponible
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void salir() {//Salir del sistema
        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        System.exit(0);
    }

    public static void agregarPersona(String[][] registro, Scanner scanner) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = leerCadena("Ingrese el nombre: ", scanner);
            String estadoCivil = leerCadena("Ingrese el estado civil (soltera/o o casada/o): ", scanner);
            int edad = leerEntero("Ingrese la edad: ", scanner);

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadoCivil;
            registro[indiceDisponible][2] = String.valueOf(edad);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static int contarMayoresDeEdad(String[][] registro) {
        int mayoresDeEdad = 0;
        for (String[] persona : registro) {
            if (persona[2] != null && Integer.parseInt(persona[2]) >= 18) {
                mayoresDeEdad++;
            }
        }
        return mayoresDeEdad;
    }

    public static int contarMenoresDeEdad(String[][] registro) {
        int menoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);
        for (int i = 0; i < queSera; i++) {
            if (registro[i][2] != null && Integer.parseInt(registro[i][2]) < 18) {
                menoresDeEdad++;
            }
        }
        return menoresDeEdad;
    }

    public static int contarTerceraEdad(String[][] registro) {
        int terceraEdad = 0;
        for (String[] persona : registro) {
            if (persona[2] != null && Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                terceraEdad++;
            } else if (persona[2] != null && Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                terceraEdad++;
            }
        }
        return terceraEdad;
    }

    public static int[] contarEstadoCivil(String[][] registro) {
        int casados = 0;
        int solteros = 0;
        for (String[] persona : registro) {
            if (persona[1] != null && persona[1].equals("casado/a")) {
                casados++;
            } else if (persona[1] != null && persona[1].equals("soltero/a")) {
                solteros++;
            }
        }
        return new int[]{casados, solteros};
    }
}