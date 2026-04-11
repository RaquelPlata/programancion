/**package rpg.ui;


import java.util.Scanner;

public class menu {


    Scanner sc = new Scanner(System.in);
    int ejecutar ;

        while (ejecutar) {
        // Mostramos el menú
        System.out.println("------ MENÚ PRINCIPAL ------");
        System.out.println("1. Gestión de Personajes y Exploración");
        System.out.println("2. Tienda, Inventario y Excepciones");
        System.out.println("3. Eventos del Mundo");
        System.out.println("4. Registro de Eventos");
        System.out.println("5. Sistema de Combate y Habilidades");
        System.out.println("6. Centro de Estadísticas");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();  // Leemos la opción del usuario

       /** switch (opcion) {
            case 1:
                crearPersonaje();
                break;

            case 2:
                comprarItems();
                break;

            case 3:
                combate();
                break;

            case 7:
                System.out.println("¡Gracias por jugar!");
                ejecutar = false;  // Salimos del bucle para terminar el juego
                break;

            default:
                System.out.println("Opción no válida, por favor elige de nuevo.");
 }
 }
        }**/

