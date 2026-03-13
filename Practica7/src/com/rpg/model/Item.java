package com.rpg.model;

public class Item {
    private String id;
    private String nombre;
    private String tipo;
    private Integer valor;
    public int peso;
    private int fuerza;

    public Item(String id, String nombre, String tipo, Integer valor, int peso, int fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.peso = peso;
        this.fuerza = fuerza;
    }

    //metodo set

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    //Metodo get


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }
}


