// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Esto permite usar clases como DanioCuerpo, CuraCuerpo, etc.
import com.juego.habilidades.*;

// Declaración de la clase Bardo
// "implements Clase" significa que Bardo cumple el contrato de la interfaz Clase
public class Bardo implements Clase {

    // Metodo que devuelve el nombre de la clase/personaje
    // En este caso, siempre devuelve "Bardo"
    public String getNombre(){
        return "Bardo";
    }

    // Metodo que devuelve la fuerza del Bardo
    // El Bardo no es fuerte físicamente, por eso devuelve 0
    public int f(){
        return 0;
    }

    // Metodo que devuelve la inteligencia del Bardo
    // El Bardo tiene buena inteligencia, por eso devuelve 3
    public int i(){
        return 3;
    }

    // Metodo que devuelve la destreza del Bardo
    // Aquí se indica que no destaca en destreza
    public int d(){
        return 0;
    }

    // Metodo que devuelve la vida máxima del Bardo
    // El Bardo tiene 90 puntos de vida
    public int vida(){
        return 90;
    }

    // Metodo que devuelve un arreglo (array) de habilidades
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve un array con las habilidades del Bardo
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Ataque Melódico"
                // Daño: 25
                new DanioCuerpo("Ataque Melódico",25),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Canción Sanadora"
                // Cura: 15
                new CuraCuerpo("Canción Sanadora",15),

                // Habilidad de daño a distancia
                // Nombre: "Eco Doloroso"
                // Daño: 22
                new DanioDistancia("Eco Doloroso ",22)
        };
    }
}
