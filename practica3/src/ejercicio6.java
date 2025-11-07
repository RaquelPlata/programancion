import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        Random rand = new Random();

        int filas = 3;
        int columnas = 7;
        int[][] numeros = new int[filas][columnas];
        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];
        int sumaTotal = 0;

        int rangoMin = 20;
        int rangoMax = 40; // 21 números posibles (20..40)

        // Crear array con todos los números posibles
        int totalNumeros = rangoMax - rangoMin + 1; // 21
        int[] valores = new int[totalNumeros];

        for (int i = 0; i < totalNumeros; i++) {
            valores[i] = rangoMin + i;
        }

        // Mezclar los números manualmente (sin Collections.shuffle)
        for (int i = 0; i < totalNumeros; i++) {
            int j = rand.nextInt(totalNumeros);
            int temp = valores[i];
            valores[i] = valores[j];
            valores[j] = temp;
        }

        // Rellenar la matriz con los números ya mezclados (únicos)
        int indice = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int filaMax = 0, colMax = 0, filaMin = 0, colMin = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int valor = valores[indice++];
                numeros[i][j] = valor;

                if (valor > max) { max = valor; filaMax = i; colMax = j; }
                if (valor < min) { min = valor; filaMin = i; colMin = j; }

                sumaFilas[i] += valor;
                sumaColumnas[j] += valor;
                sumaTotal += valor;
            }
        }

        // Mostrar tabla formateada
        System.out.println("\nMATRIZ DE NÚMEROS ÚNICOS (3x7) — valores entre 20 y 40\n");
        String separador = "+" + "---------------+".repeat(columnas + 1);
        System.out.println(separador);

        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                System.out.printf(" %12d |", numeros[i][j]);
            }
            System.out.printf(" Σ fila %2d = %-8d |", i + 1, sumaFilas[i]);
            System.out.println();
            System.out.println(separador);
        }

        // Encabezado sumas columnas
        System.out.print("|");
        for (int j = 0; j < columnas; j++) {
            System.out.printf(" Σ col %-6d |", j + 1);
        }
        System.out.printf(" TOTAL = %-12d |", sumaTotal);
        System.out.println();
        System.out.println(separador);

        // Mostrar sumas de columnas
        System.out.print("|");
        for (int j = 0; j < columnas; j++) {
            System.out.printf(" %12d |", sumaColumnas[j]);
        }
        System.out.printf(" %-17s|", "");
        System.out.println();
        System.out.println(separador);

        // Resultados finales
        System.out.println("\nRESULTADOS:");
        System.out.printf("→ Número máximo: %d (fila %d, columna %d)\n", max, filaMax + 1, colMax + 1);
        System.out.printf("→ Número mínimo: %d (fila %d, columna %d)\n", min, filaMin + 1, colMin + 1);
        System.out.println("→ Suma total de todos los elementos: " + sumaTotal);
    }
}
