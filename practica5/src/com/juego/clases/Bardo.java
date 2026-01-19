package com.juego.clases;

import com.juego.habilidades.*;

// Clase que representa la clase Bardo
// Define los atributos de la clase y sus habilidades
public class Bardo implements Clase {

    // Nombres de las habilidades
    private String nombre_ataque;
    private String nombre_cura;
    private String nombre_distancia;

    // Valores de las habilidades
    private int ataque_valor;
    private int cura_valor;
    private int distancia_valor;

    // Constructor: asigna habilidades y valores
    public Bardo(
            String nombre_ataque,int ataque_valor,
            String nombre_cura,int cura_valor,
            String nombre_distancia,int distancia_valor
    ){
        this.nombre_ataque = nombre_ataque;
        this.ataque_valor = ataque_valor;
        this.nombre_cura = nombre_cura;
        this.cura_valor = cura_valor;
        this.nombre_distancia = nombre_distancia;
        this.distancia_valor = distancia_valor;
    }

    public String getNombre() {
        return "Bardo";
    }


    public int f() {
        return 0;
    }


    public int i() {
        return 3;
    }


    public int d() {
        return 0;
    }


    public int vida() {
        return 90;
    }

    // Devuelve un arreglo con las habilidades de la clase
    public Habilidad[] getHabilidades(){
        return new Habilidad[]{
                new DanioCuerpo(nombre_ataque,ataque_valor),
                new CuraCuerpo(nombre_cura,cura_valor),
                new DanioDistancia(nombre_distancia, distancia_valor)
        };
    }
}