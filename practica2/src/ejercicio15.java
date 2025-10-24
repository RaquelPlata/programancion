import java.util.ArrayList;
import java.util.Scanner;

//Cree una lista de enteros (ArrayList<Integer>).
//Pida al usuario 10 números enteros y los añada a la lista.
//Elimine los valores duplicados manteniendo solo el primero que apareció.
//Ordene la lista de menor a mayor y la muestre por pantalla. */

public class ejercicio15 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        // Pedir 10 números por pantalla
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            int num = s.nextInt();
            lista.add(num);
        }

        // Crear una nueva lista sin duplicados
        ArrayList<Integer> sinDuplicados = new ArrayList<>();

        // Recorremos lista original
        for (Integer num : lista) {
            boolean repetido = false;

            // Comprobamos manualmente si ya está en sinDuplicados
            for (Integer otro : sinDuplicados) {
                if (num.equals(otro)) {
                    repetido = true;
                    break;
                }
            }

            // Si no está repetido, lo añadimos
            if (!repetido) {
                sinDuplicados.add(num);
            }
        }

        // Ordenar manualmente (algoritmo de burbuja)
        for (int i = 0; i < sinDuplicados.size() - 1; i++) {
            for (int j = 0; j < sinDuplicados.size() - 1 - i; j++) {

                // Comparar usando el for-each no se puede, necesitamos índices aquí
                // pero sin get(): usamos un array temporal para poder comparar
                int a = 0;
                int b = 0;
                int pos = 0;

                // Obtener los valores manualmente (sin get)
                for (Integer valor : sinDuplicados) {
                    if (pos == j) a = valor;
                    if (pos == j + 1) b = valor;
                    pos++;
                }

                // Si están en orden incorrecto, intercambiamos
                if (a > b) {
                    // Intercambio manual sin get ni set
                    ArrayList<Integer> temp = new ArrayList<>();
                    int index = 0;
                    for (Integer valor : sinDuplicados) {
                        if (index == j) temp.add(b);
                        else if (index == j + 1) temp.add(a);
                        else temp.add(valor);
                        index++;
                    }
                    sinDuplicados = temp;
                }
            }
        }

        // Mostrar lista final ordenada y sin duplicados
        System.out.println("Lista sin duplicados y ordenada:");
        for (Integer n : sinDuplicados) {
            System.out.print(n + " ");
        }
    }
}

