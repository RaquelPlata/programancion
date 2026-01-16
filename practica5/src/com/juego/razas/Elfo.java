// Indica que esta clase pertenece al paquete com.juego.razas
package com.juego.razas;

// Declaración de la clase Elfo
// Implementa la interfaz Raza, por lo que debe definir todos los métodos obligatorios
public class Elfo implements Raza {

    // Devuelve el nombre de la raza
    // Siempre será "Elfo"
    public String getNombre(){
        return "Elfo";
    }

    // Devuelve la fuerza base de la raza Elfo
    // Es moderada, no es su atributo principal
    public int f(){
        return 4;
    }

    // Devuelve la inteligencia base de la raza Elfo
    // Es alta, ya que los elfos suelen ser sabios y astutos
    public int i(){
        return 6;
    }

    // Devuelve la destreza base de la raza Elfo
    // Es muy alta, representando agilidad y rapidez
    public int d(){
        return 7;
    }

    // Devuelve la vida base de la raza Elfo
    // Menor que la de un humano o guerrero, ya que son más frágiles
    public int vida(){
        return 90;
    }
}
