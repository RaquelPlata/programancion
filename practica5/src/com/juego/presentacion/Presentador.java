package com.juego.presentacion;

import com.juego.modelo.*;
import com.juego.razas.*;
import com.juego.clases.*;

public class Presentador {

    // Vista para interactuar con el usuario
    private Vista vista;

    // Gestor de personajes (almacena y maneja los personajes creados)
    private GestorPersonajes gestor;

    // Constructor que recibe la vista y el gestor de personajes
    public Presentador(Vista v, GestorPersonajes g){
        vista = v;
        gestor = g;
    }

    // Metodo principal que inicia el ciclo del menú
    public void iniciar(){

        int op;
        do {
            vista.menu();           // Muestra el menú
            op = vista.leer();      // Lee la opción elegida por el usuario

            switch(op){
                case 1 -> jugar();   // Opción de combate
                case 2 -> crear();   // Opción de crear personaje
            }

        } while(op != 3);          // Sale cuando el usuario elige 3
    }

    // ----------------- METODO DE JUEGO -----------------
    private void jugar(){

        // Muestra la lista de personajes disponibles
        vista.listar(gestor.get());

        // Pide a los usuarios seleccionar personajes
        int a = vista.pedir("Jugador 1: ");
        int b = vista.pedir("Jugador 2: ");

        // Inicia un combate entre los personajes seleccionados
        new Combate().iniciar(
                gestor.get().get(a),
                gestor.get().get(b));
    }

    // ----------------- METODO DE CREAR PERSONAJE -----------------
    private void crear(){

        vista.mensaje("\nNombre:");          // Solicita nombre
        String nombre = vista.leerTexto();   // Lee el nombre ingresado

        Raza raza = elegirRaza();            // Elige raza
        Clase clase = elegirClase();          // Elige clase

        // Crea el personaje y lo agrega al gestor
        gestor.add(new Personaje(nombre, raza, clase));

        vista.mensaje("✔ Personaje creado"); // Mensaje de confirmación
    }

    // Metodo para elegir la raza del personaje
    private Raza elegirRaza(){

        vista.mensaje("\nRazas:");
        vista.mensaje("1.Humano\n2.Elfo\n3.Enano");

        // Devuelve la raza según la opción elegida
        return switch(vista.leer()){
            case 1 -> new Humano();
            case 2 -> new Elfo();
            default -> new Enano();
        };
    }

    // Metodo para elegir la clase del personaje
    private Clase elegirClase(){

        vista.mensaje("\nClases:");
        vista.mensaje("""
        1.Guerrero
        2.Paladin
        3.Monje
        4.Picaro
        5.Druida
        6.Sacerdote
        7.Mago
        8.Bardo""");

        // Devuelve la clase según la opción elegida
        return switch(vista.leer()){
            case 1 -> new Guerrero();
            case 2 -> new Paladin();
            case 3 -> new Monje();
            case 4 -> new Picaro();
            case 5 -> new Druida();
            case 6 -> new Sacerdote();
            case 7 -> new Mago();
            default -> new Bardo();
        };
    }
}