Estudiante: Benjamin Martinez
Cuenta Github: zerochaos02

Errores del codigo:
-No existen los metodos "hayCupo" y "obtenerUltimoEspacio", hay que crearlos.
-Variable "registro" empieza siendo String[][] pero al crearlo se le asigna un valor de double[][], hay que cambiarlo a String[][].
-En el metodo "registrar" se esta intentando acceder a un indice de un arreglo que no existe, hay que cambiarlo.
-Para comparar la edad que esta escrita en tipo String con un entero hay que ocupar Integer.parseInt() pero no se uso, por lo que se lo agregue.
-double[] persona no deberia ser un arreglo de double, deberia ser un arreglo de String.
-