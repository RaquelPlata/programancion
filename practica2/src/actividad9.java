import java.util.Scanner;

public class actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        // Pedir al usuario los 10 números enteros
        System.out.println("Introduce 10 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        //Buscar el valor máximo y mínimo con sus posiciones
        int max = numeros[0];
        int min = numeros[0];
        int posMax = 0;
        int posMin = 0;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
                posMax = i;
            }
            if (numeros[i] < min) {
                min = numeros[i];
                posMin = i;
            }
        }

        // Mostrar los resultados (posiciones empezando en 1)
        System.out.println("\nValor máximo: " + max + " en la posición " + (posMax + 1));
        System.out.println("Valor mínimo: " + min + " en la posición " + (posMin + 1));


    }
}

