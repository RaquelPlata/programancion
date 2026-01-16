// Indica que esta clase pertenece al paquete com.juego.clases
package com.juego.clases;

// Importa todas las clases del paquete com.juego.habilidades
// Permite usar DanioCuerpo, CuraCuerpo y DanioDistancia
import com.juego.habilidades.*;

// Declaración de la clase Sacerdote
// Implementa la interfaz Clase, por lo que debe definir todos los métodos obligatorios
public class Sacerdote implements Clase {

    // Devuelve el nombre de la clase/personaje
    // Siempre será "Sacerdote"
    public String getNombre(){
        return "Sacerdote";
    }

    // Devuelve la fuerza del Sacerdote
    // No tiene fuerza física significativa
    public int f(){
        return 0;
    }

    // Devuelve la inteligencia del Sacerdote
    // Es su atributo principal, ya que usa magia de curación y sagrada
    public int i(){
        return 3;
    }

    // Devuelve la destreza del Sacerdote
    // No destaca en agilidad
    public int d(){
        return 0;
    }

    // Devuelve la vida máxima del Sacerdote
    // Tiene menos vida que un Guerrero o Paladín, pero suficiente para sobrevivir
    public int vida() {
        return 95;
    }

    // Devuelve un arreglo con las habilidades del Sacerdote
    // Cada habilidad es un objeto de tipo Habilidad
    public Habilidad[] getHabilidades(){

        // Se crea y devuelve el array de habilidades
        return new Habilidad[]{

                // Habilidad de daño cuerpo a cuerpo
                // Nombre: "Bastón Sagrado"
                // Daño: 14 (ataque físico moderado)
                new DanioCuerpo("Bastón Sagrado",14),

                // Habilidad de curación
                // Nombre: "Curación"
                // Cura: 25 (muy potente, especialidad del Sacerdote)
                new CuraCuerpo("Curación",25),

                // Habilidad de daño a distancia
                // Nombre: "Luz Castigadora"
                // Daño: 12 (ataque mágico sagrado a distancia)
                new DanioDistancia("Luz Castigadora",12)
        };
    }
}
