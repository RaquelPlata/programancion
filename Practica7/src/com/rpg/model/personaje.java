package com.rpg.model;
import java.util.ArrayList;
import java.util.List;

public class personaje {
    private String nombre;
    private String raza;
    private int nivel;
    private List<Item> equipo;

    public personaje (String nombre , String raza , int nivel ){
       this.nombre=nombre;
       this.raza=raza;
       this.nivel=nivel;
       this.equipo=new ArrayList<>();
    }
    //metodo set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setEquipo(List<Item> equipo) {
        this.equipo = equipo;
    }
    //metodo get

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getNivel() {
        return nivel;
    }

    public List<Item> getEquipo() {
        return equipo;
    }
}