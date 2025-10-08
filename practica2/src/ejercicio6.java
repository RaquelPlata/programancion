import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int positivos = 0, negativos = 0, ceros = 0;

        // Leer los 10 números
        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        // Contar positivos, negativos y ceros
        for (int n : numeros) {
            if (n > 0) {
                positivos++;
            } else if (n < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);


    }
}