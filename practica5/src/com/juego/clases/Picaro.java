// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar los distintos tipos de habilidades del juego
import com.juego.habilidades.*;

// Declaración de la clase Picaro
// Implementa la interfaz Clase, por lo que debe definir todos los métodos obligatorios
public class Picaro implements Clase {

    // Devuelve el nombre de la clase/personaje
    // Siempre devuelve "Picaro"
    public String getNombre(){
        return "Picaro";
    }

    // Devuelve la fuerza del Pícaro
    // No basa su daño en fuerza bruta
    public int f(){
        return 0;
    }

    // Devuelve la inteligencia del Pícaro
    // No usa magia ni conocimientos especiales
    public int i(){
        return 0;
    }

    // Devuelve la destreza del Pícaro
    // Es su atributo principal, por eso es alto (3)
    public int d(){
        return 3;
    }

    // Devuelve la vida máxima del Pícaro
    // Tiene buena supervivencia, pero no es un tanque
    public int vida(){
        return 105;
    }

    // Devuelve un arreglo con las habilidades del Pícaro
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Puñalada"
                // Daño: 22 (ataque rápido y preciso)
                new DanioCuerpo("Puñalada",22),

                // Habilidad de curación / escape
                // Nombre: "Escape"
                // Cura: 6 (representa huir y recuperarse un poco)
                new CuraCuerpo("Escape",6),

                // Habilidad de daño a distancia
                // Nombre: "Disparo Rápido"
                // Daño: 20 (ataque veloz desde lejos)
                new DanioDistancia("Disparo Rápido",20)
        };
    }
}
