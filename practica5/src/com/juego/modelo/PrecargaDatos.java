package com.juego.modelo; // Indica que esta clase pertenece al paquete modelo

import com.juego.razas.*; // Importa todas las razas disponibles (Humano, Elfo, Enano)
import com.juego.clases.*; // Importa todas las clases disponibles (Guerrero, Mago, Sacerdote, etc.)

// Clase que sirve para precargar datos de ejemplo en el juego
// Esto es útil para tener personajes ya creados y poder probar combates o menús sin necesidad de crear nuevos
public class PrecargaDatos {

    // Método estático que recibe un gestor de personajes
    // Agrega personajes predeterminados al gestor
    public static void cargar(GestorPersonajes g){

        // Crea un personaje llamado "Lulu", raza Enano y clase Sacerdote, y lo agrega al gestor
        g.add(new Personaje("Lulu", new Enano(), new Sacerdote()));

        // Crea un personaje llamado "Vera", raza Elfo y clase Pícaro, y lo agrega al gestor
        g.add(new Personaje("Vera", new Elfo(), new Picaro()));

        // Crea un personaje llamado "Darek", raza Enano y clase Paladín, y lo agrega al gestor
        g.add(new Personaje("Darek", new Enano(), new Paladin()));

        // Crea un personaje llamado "Mira", raza Humano y clase Monje, y lo agrega al gestor
        g.add(new Personaje("Mira", new Humano(), new Monje()));

        // Crea un personaje llamado "Rex", raza Elfo y clase Mago, y lo agrega al gestor
        g.add(new Personaje("Rex", new Elfo(), new Mago()));

        // Crea un personaje llamado "Fox", raza Humano y clase Guerrero, y lo agrega al gestor
        g.add(new Personaje("Fox", new Humano(), new Guerrero()));

        // Crea un personaje llamado "Rolf", raza Humano y clase Druida, y lo agrega al gestor
        g.add(new Personaje("Rolf", new Humano(), new Druida()));

        // Crea un personaje llamado "Dana", raza Elfo y clase Bardo, y lo agrega al gestor
        g.add(new Personaje("Dana", new Elfo(), new Bardo()));
    }
}
