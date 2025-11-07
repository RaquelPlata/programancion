import java.util.Random;
import java.util.Scanner;

/**
 * Juego: Búsqueda del Tesoro con impostor y tablero
 * - El jugador introduce coordenadas (X, Y) en un tablero 10x10.
 * - El juego da pistas de cercanía al tesoro real y al impostor.
 * - Muestra el tablero actualizado en cada turno.
 */
public class ejercicio8 {

    private static final int SIZE = 10;
    private static final char EMPTY = '.';
    private static final char DIGGED = 'X';
    private static final char TREASURE = 'T';
    private static final char IMPOSTOR = 'I';

    private static int treasureX, treasureY;
    private static int impostorX, impostorY;
    private static char[][] board;

    private static final Random random = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicio8 game = new ejercicio8();
        game.start();
    }

    public void start() {
        inicializarTablero();
        colocarTesoros();

        System.out.println("===  BÚSQUEDA DEL TESORO ===");
        System.out.println("Hay un TESORO REAL y un IMPOSTOR ocultos.");
        System.out.println("Introduce coordenadas X e Y (0–9) para excavar.\n");

        while (true) {
            mostrarTablero(false);

            System.out.print(" Coordenada X: ");
            int x = leerNumero();
            System.out.print(" Coordenada Y: ");
            int y = leerNumero();

            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println(" Coordenadas fuera del tablero. Intenta otra vez.\n");
                continue;
            }

            if (board[x][y] == DIGGED) {
                System.out.println("⛏ Ya excavaste ahí. Intenta otra posición.\n");
                continue;
            }

            board[x][y] = DIGGED;

            if (x == treasureX && y == treasureY) {
                mostrarTablero(true);
                System.out.println("\n ¡Encontraste el TESORO REAL! ¡Ganaste!\n");
                break;
            } else if (x == impostorX && y == impostorY) {
                mostrarTablero(true);
                System.out.println("\n ¡Oh no! Encontraste el impostor. Has perdido...\n");
                break;
            } else {
                darPistas(x, y);
            }
        }

        System.out.println(" El tesoro real estaba en: (" + treasureX + ", " + treasureY + ")");
        System.out.println(" El impostor estaba en: (" + impostorX + ", " + impostorY + ")");
        System.out.println(" Gracias por jugar.");
    }

    private void inicializarTablero() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    private void colocarTesoros() {
        treasureX = random.nextInt(SIZE);
        treasureY = random.nextInt(SIZE);
        do {
            impostorX = random.nextInt(SIZE);
            impostorY = random.nextInt(SIZE);
        } while (impostorX == treasureX && impostorY == treasureY);
    }

    private void mostrarTablero(boolean revelar) {
        System.out.println("\n   0 1 2 3 4 5 6 7 8 9");
        System.out.println("  ---------------------");

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < SIZE; j++) {
                if (revelar) {
                    if (i == treasureX && j == treasureY)
                        System.out.print(TREASURE + " ");
                    else if (i == impostorX && j == impostorY)
                        System.out.print(IMPOSTOR + " ");
                    else
                        System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void darPistas(int x, int y) {
        double distTesoro = distancia(x, y, treasureX, treasureY);
        double distImpostor = distancia(x, y, impostorX, impostorY);

        // Pistas del tesoro
        if (distTesoro <= 1.5) {
            System.out.println(" -Estás MUY cerca del tesoro real!");
        } else if (distTesoro <= 3) {
            System.out.println(" -Estás cerca del tesoro.");
        } else {
            System.out.println("- Estás lejos del tesoro.");
        }

        // Pistas del impostor
        if (distImpostor <= 1.5) {
            System.out.println(" ¡Cuidado! Estás muy cerca del impostor!\n");
        } else if (distImpostor <= 3) {
            System.out.println("️ -Estás algo cerca del impostor.\n");
        } else {
            System.out.println(" -Estás lejos del impostor.\n");
        }
    }

    private double distancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private int leerNumero() {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print(" Ingresa un número válido: ");
            }
        }
    }
}
