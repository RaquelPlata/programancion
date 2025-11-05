import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio6 {
    public static void main(String[] args) {
        Random rand = new Random();

        // Tamaño ajustado: 3x7 = 21 elementos (números únicos posibles entre 20 y 40)
        int filas = 3;
        int columnas = 7;

        int[][] numeros = new int[filas][columnas];
        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];
        int sumaTotal = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int filaMax = 0, colMax = 0;
        int filaMin = 0, colMin = 0;

        // Crear lista con los números del 20 al 40
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 20; i <= 40; i++) {
            listaNumeros.add(i);
        }

        // Barajar la lista para que los números salgan en orden aleatorio
        Collections.shuffle(listaNumeros);

        // Rellenar la matriz con números únicos
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int valor = listaNumeros.get(index++);
                numeros[i][j] = valor;

                if (valor > max) {
                    max = valor;
                    filaMax = i;
                    colMax = j;
                }

                if (valor < min) {
                    min = valor;
                    filaMin = i;
                    colMin = j;
                }

                sumaFilas[i] += valor;
                sumaColumnas[j] += valor;
                sumaTotal += valor;
            }
        }

        // Mostrar matriz con formato
        System.out.println("\nMATRIZ DE NÚMEROS (3x7, sin repetidos, rango 20–40)");
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

        // Encabezado de columnas
        System.out.print("|");
        for (int j = 0; j < columnas; j++) {
            System.out.printf(" Σ col %-6d |", j + 1);
        }
        System.out.printf(" TOTAL = %-12d |", sumaTotal);
        System.out.println();
        System.out.println(separador);

        // Valores de sumas por columna
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
