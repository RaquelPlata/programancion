import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int sumaPositivos = 0, sumaNegativos = 0;
        int contPositivos = 0, contNegativos = 0;

        // Leer los 10 números
        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        // Calcular sumas y contadores
        for (int n : numeros) {
            if (n > 0) {
                sumaPositivos += n;
                contPositivos++;
            } else if (n < 0) {
                sumaNegativos += n;
                contNegativos++;
            }
        }

        // Mostrar medias
        System.out.println("\nResultados:");
        if (contPositivos > 0) {
            System.out.println("Media de los valores positivos: " + (double) sumaPositivos / contPositivos);
        } else {
            System.out.println("No se han introducido valores positivos.");
        }

        if (contNegativos > 0) {
            System.out.println("Media de los valores negativos: " + (double) sumaNegativos / contNegativos);
        } else {
            System.out.println("No se han introducido valores negativos.");
        }

        sc.close();
    }
}
