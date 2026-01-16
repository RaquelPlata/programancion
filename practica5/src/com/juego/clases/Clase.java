// Indica que esta interfaz pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Esto permite usar el tipo Habilidad dentro de la interfaz
import com.juego.habilidades.*;

// Declaración de la interfaz Clase
// Una interfaz define qué métodos DEBEN tener las clases que la implementen
public interface Clase {

    // Metodo que obliga a devolver el nombre de la clase/personaje
    // Ejemplo: "Bardo", "Guerrero", "Mago", etc.
    String getNombre();

    // Metodo que devuelve la fuerza del personaje
    int f();

    // Metodo que devuelve la inteligencia del personaje
    int i();

    // Metodo que devuelve la destreza del personaje
    int d();

    // Metodo que devuelve la cantidad de vida máxima del personaje
    int vida();

    // Metodo que devuelve un arreglo de habilidades
    // Todas las clases (Bardo, Guerrero, etc.) deben definir sus propias habilidades
    Habilidad[] getHabilidades();
}
