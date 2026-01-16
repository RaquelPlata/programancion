package com.juego.clases;

import com.juego.habilidades.*;

public class Mago implements Clase{

    public String getNombre(){
        return "Mago";
    }

    public int f(){
        return 0;
    }
    public int i(){
        return 3;
    }
    public int d(){
        return 0;
    }
    public int vida(){
        return 90;
    }

    public Habilidad[] getHabilidades(){
        return new Habilidad[]{
                new DanioCuerpo("Toque Mágico",13),
                new CuraCuerpo("Sanación Arcana",10),
                new DanioDistancia("Rayo Mágico",35)
        };
    }
}