// Indica que esta interfaz pertenece al paquete com.juego.razas
package com.juego.razas;

// Declaración de la interfaz Raza
// Define los métodos que toda raza del juego debe implementar
public interface Raza {

    // Metodo que devuelve el nombre de la raza
    // Ejemplo: "Humano", "Elfo", "Enano"
    String getNombre();

    // Metodo que devuelve la fuerza base de la raza
    // Representa la capacidad física del personaje
    int f();

    // Metodo que devuelve la inteligencia base de la raza
    // Representa el poder mágico o astucia del personaje
    int i();

    // Metodo que devuelve la destreza base de la raza
    // Representa la agilidad, velocidad o precisión
    int d();

    // Metodo que devuelve la vida base de la raza
    // Representa cuánta salud inicial tiene el personaje
    int vida();
}
