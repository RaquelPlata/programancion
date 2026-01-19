package com.juego.presentacion;

import com.juego.modelo.Personaje;
import java.util.List;

// Clase base para la vista del juego
// Define los métodos que cualquier tipo de vista debe implementar
public class Vista {

    // Muestra el menú principal
    public void menu() {

    }

    // Lee una opción numérica del usuario
    public int leer() {
        return 0;
    }

    // Lee texto ingresado por el usuario
    public String leerTexto() {
        return "";
    }

    // Muestra un mensaje en pantalla
    public void mensaje(String m) {

    }

    // Pide un número al usuario mostrando un mensaje
    public int pedir(String m) {
        return 0;
    }

    // Lista los personajes disponibles
    public void listar(List<Personaje> p) {

    }
}