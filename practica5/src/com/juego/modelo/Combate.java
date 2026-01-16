package com.juego.modelo;

import java.util.*;
import com.juego.habilidades.*;

// Clase que maneja el combate entre dos personajes
public class Combate {

    // Scanner para leer la entrada del usuario desde la consola
    private Scanner sc = new Scanner(System.in);

    // Metodo que inicia el combate entre dos personajes
    public void iniciar(Personaje a, Personaje b) {

        // 't' es el personaje que tiene el turno actual
        // 'r' es el personaje rival
        Personaje t = a;
        Personaje r = b;

        // Ciclo principal: se repite mientras ambos personajes tengan vida
        while (a.getVida() > 0 && b.getVida() > 0) {

            System.out.println("\nTurno: " + t.getNombre());

            // Mostrar las habilidades disponibles del personaje actual
            int i = 1;
            for (Habilidad h : t.getHabilidades()) {
                System.out.println(i++ + ". " + h.getNombre());
            }

            // Leer la opción elegida por el usuario y ajustar al índice de lista
            int op = sc.nextInt() - 1;

            // Validar opción ingresada
            if (op < 0 || op >= t.getHabilidades().size()) {
                System.out.println("Opción inválida, elige otra habilidad.");
                continue;
            }

            Habilidad h = t.getHabilidades().get(op);

            // Verificar si la habilidad tiene usos disponibles
            if (!h.tieneUsos()) {
                System.out.println("Sin usos! Elige otra habilidad.");
                continue; // Mantiene el turno hasta elegir habilidad válida
            }

            // Usar la habilidad y obtener el valor del efecto (daño o curación)
            int v = h.usar();

            // Aplicar efecto según el tipo de habilidad
            if (h instanceof CuraCuerpo) {
                // Si es de curación, se aplica al personaje que usa la habilidad
                t.curar(v);
                System.out.println(t.getNombre() + " se cura " + v + " HP");
            } else {
                // Si es daño, se aplica al rival
                r.danio(v);
                System.out.println(t.getNombre() + " hace " + v + " de daño a " + r.getNombre());
            }

            // Mostrar estado actual de ambos personajes
            System.out.println(a.getNombre() + ": " + a.getVida() + " HP");
            System.out.println(b.getNombre() + ": " + b.getVida() + " HP");

            // Cambiar turno: el rival pasa a ser el atacante
            Personaje aux = t;
            t = r;
            r = aux;
        }

        // Mostrar ganador del combate
        System.out.println("\nGANADOR: " + (a.getVida() > 0 ? a.getNombre() : b.getNombre()));
    }
}