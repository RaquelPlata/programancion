// Indica que esta clase pertenece al paquete com.juego.razas
package com.juego.razas;

// Declaración de la clase Humano
// Implementa la interfaz Raza, por lo que debe definir todos los métodos obligatorios
public class Humano implements Raza {

    // Devuelve el nombre de la raza
    // Siempre será "Humano"
    public String getNombre(){
        return "Humano";
    }

    // Devuelve la fuerza base de la raza Humano
    // Moderada, equilibrada entre todas las estadísticas
    public int f(){
        return 5;
    }

    // Devuelve la inteligencia base de la raza Humano
    // Moderada, equilibrada
    public int i(){
        return 5;
    }

    // Devuelve la destreza base de la raza Humano
    // Moderada, equilibrada
    public int d(){
        return 5;
    }

    // Devuelve la vida base de la raza Humano
    // Media, reflejando equilibrio general
    public int vida(){
        return 100;
    }
}
