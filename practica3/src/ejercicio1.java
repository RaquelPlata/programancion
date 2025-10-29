public class ejercicio1 {
    public static void main(String[] args) {

        double[][] doub = {
                {0.0, 30.0, 2.0, 0.0, 0.0, 5.0},
                {75.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, -2.0, 9.0, 0.0, 11.0}
        };

        boolean[][] vacio = {
                {false, false, false, true, true, false},
                {false, true,  true,  true, false, true},
                {true,  true,  false, false, true, false}
        };

        int columnas = doub[0].length;
        int ancho = 12; // ancho de cada celda

        // Imprimir línea horizontal
        imprimirLinea(columnas, ancho);

        // Encabezado
        System.out.print("|" + centraTexto("Array num", ancho));
        for (int j = 0; j < columnas; j++) {
            System.out.print("|" + centraTexto("Columna " + j, ancho));
        }
        System.out.println("|");
        imprimirLinea(columnas, ancho);

        // Filas
        for (int i = 0; i < doub.length; i++) {
            System.out.print("|" + centraTexto("Fila " + i, ancho));
            for (int j = 0; j < columnas; j++) {
                String valor = vacio[i][j] ? "" : String.valueOf((int)doub[i][j]);
                System.out.print("|" + centraTexto(valor, ancho));
            }
            System.out.println("|");
            imprimirLinea(columnas, ancho);
        }
    }

    // Función para centrar texto
    public static String centraTexto(String texto, int ancho) {
        int espacios = ancho - texto.length();
        int izquierda = espacios / 2;
        int derecha = espacios - izquierda;
        return " ".repeat(izquierda) + texto + " ".repeat(derecha);
    }

    // Función para imprimir línea horizontal completa
    public static void imprimirLinea(int columnas, int ancho) {
        for (int i = 0; i <= columnas; i++) {
            System.out.print("+" + "-".repeat(ancho));
        }
        System.out.println("+");
    }
}
