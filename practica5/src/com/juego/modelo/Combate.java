package com.juego.modelo;

import java.util.*;
import com.juego.habilidades.*;

// Clase que maneja un combate entre dos personajes
public class Combate {

    private Scanner sc = new Scanner(System.in);

    // Inicia el combate entre dos personajes
    public void iniciar(Personaje a, Personaje b) {

        Personaje t = a; // jugador con turno
        Personaje r = b; // rival

        while (a.getVida() > 0 && b.getVida() > 0) {

            System.out.println("\nTurno: " + t.getNombre());

            // Mostrar habilidades disponibles con sus usos
            int i = 1;
            for (Habilidad h : t.getHabilidades()) {
                System.out.println(i++ + ". " + h.getNombre() + " (Usos: " + h.getUsosRestantes() + ")");
            }

            // Leer habilidad elegida
            int op;
            while (true) {
                System.out.print("Elige habilidad: ");
                if (sc.hasNextInt()) {
                    op = sc.nextInt() - 1;
                    sc.nextLine(); // limpiar buffer
                    if (op >= 0 && op < t.getHabilidades().size()) {
                        Habilidad h = t.getHabilidades().get(op);
                        if (h.tieneUsos()) {
                            int v = h.usar();

                            // Diferencia curación de daño
                            if (h instanceof CuraCuerpo) {
                                t.curar(v);
                                System.out.println(t.getNombre() + " se cura " + v + " HP");
                            } else {
                                r.danio(v);
                                System.out.println(t.getNombre() + " hace " + v + " de daño a " + r.getNombre());
                            }
                            break;
                        } else {
                            System.out.println("Sin usos! Elige otra habilidad.");
                        }
                    } else {
                        System.out.println("Opción inválida, elige otra habilidad.");
                    }
                } else {
                    System.out.println("Por favor ingresa un número válido.");
                    sc.nextLine(); // limpiar entrada inválida
                }
            }

            // Mostrar estado actual
            System.out.println(a.getNombre() + ": " + a.getVida() + " HP");
            System.out.println(b.getNombre() + ": " + b.getVida() + " HP");

            // Cambiar turno
            Personaje aux = t;
            t = r;
            r = aux;
        }

        // Mostrar ganador
        System.out.println("\nGANADOR: " + (a.getVida() > 0 ? a.getNombre() : b.getNombre()));
    }
}