package com.juego.habilidades;

// Clase que representa una habilidad de daño a distancia
public class DanioDistancia implements Habilidad {

    // Cantidad de usos restantes de la habilidad
    private int usos = 1;

    // Valor del daño que causa la habilidad
    private int valor;

    // Nombre de la habilidad
    private String nombre;

    // Constructor: recibe el nombre de la habilidad y el valor de daño
    public DanioDistancia(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    // Devuelve el nombre de la habilidad junto con los usos restantes
    public String getNombre(){
        return nombre + " (" + usos + " usos)";
    }

    // Usa la habilidad: decrementa los usos y devuelve el valor de daño
    public int usar(){
        usos--;           // Resta un uso
        return valor;     // Devuelve el daño que aplica
    }

    // Indica si la habilidad aún tiene usos disponibles
    public boolean tieneUsos(){
        return usos > 0;
    }
    @Override
    public int getUsosRestantes() {
        return usos;
    }
}