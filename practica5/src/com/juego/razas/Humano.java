package com.juego.razas;

// La clase Humano representa una raza concreta del juego
// Implementa la interfaz Raza, que define los atributos básicos de cualquier raza
public class Humano implements Raza {

    // Nombre del personaje (o de la raza)
    private String nombre;

    // Atributos principales de la raza:
    // f = fuerza
    // i = inteligencia
    // d = destreza
    // vida = puntos de vida iniciales
    private int f, i, d, vida;

    // constructor
    // Permite crear un Humano asignando nombre y atributos
    public Humano(String nombre, int f, int i, int d, int vida) {
        this.nombre = nombre;
        this.f = f;
        this.i = i;
        this.d = d;
        this.vida = vida;
    }

    public Humano() {

    }

    // metodo getter
    // Devuelven los valores de cada atributo

    // Nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Fuerza
    public int f() {
        return f;
    }

    // Inteligencia
    public int i() {
        return i;
    }

    // Destreza
    public int d() {
        return d;
    }

    // Vida inicial
    public int vida() {
        return vida;
    }
}