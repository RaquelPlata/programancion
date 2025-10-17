
import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays paralelos: nombres y notas
        String[] nombres = {"Ana", "Luis", "Marta", "Pedro", "Sofía"};
        double[] notas = {8.5, 6.7, 9.2, 5.8, 7.4};

        // Pedir el nombre del estudiante
        System.out.print("Introduce el nombre del estudiante: ");
        String nombreBuscado = sc.nextLine();

        // Buscar el estudiante
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("La nota de " + nombres[i] + " es: " + notas[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }


    }
}
