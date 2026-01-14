package com.juego.clases;
import com.juego.habilidades.*;

public class Picaro implements Clase{

    public String getNombre(){return "Picaro";}

    public int f(){
        return 0;
    }
    public int i(){
        return 0;
    }
    public int d(){
        return 3;
    }
    public int vida(){
        return 105;
    }

    public Habilidad[] getHabilidades(){
        return new Habilidad[]{
                new DanioCuerpo("Puñalada",22),
                new CuraCuerpo("Escape",6),
                new DanioDistancia("Disparo Rápido",20)
        };
    }
}