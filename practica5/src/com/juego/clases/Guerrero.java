package com.juego.clases;

import com.juego.habilidades.*;

public class Guerrero implements Clase{

    public String getNombre(){return "Guerrero";}

    public int f(){
        return 3;
    }
    public int i(){
        return 0;
    }
    public int d(){
        return 0;
    }
    public int vida(){
        return 120;
    }

    public Habilidad[] getHabilidades(){
        return new Habilidad[]{
                new DanioCuerpo("Golpe Fuerte",25),
                new CuraCuerpo(" Resistencia",5),
                new DanioDistancia("Lanzamiento",10)
        };
    }
}