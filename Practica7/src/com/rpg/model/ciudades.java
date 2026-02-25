package com.rpg.model;

public class ciudades {
    private String nombre;
    private Integer poblacion;
    private String clima;
    private Integer nivel_riesgo;

    public ciudades (String nombre,Integer poblacion,String clima ,Integer nivel_riesgo){
        this.nombre=nombre;
        this.poblacion=poblacion;
        this.clima=clima;
        this.nivel_riesgo=nivel_riesgo;
    }

    //Metodo get

    public String getNombre() {
        return nombre;
    }
    public Integer getPoblacion(){
        return poblacion;
    }
    public String getClima(){
        return clima;
    }
    public Integer getNivel_riesgo(){
        return nivel_riesgo;
    }

    //Metodo set


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setNivel_riesgo(Integer nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }
}
