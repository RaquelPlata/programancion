import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Pedir cantidad de personas (N)
        do {
            System.out.print("Introduce el número de personas (entero positivo): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println(" Error: el número debe ser mayor que 0.");
            }
        } while (n <= 0);

        double[] alturas = new double[n];
        double suma = 0;

        // Leer las alturas
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce la altura de la persona " + (i + 1) + " (en metros): ");
            alturas[i] = sc.nextDouble();
            suma += alturas[i];
        }

        // Calcular media
        double media = suma / n;

        // Contar cuántos están por encima o por debajo de la media
        int superiores = 0, inferiores = 0;
        for (double altura : alturas) {
            if (altura > media) {
                superiores++;
            } else if (altura < media) {
                inferiores++;
            }
        }

        // Mostrar resultados
        System.out.println("\n--- Resultados ---");
        System.out.printf("Altura media: %.2f metros%n", media);
        System.out.println("Personas con altura superior a la media: " + superiores);
        System.out.println("Personas con altura inferior a la media: " + inferiores);

    }
}

