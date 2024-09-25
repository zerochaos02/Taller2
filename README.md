Estudiante: Benjamin Martinez
Cuenta Github: zerochaos02

Errores del codigo:
-No existen los metodos "hayCupo" y "obtenerUltimoEspacio", hay que definirlos para que se ejecuten.
-Variable "registro" empieza siendo String[][] pero al crearlo se le asigna un valor de double[][], hay que cambiarlo a String[][].
-En el metodo "registrar" se esta intentando acceder a un indice de un arreglo que no existe, hay que cambiarlo.
-Para comparar la edad que esta escrita en tipo String con un entero hay que ocupar Integer.parseInt() pero no se uso, por lo que se lo agregue.
-double[] persona no deberia ser un arreglo de double, deberia ser un arreglo de String.
-El menu se estaba haciendo en el menu cuando seria mas eficiente que fuera una funcion con varias funciones auxiliares para que funcione infinitamente.
-La opcion 1 del menu se convirtio en una funcion llamada "agregarPersona".
-La opcion 1 tenia uso repetido de Scanner, el catch de InputMismatchException no limpiaba el buffer de Scanner, se cambio para que limpie el buffer.
-La opcion 1 no existia validaciones para el nombre, estadoCivil y edad, se agregaron. 
-La opcion 1 tiene el uso de continue en los bucles while(true) lo cual puede ser simplificado para entender mas facil el codigo.
-









