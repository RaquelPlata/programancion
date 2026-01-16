package com.juego.modelo;

import com.juego.razas.*;
import com.juego.clases.*;

// Clase que precarga personajes de ejemplo en el juego
public class PrecargaDatos {

    // Metodo estático que recibe un gestor de personajes y agrega personajes predeterminados
    public static void cargar(GestorPersonajes g){

        // Se crean y agregan personajes con nombre, raza y clase
        g.add(new Personaje("Lulu", new Enano (), new Sacerdote()));
        g.add(new Personaje("Vera", new Elfo(), new Picaro()));
        g.add(new Personaje("Darek", new Enano(), new Paladin()));
        g.add(new Personaje("Mira", new Humano(), new Monje()));
        g.add(new Personaje("Rex", new Elfo(), new Mago()));
        g.add(new Personaje("Fox", new Humano(), new Guerrero()));
        g.add(new Personaje("Rolf", new Humano(), new Druida()));
        g.add(new Personaje("Dana", new Elfo(), new Bardo()));
    }
}