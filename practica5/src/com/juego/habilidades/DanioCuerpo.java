package com.juego.habilidades;

public class DanioCuerpo implements Habilidad {

    private int usos = 5;
    private int valor;
    private String nombre;

    public DanioCuerpo(String nombre,int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre(){
        return nombre+" ("+usos+" usos)";
    }

    public int usar(){
        usos--;
        return valor;
    }

    public boolean tieneUsos(){
        return usos>0;
    }
}
