// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar DanioCuerpo, CuraCuerpo y DanioDistancia
import com.juego.habilidades.*;

// Declaración de la clase Mago
// Implementa la interfaz Clase, por lo que debe cumplir con todos sus métodos
public class Mago implements Clase {

    // Devuelve el nombre de la clase/personaje
    // En este caso, siempre devuelve "Mago"
    public String getNombre(){
        return "Mago";
    }

    // Devuelve la fuerza del Mago
    // No tiene fuerza física
    public int f(){
        return 0;
    }

    // Devuelve la inteligencia del Mago
    // Es su atributo principal, por eso tiene un valor alto (3)
    public int i(){
        return 3;
    }

    // Devuelve la destreza del Mago
    // No destaca en destreza
    public int d(){
        return 0;
    }

    // Devuelve la vida máxima del Mago
    // Tiene menos vida porque es un personaje frágil
    public int vida(){
        return 90;
    }

    // Devuelve un arreglo con las habilidades del Mago
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Toque Mágico"
                // Daño: 13 (bajo, porque no es su fuerte)
                new DanioCuerpo("Toque Mágico",13),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Sanación Arcana"
                // Cura: 10
                new CuraCuerpo("Sanación Arcana",10),

                // Habilidad de daño a distancia
                // Nombre: "Rayo Mágico"
                // Daño: 35 (muy alto, su ataque principal)
                new DanioDistancia("Rayo Mágico",35)
        };
    }
}
