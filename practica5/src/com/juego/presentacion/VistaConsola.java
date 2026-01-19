package com.juego.presentacion;

import com.juego.modelo.Personaje;
import java.util.List;
import java.util.Scanner;

// Implementación concreta de Vista usando la consola
public class VistaConsola extends Vista {

    // Scanner para leer la entrada del usuario desde la consola
    private Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.println("""
        \n--- MENU ---
        1. Combatir
        2. Crear personaje
        3. Salir
        """);
    }


    public int leer() {
        return sc.nextInt(); // lee un número
    }


    public String leerTexto() {
        return sc.next(); // lee una palabra o cadena simple
    }


    public void mensaje(String m) {
        System.out.println(m); // imprime un mensaje en pantalla
    }

    public int pedir(String m) {
        System.out.print(m); // mensaje de prompt
        return sc.nextInt(); // devuelve el valor ingresado
    }

    public void listar(List<Personaje> lista) {
        // Muestra todos los personajes de la lista con índice
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " -> " + lista.get(i));
        }
    }
}