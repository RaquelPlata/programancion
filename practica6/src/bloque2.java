
import java.util.*;

public class bloque2 {
    public static void main() {
        System.out.println("\n Bloque2");

        // Ejercicio7
        System.out.println("\n Ejercicio 7: El Repositorio de Gremios");
        HashMap<String, ArrayList<String>> gremios = new HashMap<>();

        ArrayList<String> guerreros = new ArrayList<>();
        guerreros.add("Maria");
        guerreros.add("Juan");
        guerreros.add("Raquel");
        ArrayList<String> magos = new ArrayList<>();
        magos.add("Pingo");
        magos.add("Clau");
        magos.add("Judas"); //Judas para el ejercicio 10

        gremios.put("Guerreros", guerreros);
        gremios.put("Magos", magos);

        imprimirMiembrosGremio(gremios, "Magos");

        // Ejercicio8
        System.out.println("\n Ejercicio 8: El Sistema de Cosas ");
        HashMap<String, HashSet<String>> loot = new HashMap<>();
        HashSet<String> CosasTrasgo = new HashSet<>();
        CosasTrasgo.add("Espada Oxidada");
        CosasTrasgo.add("Moneda de Oro");
        loot.put("Trasgo", CosasTrasgo);

        // Intento de añadir duplicado
        boolean duplicado = loot.get("Trasgo").add("Espada Oxidada");
        System.out.println("¿Se añadió 'Espada Oxidada' otra vez?: " + duplicado);
        System.out.println("Loot del Trasgo: " + loot.get("Trasgo"));

        // Ejercicio9
        System.out.println("\n Ejercicio 9: Rastreador de Estadísticas ");
        HashMap<String, HashMap<String, Integer>> estadisticas = new HashMap<>();

        HashMap<String, Integer> statsConan = new HashMap<>();
        statsConan.put("Fuerza", 18);
        statsConan.put("Destreza", 12);
        estadisticas.put("Conan", statsConan);

        if (estadisticas.containsKey("Conan")) {
            HashMap<String, Integer> stats = estadisticas.get("Conan");
            if (stats.containsKey("Fuerza")) {
                stats.put("Fuerza", stats.get("Fuerza") + 2);
                System.out.println("Nueva fuerza de Conan: " + stats.get("Fuerza"));
            }
        }

        // Ejercicio10
        System.out.println("\n Ejercicio 10: El Buscador de Traidores ");
        buscarYEliminarTraidor(gremios, "Judas");
    }

    private static void imprimirMiembrosGremio(HashMap<String, ArrayList<String>> gremios, String nombreGremio) {
        if (gremios.containsKey(nombreGremio)) {
            System.out.println("Miembros de " + nombreGremio + ": " + gremios.get(nombreGremio));
        } else {
            System.out.println("Gremio no encontrado.");
        }
    }

    private static void buscarYEliminarTraidor(HashMap<String, ArrayList<String>> gremios, String traidor) {
        for (Map.Entry<String, ArrayList<String>> entry : gremios.entrySet()) {
            ArrayList<String> miembros = entry.getValue();
            if (miembros.contains(traidor)) {
                System.out.println("¡Traidor " + traidor + " encontrado en el gremio " + entry.getKey() + "!");
                miembros.remove(traidor);
                System.out.println("Traidor eliminado. Miembros restantes: " + miembros);
                return; // Asumimos que solo está en un gremio
            }
        }
        System.out.println("Traidor no encontrado.");
    }
}

