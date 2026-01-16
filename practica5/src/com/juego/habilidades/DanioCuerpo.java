
// Indica que esta clase pertenece al paquete com.juego.habilidades
package com.juego.habilidades;

// Declaración de la clase DanioCuerpo
// Implementa la interfaz Habilidad, por lo que debe definir sus métodos
public class DanioCuerpo implements Habilidad {

    // Cantidad de veces que se puede usar esta habilidad
    // Los ataques físicos suelen poder usarse más que las curaciones
    private int usos = 5;

    // Valor de daño que inflige cada vez que se usa
    private int valor;

    // Nombre de la habilidad (por ejemplo, "Golpe Fuerte")
    private String nombre;

    // Constructor de la clase
    // Se recibe el nombre de la habilidad y la cantidad de daño que hace
    public DanioCuerpo(String nombre,int valor){
        this.nombre = nombre; // Guarda el nombre
        this.valor = valor;   // Guarda el daño que inflige
    }

    // Devuelve el nombre de la habilidad y cuántos usos quedan
    public String getNombre(){
        return nombre + " (" + usos + " usos)";
    }

    // Usa la habilidad
    // Disminuye la cantidad de usos y devuelve el daño infligido
    public int usar(){
        usos--;    // Restar un uso
        return valor; // Retorna el daño
    }

    // Indica si la habilidad todavía tiene usos disponibles
    public boolean tieneUsos(){
        return usos > 0; // Devuelve true si hay usos restantes
    }
}
