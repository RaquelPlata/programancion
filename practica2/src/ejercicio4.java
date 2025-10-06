public class ejercicio4 {
    //Crear un array de números de 100 posicionesque contendrá los números del 1 al 100.
    // Obtén la suma de todos ellos y la media.
        public static void main(String[] args) {
            int[] numeros = new int[100];
            int suma = 0;

            // Llenar el array con los números del 1 al 100
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = i + 1; // porque los índices empiezan en 0
                suma += numeros[i]; // guardamos la suma
            }

            // Calcular la media
            double media = (double) suma / numeros.length;

            // Mostrar resultados
            System.out.println("Suma de los números del 1 al 100: " + suma);
            System.out.println("Media de los números del 1 al 100: " + media);
        }
    }


