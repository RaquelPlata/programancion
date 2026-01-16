// Indica que esta clase pertenece al paquete com.juego.habilidades
package com.juego.habilidades;

// Declaración de la clase CuraCuerpo
// Implementa la interfaz Habilidad, por lo que debe definir sus métodos
public class CuraCuerpo implements Habilidad {

    // Cantidad de veces que se puede usar esta habilidad
    private int usos = 3;

    // Valor de curación que otorga cada vez que se usa
    private int valor;

    // Nombre de la habilidad (por ejemplo, "Canción Sanadora")
    private String nombre;

    // Constructor de la clase
    // Se recibe el nombre de la habilidad y el valor de curación
    public CuraCuerpo(String nombre,int valor){
        this.nombre = nombre; // Guarda el nombre
        this.valor = valor;   // Guarda la cantidad de curación
    }

    // Devuelve el nombre de la habilidad y cuántos usos quedan
    public String getNombre(){
        return nombre + " (" + usos + " usos)";
    }

    // Usa la habilidad
    // Disminuye la cantidad de usos y devuelve el valor de curación
    public int usar(){
        usos--; // Restar un uso
        return valor; // Retorna la cantidad de curación
    }

    // Indica si la habilidad todavía tiene usos disponibles
    public boolean tieneUsos(){
        return usos > 0; // Devuelve true si hay usos restantes
    }
}
