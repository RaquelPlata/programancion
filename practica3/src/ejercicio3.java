import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        Random rand = new Random();

        //  Creamos el array principal de 4 filas x 5 columnas
        int[][] numeros = new int[4][5];

        //  Generamos los números aleatoriamente (1 a 1999)
        System.out.println("Generando 20 números aleatorios (entre 1 y 1999):");
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 5; col++) {
                numeros[fila][col] = rand.nextInt(1999) + 1;
            }
        }

        //  Calculamos sumas por fila, máximos por columna y suma total
        int[] sumaFila = new int[4];
        int[] maxColumna = new int[5];
        int sumaTotal = 0;

        // Inicializamos máximos de las columnas
        for (int c = 0; c < 5; c++) {
            maxColumna[c] = numeros[0][c];
        }

        // Recorremos matriz para sumar y encontrar máximos
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 5; col++) {
                int valor = numeros[fila][col];
                sumaFila[fila] += valor;      // suma parcial fila
                sumaTotal += valor;           // suma total
                if (valor > maxColumna[col]) {
                    maxColumna[col] = valor;  // máximo por columna
                }
            }
        }

        //  Imprimimos la tabla formateada
        String separador = "+" + "-------------------+".repeat(6);

        System.out.println();
        System.out.println(separador);

        // Mostrar las filas con sus sumas parciales
        for (int fila = 0; fila < 4; fila++) {
            System.out.print("|");
            for (int col = 0; col < 5; col++) {
                System.out.printf(" %-18d|", numeros[fila][col]);
            }
            System.out.printf(" Σ fila %-2d = %-5d|", fila + 1, sumaFila[fila]);
            System.out.println();
            System.out.println(separador);
        }

        //  Fila de máximos por columna y total
        System.out.print("|");
        for (int col = 0; col < 5; col++) {
            System.out.printf(" Σ columna %-1d = %-4d|", col, maxColumna[col]);
        }
        System.out.printf(" TOTAL = %-9d|", sumaTotal);
        System.out.println();
        System.out.println(separador);
    }
}
