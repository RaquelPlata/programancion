import java.util.Random;
import java.util.Random;

public class ejercicio5 {
    public static void main(String[] args) {
        Random rand = new Random(); // Generador de números aleatorios

        // Declaración del array principal y arrays auxiliares para sumas
        int[][] numeros = new int[6][10];   // Matriz 6 filas x 10 columnas
        int[] sumaFilas = new int[6];       // Suma de cada fila
        int[] sumaColumnas = new int[10];   // Suma de cada columna
        int sumaTotal = 0;                  // Suma total de todos los números

        // Variables para encontrar el número máximo y mínimo
        int max = Integer.MIN_VALUE; // Valor mínimo posible (para empezar)
        int min = Integer.MAX_VALUE; // Valor máximo posible (para empezar)
        int filaMax = 0, colMax = 0; // Posición del número máximo
        int filaMin = 0, colMin = 0; // Posición del número mínimo

        // Rellenar automáticamente el array con números aleatorios (0–1000)
        for (int i = 0; i < 6; i++) {          // Recorremos las filas
            for (int j = 0; j < 10; j++) {     // Recorremos las columnas
                int valor = rand.nextInt(1001); // Genera número entre 0 y 1000
                numeros[i][j] = valor;          // Lo guarda en la matriz

                // Comprobamos si es el nuevo máximo
                if (valor > max) {
                    max = valor;
                    filaMax = i;
                    colMax = j;
                }

                // Comprobamos si es el nuevo mínimo
                if (valor < min) {
                    min = valor;
                    filaMin = i;
                    colMin = j;
                }

                // Acumulamos las sumas de filas, columnas y total
                sumaFilas[i] += valor;
                sumaColumnas[j] += valor;
                sumaTotal += valor;
            }
        }

        //  Mostrar tabla de números con formato
        System.out.println("\nMATRIZ DE NÚMEROS (6x10) ");
        String separador = "+" + "---------------+".repeat(11); // Línea separadora

        System.out.println(separador);
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                // Imprimir cada número con ancho fijo para mantener alineación
                System.out.printf(" %12d |", numeros[i][j]);
            }
            // Imprimir la suma de la fila correspondiente
            System.out.printf(" Σ fila %2d = %-8d |", i + 1, sumaFilas[i]);
            System.out.println();
            System.out.println(separador);
        }

        // Mostrar encabezado de sumas de columnas
        System.out.print("|");
        for (int j = 0; j < 10; j++) {
            System.out.printf(" Σ col %-6d |", j + 1);
        }
        // Mostrar la suma total general
        System.out.printf(" TOTAL = %-12d |", sumaTotal);
        System.out.println();
        System.out.println(separador);

        // Mostrar los valores de la suma de cada columna
        System.out.print("|");
        for (int j = 0; j < 10; j++) {
            System.out.printf(" %12d |", sumaColumnas[j]);
        }
        System.out.printf(" %-17s|", ""); // Espacio para alinear el formato
        System.out.println();
        System.out.println(separador);

        //  Mostrar los resultados finales
        System.out.println("\n RESULTADOS:");
        System.out.printf("→ Número máximo: %d (fila %d, columna %d)\n", max, filaMax + 1, colMax + 1);
        System.out.printf("→ Número mínimo: %d (fila %d, columna %d)\n", min, filaMin + 1, colMin + 1);
        System.out.println("→ Suma total de todos los elementos: " + sumaTotal);
    }
}
