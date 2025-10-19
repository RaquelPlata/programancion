import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Array con las letras del DNI en orden
        // La secuencia de letras en los DNI en España es: T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        // Pedir al usuario que introduzca solo el número del DNI
        System.out.print("Introduce el número del DNI (solo números): ");
        long numeroDNI = scanner.nextLong();

        // Calcular el resto de dividir el número entre 23
        int resto = (int)(numeroDNI % 23);

        // Obtener la letra correspondiente en el array usando el resto como índice
        char letra = letrasDNI[resto];

        // Mostrar la letra al usuario
        System.out.println("La letra del DNI es: " + letra);


    }
}