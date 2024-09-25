import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        int a = -1;

        do {
            System.out.println("""
                    Menú
                    1) Agregar persona.
                    2) Mostrar la cantidad de personas mayores de edad.
                    3) Mostrar la cantidad de personas menores de edad.
                    4) Mostrar la cantidad de personas de tercera edad.
                    5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                    6)Salir.
                    """);

            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            } while (a <= 0 || a > 6);

            if (a == 1) {
                if (hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String estadoCivil;
                    int edad;

                    while (true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    while (true) {
                        try {
                            estadoCivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    while (true) {
                        try {
                            edad = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = estadoCivil;
                    registro[indiceDisponible][2] = String.valueOf(edad);
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if (a == 2) {
                int mayoresDeEdad = 0;

                for (String[] persona : registro) {
                    if (persona[2] != null && Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                }

                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if (a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);

                for (int i = 0; i < queSera; i++) {
                    if (registro[i][2] != null && Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
                }

                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if (a == 4) {
                int terceraEdad = 0;

                for (String[] persona : registro) {
                    if (persona[2] != null && Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                        terceraEdad++;
                    } else if (persona[2] != null && Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                        terceraEdad++;
                    }
                }
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
            } else if (a == 5) {
                int casados = 0;
                int solteros = 0;
                for (String[] persona : registro) {
                    if (persona[1] != null && persona[1].equals("casado/a")) {
                        casados++;
                    } else if (persona[1] != null && persona[1].equals("soltero/a")) {
                        solteros++;
                    }
                }

                System.out.println("Hay " + casados + " casados/as.");
                System.out.println("Hay " + solteros + " solteros/as.");
            } else if (a == 6) {
                System.out.println("Programa finalizado");
            }
        } while (a != 6);
    }

    private static boolean hayCupo(String[][] registro) {
        for (String[] persona : registro) {
            if (persona[0] == null) {
                return true;
            }
        }
        return false;
    }

    private static int obtenerUltimoEspacio(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return i;
            }
        }
        return -1;
    }
}