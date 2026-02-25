package com.rpg.model;

public class item {
    private String id;
    private String nombre;
    private String tipo;
    private Integer valor;

    public item(String id, String nombre, String tipo, Integer valor) {
        this.id = id;
        this.nombre=nombre;
        this.tipo=tipo;
        this.valor=valor;
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
}

