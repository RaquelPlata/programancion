import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  Creamos el array principal de 4 filas x 5 columnas
        int[][] numeros = new int[4][5];

        //  Pedimos los números al usuario
        System.out.println("Introduce 20 números enteros (4 filas x 5 columnas):");
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 5; col++) {
                System.out.print("Número [" + fila + "][" + col + "]: ");
                numeros[fila][col] = sc.nextInt();
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
        String separador = "+" + "---------------+".repeat(6);

        System.out.println();
        System.out.println(separador);

        // Mostrar las filas con sus sumas parciales
        for (int fila = 0; fila < 4; fila++) {
            System.out.print("|");
            for (int col = 0; col < 5; col++) {
                System.out.printf(" %-13d|", numeros[fila][col]);
            }
            System.out.printf(" Σ fila = %-5d|", sumaFila[fila]);
            System.out.println();
            System.out.println(separador);
        }

        //  Fila de máximos por columna y total
        System.out.print("|");
        for (int col = 0; col < 5; col++) {
            System.out.printf(" Σ col %-1d = %-3d|", col, maxColumna[col]);
        }
        System.out.printf(" TOTAL = %-5d|", sumaTotal);
        System.out.println();
        System.out.println(separador);


    }
}
