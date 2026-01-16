package com.juego.clases;
import com.juego.habilidades.*;

public class Paladin implements Clase {

    public String getNombre() {
        return "Paladin";
    }

    public int f() {
        return 2;
    }

    public int i() {
        return 1;
    }

    public int d() {
        return 0;
    }

    public int vida() {
        return 115;
    }

    public Habilidad[] getHabilidades() {
        return new Habilidad[]{
                new DanioCuerpo("Golpe Santo", 20),
                new CuraCuerpo("Luz Sanadora", 25),
                new DanioDistancia("Castigo ", 20)
        };
    }
}