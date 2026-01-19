package com.juego.razas;

// La clase Elfo representa una raza concreta del juego
// Implementa la interfaz Raza, definiendo los atributos propios de un elfo
public class Elfo implements Raza {

    // Nombre del personaje
    private String nombre;

    // Atributos principales de la raza:
    // f = fuerza, i = inteligencia, d = destreza, vida = puntos de vida iniciales
    private int f, i, d, vida;

    // CONSTRUCTOR
    // Permite crear un Elfo con nombre y atributos específicos
    public Elfo(String nombre, int f, int i, int d, int vida) {
        this.nombre = nombre;
        this.f = f;
        this.i = i;
        this.d = d;
        this.vida = vida;
    }

    // MÉTODOS GETTERS
    // Devuelven los valores de cada atributo

    public String getNombre() {
        return nombre;
    }

    public int f() {
        return f;
    }

    public int i() {
        return i;
    }

    public int d() {
        return d;
    }

    public int vida() {
        return vida;
    }
}