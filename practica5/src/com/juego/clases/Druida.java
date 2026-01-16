// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar DanioCuerpo, CuraCuerpo, DanioDistancia, etc.
import com.juego.habilidades.*;

// Declaración de la clase Druida
// Implementa la interfaz Clase, por lo que debe definir todos sus métodos
public class Druida implements Clase {

    // Devuelve el nombre de la clase/personaje
    // En este caso, siempre será "Druida"
    public String getNombre(){
        return "Druida";
    }

    // Devuelve la fuerza del Druida
    // Tiene fuerza moderada gracias a su conexión con la naturaleza
    public int f(){
        return 2;
    }

    // Devuelve la inteligencia del Druida
    // Tiene algo de inteligencia, pero no es su atributo principal
    public int i(){
        return 1;
    }

    // Devuelve la destreza del Druida
    // No destaca en destreza, por eso devuelve 0
    public int d(){
        return 0;
    }

    // Devuelve la vida máxima del Druida
    // Tiene más vida que el Bardo, ya que es más resistente
    public int vida(){
        return 100;
    }

    // Devuelve un arreglo con las habilidades del Druida
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Garra Natural"
                // Daño: 15
                new DanioCuerpo("Garra Natural",15),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Aliento Vital"
                // Cura: 10
                new CuraCuerpo("Aliento Vital",10),

                // Habilidad de daño a distancia
                // Nombre: "Espina"
                // Daño: 25
                new DanioDistancia(" Espina ",25)
        };
    }
}
