// Indica que esta clase pertenece al paquete com.juego.razas
package com.juego.razas;

// Declaración de la clase Enano
// Implementa la interfaz Raza, por lo que debe definir todos los métodos obligatorios
public class Enano implements Raza {

    // Devuelve el nombre de la raza
    // Siempre será "Enano"
    public String getNombre(){
        return "Enano";
    }

    // Devuelve la fuerza base de la raza Enano
    // Muy alta, los enanos son fuertes y resistentes
    public int f(){
        return 7;
    }

    // Devuelve la inteligencia base de la raza Enano
    // Moderada, representan experiencia y sabiduría práctica
    public int i() {
        return 4;
    }

    // Devuelve la destreza base de la raza Enano
    // Moderada, no son especialmente ágiles
    public int d(){
        return 4;
    }

    // Devuelve la vida base de la raza Enano
    // Alta, reflejando resistencia y capacidad de soportar daños
    public int vida(){
        return 110;
    }
}
