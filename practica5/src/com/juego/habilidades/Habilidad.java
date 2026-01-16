// Indica que esta interfaz pertenece al paquete com.juego.habilidades
package com.juego.habilidades;

// Declaración de la interfaz Habilidad
// Una interfaz define qué métodos DEBEN tener todas las habilidades
public interface Habilidad {

    // Metodo que devuelve el nombre de la habilidad
    // Por ejemplo: "Puñalada", "Rayo Mágico" o "Curación"
    String getNombre();

    // Metodo que aplica la habilidad
    // Devuelve un valor numérico, que puede ser daño o curación
    int usar();

    // Metodo que indica si la habilidad todavía tiene usos disponibles
    // Devuelve true si todavía se puede usar la habilidad, false si ya no
    boolean tieneUsos();
}
