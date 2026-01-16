// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Esto permite usar clases como DanioCuerpo, CuraCuerpo y DanioDistancia
import com.juego.habilidades.*;

// Declaración de la clase Guerrero
// Implementa la interfaz Clase, por lo que debe definir todos los métodos obligatorios
public class Guerrero implements Clase {

    // Devuelve el nombre de la clase/personaje
    // Siempre devuelve "Guerrero"
    public String getNombre(){
        return "Guerrero";
    }

    // Devuelve la fuerza del Guerrero
    // Es su atributo principal, por eso es alto (3)
    public int f(){
        return 3;
    }

    // Devuelve la inteligencia del Guerrero
    // No destaca en inteligencia, por eso devuelve 0
    public int i(){
        return 0;
    }

    // Devuelve la destreza del Guerrero
    // En este caso no se utiliza, por eso devuelve 0
    public int d(){
        return 0;
    }

    // Devuelve la vida máxima del Guerrero
    // Tiene mucha vida porque es un combatiente cuerpo a cuerpo resistente
    public int vida(){
        return 120;
    }

    // Devuelve un arreglo con las habilidades del Guerrero
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Golpe Fuerte"
                // Daño: 25
                new DanioCuerpo("Golpe Fuerte",25),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Resistencia"
                // Cura: 5 (representa aguante o recuperación leve)
                new CuraCuerpo(" Resistencia",5),

                // Habilidad de daño a distancia
                // Nombre: "Lanzamiento"
                // Daño: 10
                new DanioDistancia("Lanzamiento",10)
        };
    }
}
