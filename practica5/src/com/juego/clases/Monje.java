// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar los distintos tipos de habilidades del juego
import com.juego.habilidades.*;

// Declaración de la clase Monje
// Implementa la interfaz Clase, por lo que debe definir todos los métodos obligatorios
public class Monje implements Clase {

    // Devuelve el nombre de la clase/personaje
    // Siempre será "Monje"
    public String getNombre(){
        return "Monje";
    }

    // Devuelve la fuerza del Monje
    // Tiene buena fuerza física gracias a su entrenamiento corporal
    public int f(){
        return 2;
    }

    // Devuelve la inteligencia del Monje
    // No usa magia ni conocimiento arcano
    public int i(){
        return 0;
    }

    // Devuelve la destreza del Monje
    // Destaca un poco en velocidad y agilidad
    public int d(){
        return 1;
    }

    // Devuelve la vida máxima del Monje
    // Tiene buena resistencia física
    public int vida(){
        return 110;
    }

    // Devuelve un arreglo con las habilidades del Monje
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Puño Rápido"
                // Daño: 10 (bajo, pero puede representar ataques rápidos)
                new DanioCuerpo("Puño Rápido",10),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Aliento Interior"
                // Cura: 8 (autocontrol y energía interna)
                new CuraCuerpo("Aliento Interior",8),

                // Habilidad de daño a distancia
                // Nombre: "Proyección"
                // Daño: 28 (representa energía lanzada o golpe a distancia)
                new DanioDistancia("Proyección  ",28)
        };
    }
}

