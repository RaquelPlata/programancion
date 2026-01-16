package com.juego.modelo;

// Clase que representa las estadísticas base de un personaje
public class Stats {

    // Atributos del personaje: fuerza, inteligencia, destreza y vida máxima
    private int f, i, d, vidaMax;

    // Constructor: inicializa las estadísticas base
    public Stats(int f, int i, int d, int v){
        this.f = f;       // fuerza base
        this.i = i;       // inteligencia base
        this.d = d;       // destreza base
        vidaMax = v;      // vida máxima base
    }

    // Aplica un bonus a las estadísticas (por ejemplo, de la clase del personaje)
    public void bonus(int f, int i, int d){
        this.f += f;      // suma bonus a la fuerza
        this.i += i;      // suma bonus a la inteligencia
        this.d += d;      // suma bonus a la destreza
    }

    // Devuelve la vida máxima del personaje
    public int getVidaMax(){
        return vidaMax;
    }
}