import java.util.Random;

public class ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        int[][] numeros = new int[4][5];
        int[] sumaFila = new int[4];
        int[] maxColumna = new int[5];
        int sumaTotal = 0;

        // Generar números aleatorios
        System.out.println("Generando 20 números aleatorios (1-1999):");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeros[i][j] = rand.nextInt(1999) + 1;
            }
        }

        // Calcular sumas y máximos
        for (int j = 0; j < 5; j++) maxColumna[j] = numeros[0][j];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int valor = numeros[i][j];
                sumaFila[i] += valor;
                sumaTotal += valor;
                if (valor > maxColumna[j]) maxColumna[j] = valor;
            }
        }

        // Mostrar tabla
        String sep = "+" + "------------------+".repeat(6);
        System.out.println("\n" + sep);
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 5; j++) {
                System.out.printf(" %-17d|", numeros[i][j]);
            }

            // Espera antes de mostrar suma de fila
            Thread.sleep(600);
            System.out.printf(" Σ fila %-2d = %-5d|", i + 1, sumaFila[i]);
            System.out.println("\n" + sep);
        }

        // Espera antes de mostrar totales
        Thread.sleep(800);
        System.out.print("|");
        for (int j = 0; j < 5; j++) {
            System.out.printf(" Σ col %-2d = %-6d|", j, maxColumna[j]);
        }

        // Pequeño retraso antes del total
        Thread.sleep(1000);
        System.out.printf(" TOTAL = %-9d|", sumaTotal);
        System.out.println("\n" + sep);
    }
}

