// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar las distintas habilidades disponibles en el juego
import com.juego.habilidades.*;

// Declaración de la clase Paladin
// Implementa la interfaz Clase, por lo que debe definir todos los métodos obligatorios
public class Paladin implements Clase {

    // Devuelve el nombre de la clase/personaje
    // Siempre será "Paladin"
    public String getNombre() {
        return "Paladin";
    }

    // Devuelve la fuerza del Paladín
    // Tiene buena fuerza física, pero no es tan alta como la del Guerrero
    public int f() {
        return 2;
    }

    // Devuelve la inteligencia del Paladín
    // Usa magia sagrada, por eso tiene algo de inteligencia
    public int i() {
        return 1;
    }

    // Devuelve la destreza del Paladín
    // No destaca por su agilidad
    public int d() {
        return 0;
    }

    // Devuelve la vida máxima del Paladín
    // Es resistente gracias a su armadura y fe
    public int vida() {
        return 115;
    }

    // Devuelve un arreglo con las habilidades del Paladín
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades() {

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Golpe Santo"
                // Daño: 20 (ataque físico con poder sagrado)
                new DanioCuerpo("Golpe Santo", 20),

                // Habilidad de curación cuerpo a cuerpo
                // Nombre: "Luz Sanadora"
                // Cura: 25 (curación fuerte, especialidad del Paladín)
                new CuraCuerpo("Luz Sanadora", 25),

                // Habilidad de daño a distancia
                // Nombre: "Castigo"
                // Daño: 20 (ataque sagrado a distancia)
                new DanioDistancia("Castigo ", 20)
        };
    }
}
