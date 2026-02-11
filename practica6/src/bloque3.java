import java.util.*;

public class bloque3 {

    public static void main(String[] args) {

        // EJERCICIO 11
        // Mapa que almacena el precio base de cada objeto
        HashMap<String, Double> precios = new HashMap<>();
        precios.put("Espada", 100.0);     // Precio de la espada
        precios.put("Escudo", 120.0);     // Precio del escudo
        precios.put("Poción", 25.0);      // Precio de la poción
        precios.put("Armadura", 250.0);   // Precio de la armadura
        precios.put("Casco", 90.0);       // Precio del casco
        precios.put("Anillo", 300.0);     // Precio del anillo

        // Mapa que relaciona cada ciudad con los objetos que vende
        HashMap<String, ArrayList<String>> ciudades = new HashMap<>();
        // Se añaden todos los objetos disponibles en la ciudad de Arcos
        ciudades.put("Arcos", new ArrayList<>(Arrays.asList(
                "Espada", "Escudo", "Poción", "Armadura", "Casco", "Anillo")));

        System.out.println("EJERCICIO 11");

        // Se calculan los precios finales según la ciudad indicada
        HashMap<String, Double> preciosFinales =
                obtenerPreciosCiudad("Arcos", precios, ciudades);

        // Se muestran los precios finales de cada objeto
        for (String item : preciosFinales.keySet()) {
            System.out.println(item + " -> " + preciosFinales.get(item));
        }

        //EJERCICIO 12
        System.out.println("\nEJERCICIO 12");

        // Árbol de habilidades que guarda clases y sus habilidades
        HashMap<String, HashMap<String, Boolean>> habilidades = new HashMap<>();

        // Habilidades específicas del Paladín
        HashMap<String, Boolean> paladin = new HashMap<>();
        paladin.put("Enfoque", true);        // Habilidad inicial desbloqueada
        paladin.put("Golpe Divino", false);  // Habilidad bloqueada al inicio
        habilidades.put("Paladín", paladin);

        // Se intenta desbloquear la habilidad Golpe Divino
        desbloquearGolpeDivino(habilidades, "Paladín");

        // EJERCICIO 13
        System.out.println("\nEJERCICIO 13");

        // Mapa que guarda las mazmorras con sus raids asociados
        HashMap<String, List<HashSet<String>>> raids = new HashMap<>();

        // Grupos de jugadores que participan en cada raid
        HashSet<String> r1 = new HashSet<>(Arrays.asList("Raquel", "Pedro", "Mario"));
        HashSet<String> r2 = new HashSet<>(Arrays.asList("Piedad", "Pepe"));
        HashSet<String> r3 = new HashSet<>(Arrays.asList("Raquel", "Ana"));

        // Se asocian los raids a la Mazmorra Verde
        raids.put("Mazmorra Verde", new ArrayList<>(Arrays.asList(r1, r2, r3)));

        // Se muestran las estadísticas de participación
        mostrarEstadisticasRaids(raids);

        // EJERCICIO 14
        System.out.println("\nEJERCICIO 14");

        // Mapa que almacena los mensajes enviados por cada jugador
        HashMap<String, List<String>> mensajes = new HashMap<>();
        mensajes.put("raquel",
                new ArrayList<>(Arrays.asList("Hola", "Vendo espada", "Vendo espada")));
        mensajes.put("Pepe",
                new ArrayList<>(Arrays.asList("Hola", "Busco grupo", "Gracias")));

        // Se filtran los jugadores que hacen spam
        System.out.println("Silenciados: " + filtrarSpam(mensajes));

        // EJERCICIO 15
        System.out.println("\nEJERCICIO 15");

        // Se crea la casa de subastas
        Subastas casa = new Subastas();

        // Registro de jugadores y su dinero inicial
        casa.añadirJugador("raquel", 700);
        casa.añadirJugador("Pepe", 500);

        // Se añade un objeto a subastar
        casa.añadirItem("Excalibur");

        // Se registran las pujas de los jugadores
        casa.añadirPuja("Excalibur", new Pujas("raquel", 450));
        casa.añadirPuja("Excalibur", new Pujas("Pepe", 350));
        casa.añadirPuja("Excalibur", new Pujas("raquel", 200));

        // Se procesa la subasta y se asigna el objeto
        casa.procesarVenta("Excalibur");

        // Se muestran los saldos finales
        casa.mostrarSaldos();
    }

    // FUNCIONES

    // EJERCICIO 11: Cálculo de precios según la ciudad
    public static HashMap<String, Double> obtenerPreciosCiudad(
            String ciudad,
            HashMap<String, Double> preciosBase,
            HashMap<String, ArrayList<String>> ciudades) {

        // Mapa donde se guardarán los precios calculados
        HashMap<String, Double> preciosFinales = new HashMap<>();

        // Lista de objetos disponibles en la ciudad
        ArrayList<String> items = ciudades.get(ciudad);

        // Se aplica un impuesto si la ciudad vende muchos objetos
        boolean impuestoLujo = items.size() > 5;

        // Se calcula el precio final de cada objeto
        for (String item : items) {
            double precio = preciosBase.get(item);
            if (impuestoLujo) {
                precio *= 1.10;
            }
            preciosFinales.put(item, precio);
        }

        return preciosFinales;
    }

    // EJERCICIO 12: Desbloqueo de habilidades
    public static void desbloquearGolpeDivino(
            HashMap<String, HashMap<String, Boolean>> arbol,
            String clase) {

        // Obtiene el conjunto de habilidades de la clase
        HashMap<String, Boolean> habilidades = arbol.get(clase);

        // Verifica si la habilidad previa está desbloqueada
        if (!habilidades.get("Enfoque")) {
            System.out.println("Error: primero debes desbloquear Enfoque.");
            return;
        }

        // Desbloquea la nueva habilidad
        habilidades.put("Golpe Divino", true);
        System.out.println("Golpe Divino desbloqueado.");
    }

    // EJERCICIO 13: Estadísticas de raids
    public static void mostrarEstadisticasRaids(
            HashMap<String, List<HashSet<String>>> historial) {

        // Mapa que cuenta cuántas veces participa cada jugador
        HashMap<String, Integer> contador = new HashMap<>();

        // Se recorren todas las mazmorras y sus raids
        for (List<HashSet<String>> raids : historial.values()) {
            for (HashSet<String> raid : raids) {
                for (String jugador : raid) {
                    contador.put(jugador,
                            contador.getOrDefault(jugador, 0) + 1);
                }
            }
        }

        System.out.println("Participaciones por jugador:");
        for (Map.Entry<String, Integer> e : contador.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Búsqueda del jugador con más participaciones
        String mvp = null;
        int max = 0;

        for (Map.Entry<String, Integer> e : contador.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                mvp = e.getKey();
            }
        }

        System.out.println("Jugador más valioso: " + mvp);
        System.out.println("Participaciones totales: " + max);
    }

    // EJERCICIO 14: Detección de spam
    public static HashSet<String> filtrarSpam(
            HashMap<String, List<String>> mensajes) {

        // Conjunto donde se guardan los jugadores sancionados
        HashSet<String> silenciados = new HashSet<>();

        // Revisión de los mensajes de cada jugador
        for (String jugador : mensajes.keySet()) {

            List<String> lista = mensajes.get(jugador);
            if (lista.size() < 3) continue;

            // Se toman los tres últimos mensajes enviados
            List<String> ultimosTres =
                    lista.subList(lista.size() - 3, lista.size());

            // Si hay mensajes repetidos, se considera spam
            if (new HashSet<>(ultimosTres).size() < ultimosTres.size()) {
                silenciados.add(jugador);
                lista.clear();
            }
        }

        return silenciados;
    }
}
