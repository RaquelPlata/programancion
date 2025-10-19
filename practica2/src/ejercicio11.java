public class ejercicio11 {
    public static void main(String[] args) {
        // Crear un array de tamaño 6 con valores de ejemplo
        int[] array = {1, 2, 3, 4, 5, 6};

        // Mostrar el array original
        System.out.println("Array original:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Invertir el array
        // Utilizamos dos índices: uno al principio y otro al final
        int inicio = 0;
        int fin = array.length - 1;

        // Mientras el índice de inicio sea menor que el de fin
        while (inicio < fin) {
            // Intercambiar los valores en las posiciones inicio y fin
            int temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;

            // Mover los índices hacia el centro
            inicio++;
            fin--;
        }

        // Mostrar el array invertido
        System.out.println("Array invertido:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}