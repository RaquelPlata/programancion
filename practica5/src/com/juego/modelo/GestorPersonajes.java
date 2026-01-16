package com.juego.modelo;

import java.util.*;

// Clase que gestiona la lista de personajes del juego
public class GestorPersonajes {

    // Lista interna que almacena los personajes
    private List<Personaje> lista = new ArrayList<>();

    // Metodo para agregar un personaje a la lista
    public void add(Personaje p){
        lista.add(p);
    }

    // Metodo para obtener la lista completa de personajes
    public List<Personaje> get(){
        return lista;
    }
}
