package rpg.logic;

import rpg.model.*;
import rpg.dao.PersonajeDAO;
import rpg.utils.Log;
import java.util.Map;
import java.util.Scanner;

public class Combate {
    private PersonajeDAO pDAO;
    private Scanner sc = new Scanner(System.in);

    public Combate(PersonajeDAO pDAO) {
        this.pDAO = pDAO;
    }

    public void iniciarCombate(personaje p1, personaje p2) {
        Log.Error("Inicio de combate: " + p1.getNombre() + " vs " + p2.getNombre());

        // CÁLCULO ESTADÍSTICAS
        int atk1 = p1.getRaza().getBonificador_fuerza() + calcularBonusAtk(p1);
        int def1 = calcularBonusDef(p1);
        int atk2 = p2.getRaza().getBonificador_fuerza() + calcularBonusAtk(p2);
        int def2 = calcularBonusDef(p2);

        while (p1.getVida_actual() > 0 && p2.getVida_actual() > 0) {
            ejecutarTurno(p1, p2, def2);
            if (p2.getVida_actual() <= 0) break;
            ejecutarTurno(p2, p1, def1);
        }

        finalizarCombate(p1, p2);
    }

    private void ejecutarTurno(personaje atacante, personaje defensor, int defDefensor) {
        System.out.println("\nTurno de " + atacante.getNombre() + " (HP: " + atacante.getVida_actual() + ")");
        System.out.println("1. Usar Habilidad  2. Ataque Básico");
        int op = Integer.parseInt(sc.nextLine());

        int dano = 0;
        if (op == 1) {
            // Lógica simplificada de selección de habilidad equipada
            for (Map.Entry<habilidad, Boolean> entry : atacante.getHabilidades().entrySet()) {
                if (entry.getValue()) { // Si está equipada [cite: 386]
                    dano = entry.getKey().getDanio_base() - (defDefensor / 2);
                    System.out.println("Usa " + entry.getKey().getNombre());
                    break;
                }
            }
        } else {
            dano = (atacante.getRaza().getBonificador_fuerza()) - (defDefensor / 2);
        }

        dano = Math.max(1, dano);
        defensor.setVida_actual(defensor.getVida_actual() - dano);
        System.out.println("¡Realiza " + dano + " de daño!");
    }

    private int calcularBonusAtk(personaje p) {
        return 0;
    }

    private int calcularBonusDef(personaje p) { return 0; }

    private void finalizarCombate(personaje p1, personaje p2) {
        personaje ganador = (p1.getVida_actual() > 0) ? p1 : p2;
        personaje perdedor = (ganador == p1) ? p2 : p1;

        int oroRobado = (int) (perdedor.getOro() * 0.20);
        ganador.setOro(ganador.getOro() + oroRobado);
        perdedor.setOro(perdedor.getOro() - oroRobado);

        pDAO.actualizarOro(ganador);
        pDAO.actualizarOro(perdedor);

        System.out.println("Ganador: " + ganador.getNombre() + ". Roba " + oroRobado + " de oro.");
        Log.Error("Combate finalizado. Ganador: " + ganador.getNombre());
    }
}