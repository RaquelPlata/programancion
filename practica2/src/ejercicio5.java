import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos el tamaño del array
        System.out.print("Introduce el tamaño del array: ");
        int tamaño = sc.nextInt();

        int[] array = new int[tamaño];
        int suma = 0;

        System.out.println("Valores del array:");
        for (int i = 0; i < tamaño; i++) {
            array[i] = (int) (Math.random() * 10); // aleatorio entre 0 y 9
            System.out.println("Posición " + i + ": " + array[i]);
            suma += array[i];
        }
        //Imprimimos por pantalla
        System.out.println("\nLa suma de todos los valores es: " + suma);

    }
}
