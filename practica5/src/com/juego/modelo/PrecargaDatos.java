package com.juego.modelo;

import com.juego.razas.*;
import com.juego.clases.*;

// Clase para crear datos precargados de razas, clases y personajes
public class PrecargaDatos {

    // Carga inicial de personajes al juego
    public static void cargar(GestorPersonajes g) {

        g.add(new Personaje("PEPI", crearElfo(), crearMonje()));
        g.add(new Personaje("LOREM", crearHumano(), crearDruida()));
        g.add(new Personaje("MARCA", crearEnano(), crearSacerdote()));
    }

    // Métodos para crear razas con atributos iniciales
    public static Raza crearHumano() {
        return new Humano("Humano", 5, 5, 5, 100);
    }

    public static Raza crearElfo() {
        return new Elfo("Elfo", 4, 6, 7, 90);
    }

    public static Raza crearEnano() {
        return new Enano("Enano", 7, 4, 4, 110);
    }

    // Métodos para crear clases y asignar habilidades
    public static Clase crearGuerrero() {
        return new Guerrero("puño", 25,
                "grandote", 8,
                "lanzamiento de cabeza", 10);
    }

    public static Clase crearPaladin() {
        return new Paladin("Espada maldita", 18,
                "Luz floral", 15,
                "Judia voladora", 10);
    }

    public static Clase crearMonje() {
        return new Monje("Puño", 17,
                "Calma", 8,
                " Onda", 18);
    }

    public static Clase crearPicaro() {
        return new Picaro("Cuchillada", 22,
                " Vendaje", 6,
                "Daga ", 20);
    }

    public static Clase crearDruida() {
        return new Druida(" Garra", 10,
                "Curita", 25,
                " raices", 25);
    }

    public static Clase crearSacerdote() {
        return new Sacerdote("Golpe", 8,
                "Sanar", 25,
                "Luz ", 12);
    }

    public static Clase crearMago() {
        return new Mago("Bastón ", 7,
                "Escudo ", 10,
                "Dragon", 50);
    }

    public static Clase crearBardo() {
        return new Bardo("Golpe ", 10,
                "Canción", 13,
                "Nota ", 18);
    }
}
