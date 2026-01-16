package com.juego.presentacion;

import java.util.*;
import com.juego.modelo.Personaje;

public class Vista {

    // Scanner para leer la entrada del usuario por consola
    private Scanner sc = new Scanner(System.in);

    //Muestra el menú principal en la consola.

    public void menu(){
        System.out.println("\n1. Combatir");
        System.out.println("2. Crear personaje");
        System.out.println("3. Salir");
    }

    //Lee un número entero ingresado por el usuario.
    //Se usa para leer opciones de menú o selección de personajes.

    public int leer(){
        return sc.nextInt();
    }

    // Lee un texto ingresado por el usuario.

    public String leerTexto(){
        return sc.next();
    }

    //Lista los personajes disponibles en pantalla.
    //lista de personajes a mostrar
    public void listar(List<Personaje> lista){
        int i = 1;
        for(Personaje p : lista)
            System.out.println(i++ + ". " + p); // Muestra número y estado del personaje
    }

    //Pide al usuario seleccionar un personaje u opción.
    // Resta 1 para convertir de índice visible (1,2,3...) a índice de lista (0,1,2...).
    // Mensaje a mostrar al usuarioíndice seleccionado por el usuario
    public int pedir(String msg){
        System.out.print(msg);
        return sc.nextInt() - 1;
    }

    //Muestra un mensaje en la consola.


    public void mensaje(String m){
        System.out.println(m);
    }
}