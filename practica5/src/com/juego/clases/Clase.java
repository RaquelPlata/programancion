package com.juego.clases;

import com.juego.habilidades.*;

public interface Clase {

    String getNombre();
    int f(); int i(); int d();
    int vida();

    Habilidad[] getHabilidades();
}