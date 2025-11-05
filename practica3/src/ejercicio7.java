import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Entrada de rango dinámico
        System.out.print("Introduce el valor mínimo: ");
        int minimo = sc.nextInt();

        System.out.print("Introduce el valor máximo: ");
        int maximo = sc.nextInt();

        int filas = 3;
        int columnas = 7;
        int totalNumeros = filas * columnas;
        int rangoTotal = maximo - minimo + 1;

        if (rangoTotal < totalNumeros) {
            System.out.println(" El rango no es suficiente para generar números únicos (" + totalNumeros + " requeridos).");
            return;
        }

        int[][] numeros = new int[filas][columnas];
        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];
        int sumaTotal = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int filaMax = 0, colMax = 0;
        int filaMin = 0, colMin = 0;

        // Crear lista con números dentro del rango dado
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = minimo; i <= maximo; i++) {
            listaNumeros.add(i);
        }

        // Barajar la lista
        Collections.shuffle(listaNumeros);

        // Rellenar matriz sin repetir
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int valor = listaNumeros.get(index++);
                numeros[i][j] = valor;

                // Actualizar máximo y mínimo
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

        // Mostrar matriz
        System.out.println("\nMATRIZ DE NÚMEROS (3x7, sin repetidos, rango " + minimo + "–" + maximo + ")");
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

        //  Media aritmética
        double media = (double) sumaTotal / totalNumeros;
        System.out.printf("\n→ Media aritmética de todos los números: %.2f\n", media);

        // Números primos
        System.out.println("\n→ Números primos y sus posiciones:");
        boolean hayPrimos = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (esPrimo(numeros[i][j])) {
                    System.out.printf("   - %d en (fila %d, columna %d)\n", numeros[i][j], i + 1, j + 1);
                    hayPrimos = true;
                }
            }
        }
        if (!hayPrimos) {
            System.out.println("   No hay números primos en la matriz.");
        }

        //  Representación gráfica
        System.out.println("\n→ Representación gráfica por filas:");
        for (int i = 0; i < filas; i++) {
            System.out.printf("Fila %d: ", i + 1);
            for (int j = 0; j < columnas; j++) {
                int valor = numeros[i][j];
                int cantidad = valor - minimo; // proporcional al rango
                System.out.print("[" + "*".repeat(cantidad) + "]");
            }
            System.out.println();
        }

        //  Resultados finales
        System.out.println("\nRESULTADOS:");
        System.out.printf("→ Número máximo: %d (fila %d, columna %d)\n", max, filaMax + 1, colMax + 1);
        System.out.printf("→ Número mínimo: %d (fila %d, columna %d)\n", min, filaMin + 1, colMin + 1);
        System.out.println("→ Suma total de todos los elementos: " + sumaTotal);


    }

    // comprobar si un número es primo através del metodo auxiliar
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
