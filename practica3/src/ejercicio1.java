public class ejercicio1  {
    public static void main(String[] args) {


        //  Declaración y asignación del arreglo 'doub' de tipo double
        //    Este arreglo tiene 3 filas y 6 columnas con valores numéricos.

        double[][] doub = {
                {0.0, 30.0, 2.0, 0.0, 0.0, 5.0},
                {75.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, -2.0, 9.0, 0.0, 11.0}
        };


        // Declaración del arreglo booleano 'vacio' (mismo tamaño que 'doub')
        // Indica qué posiciones deben mostrarse vacías al imprimir la tabla:
        // true  -> la celda se deja en blanco
        // false -> se muestra el valor correspondiente de 'doub'

        boolean[][] vacio = {
                {false, false, false, true,  true,  false},
                {false, true,  true,  true,  false, true},
                {true,  true,  false, false, true,  false}
        };


        //  Guardamos en una variable la cantidad de columnas que tiene el arreglo

        int columnas = doub[0].length;

        //  Creamos una cadena llamada 'separador' para dibujar las líneas horizontales
        //    El método .repeat() repite el patrón tantas veces como columnas haya + 1

        String separador = "+" + "------------+".repeat(columnas + 1);


        //  Imprimimos el encabezado de la tabla con los nombres de las columnas

        System.out.println(separador); // Línea superior
        System.out.printf("| %-10s |", "Array num"); // Primera celda del encabezado

        // Imprimimos los títulos de las columnas: "Columna 0", "Columna 1", etc.
        for (int col = 0; col < columnas; col++) {
            System.out.printf(" Columna %-2d |", col);
        }
        System.out.println();           // Salto de línea
        System.out.println(separador);  // Línea divisoria debajo del encabezado


        //  Imprimimos el contenido de cada fila del arreglo

        for (int fila = 0; fila < doub.length; fila++) {

            // Mostramos el nombre de la fila: "Fila 0", "Fila 1", etc.
            System.out.printf("| %-10s |", "Fila " + fila);

            // Recorremos todas las columnas dentro de la fila actual
            for (int col = 0; col < columnas; col++) {

                // Si en la posición correspondiente de 'vacio' hay true,
                // imprimimos una celda vacía
                if (vacio[fila][col]) {
                    System.out.printf(" %-10s |", " ");
                }
                // Si hay false, mostramos el valor numérico de 'doub' con 2 decimales
                else {
                    System.out.printf(" %-10.2f |", doub[fila][col]);
                }
            }

            // Terminamos la fila actual y dibujamos una línea separadora
            System.out.println();
            System.out.println(separador);
        }


        //  Fin del programa

    }
}

