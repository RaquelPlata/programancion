package com.juego.clases;
import com.juego.habilidades.*;

public class Sacerdote implements Clase{

    public String getNombre(){return "Sacerdote";}

    public int f(){
        return 0;
    }
    public int i(){
        return 3;
    }
    public int d(){
        return 0;
    }
    public int vida() {
        return 95;
    }

    public Habilidad[] getHabilidades(){
        return new Habilidad[]{
                new DanioCuerpo("Bastón Sagrado",14),
                new CuraCuerpo("Curación",25),
                new DanioDistancia("Luz Castigadora",12)
        };
    }
}
