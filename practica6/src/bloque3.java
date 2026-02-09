import java.util.*;

public class bloque3 {

    public static void main(String[] args) {

        //Ejercicio11

        HashMap<String, Double> preciosBase = new HashMap<>();
        preciosBase.put("Espada", 100.00);
        preciosBase.put("Escudo", 120.00);
        preciosBase.put("Poción", 25.00);
        preciosBase.put("Armadura", 250.00);
        preciosBase.put("Casco", 90.00);
        preciosBase.put("Anillo", 300.00);

        HashMap<String, ArrayList<String>> ciudades = new HashMap<>();
        ciudades.put("Ventormenta", new ArrayList<>(Arrays.asList(
                "Espada", "Escudo", "Poción", "Armadura", "Casco", "Anillo"
        )));

        HashMap<String, Double> preciosVentormenta =
                obtenerPreciosCiudad("Ventormenta", preciosBase, ciudades);

        System.out.println("\nEJERCICIO 11");
        for (Map.Entry<String, Double> entry : preciosVentormenta.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        //Ejercicio 12

        HashMap<String, HashMap<String, Boolean>> arbolHabilidades = new HashMap<>();

        HashMap<String, Boolean> paladin = new HashMap<>();
        paladin.put("Enfoque", true);
        paladin.put("Golpe Divino", false);

        arbolHabilidades.put("Paladín", paladin);

        System.out.println("\nEJERCICIO 12");
        desbloquearGolpeDivino(arbolHabilidades, "Paladín");


        //Ejercicio 13

        HashMap<String, List<HashSet<String>>> historialRaids = new HashMap<>();

        HashSet<String> raid1 = new HashSet<>(Arrays.asList("Luca", "JUan", "Raquel"));
        HashSet<String> raid2 = new HashSet<>(Arrays.asList("Marco", "Carlos"));
        HashSet<String> raid3 = new HashSet<>(Arrays.asList("Leonardo", "Luis"));

        historialRaids.put("Mazmorra Oscura",
                new ArrayList<>(Arrays.asList(raid1, raid2, raid3)));

        System.out.println("\nEJERCICIO 13");
        mostrarEstadisticasRaids(historialRaids);


        //Ejercicio 14
        HashMap<String, List<String>> mensajes = new HashMap<>();

        mensajes.put("Ana", new ArrayList<>(Arrays.asList(
                "Hola", "Vendo espada", "Vendo espada"
        )));

        mensajes.put("Luis", new ArrayList<>(Arrays.asList(
                "Hola", "Busco grupo", "Gracias"
        )));

        System.out.println("\nEJERCICIO 14 ");
        HashSet<String> silenciados = filtrarSpam(mensajes);
        System.out.println("Jugadores silenciados: " + silenciados);

        //Ejercicio15


        System.out.println("\nEJERCICIO 15");
        HashMap<String, PriorityQueue<Double>> subastas = new HashMap<>();

        PriorityQueue<Double> pujasExcalibur =
                new PriorityQueue<>(Collections.reverseOrder());

        pujasExcalibur.add(300.0);
        pujasExcalibur.add(500.0);
        pujasExcalibur.add(450.0);

        subastas.put("Excalibur", pujasExcalibur);

        // Saldos de jugadores
        HashMap<String, Double> saldos = new HashMap<>();
        saldos.put("Piedad", 600.0);
        saldos.put("Pedro", 400.0);

        procesarVenta("Excalibur", subastas, saldos, "Piedad");
    }

    // MÉTODOS EJERCICIO 11.

    public static HashMap<String, Double> obtenerPreciosCiudad(
            String ciudad,
            HashMap<String, Double> preciosBase,
            HashMap<String, ArrayList<String>> ciudades) {

        HashMap<String, Double> preciosFinales = new HashMap<>();

        if (!ciudades.containsKey(ciudad)) {
            return preciosFinales;
        }

        ArrayList<String> items = ciudades.get(ciudad);
        boolean impuestoLujo = items.size() > 5;

        for (String item : items) {
            double precio = preciosBase.get(item);
            if (impuestoLujo) {
                precio *= 1.10;
            }
            preciosFinales.put(item, precio);
        }

        return preciosFinales;
    }

    //MÉTODOS EJERCICIO 12.

    public static void desbloquearGolpeDivino(
            HashMap<String, HashMap<String, Boolean>> arbol,
            String clase) {

        HashMap<String, Boolean> habilidades = arbol.get(clase);

        if (!habilidades.getOrDefault("Enfoque", false)) {
            System.out.println("Error: Debes desbloquear Enfoque primero.");
            return;
        }

        habilidades.put("Golpe Divino", true);
        System.out.println("Golpe Divino desbloqueado.");
    }

    //MÉTODOS EJERCICIO 13.

    public static void mostrarEstadisticasRaids(
            HashMap<String, List<HashSet<String>>> historial) {

        HashMap<String, Integer> contador = new HashMap<>();

        // Contar participaciones
        for (List<HashSet<String>> raids : historial.values()) {
            for (HashSet<String> raid : raids) {
                for (String jugador : raid) {
                    contador.put(jugador,
                            contador.getOrDefault(jugador, 0) + 1);
                }
            }
        }

        System.out.println("Participaciones por jugador:");
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        String mvp = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mvp = entry.getKey();
            }
        }

        System.out.println("Jugador más valioso: " + mvp);
        System.out.println("Participaciones totales: " + max);
    }

    //MÉTODOS EJERCICIO 14.

    public static HashSet<String> filtrarSpam(
            HashMap<String, List<String>> mensajes) {

        HashSet<String> silenciados = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : mensajes.entrySet()) {

            List<String> listaMensajes = entry.getValue();

            if (listaMensajes.size() < 3) {
                continue;
            }

            List<String> ultimosTres =
                    listaMensajes.subList(
                            listaMensajes.size() - 3,
                            listaMensajes.size()
                    );

            if (new HashSet<>(ultimosTres).size() < ultimosTres.size()) {
                silenciados.add(entry.getKey());
                listaMensajes.clear();
            }
        }

        return silenciados;
    }

    //MÉTODOS EJERCICIO 15.

    public static void procesarVenta(
            String item, HashMap<String, PriorityQueue<Double>> subastas, HashMap<String, Double> saldos, String comprador) {

        // Comprobar que el item existe
        if (!subastas.containsKey(item)) {
            System.out.println("El item no está en subasta.");
            return;
        }

        PriorityQueue<Double> pujas = subastas.get(item);

        // Mientras haya pujas disponibles
        while (!pujas.isEmpty()) {

            // Obtener la puja más alta
            double mejorPuja = pujas.poll();
            double saldo = saldos.getOrDefault(comprador, 0.0);

            // Comprobar si el jugador tiene suficiente oro
            if (saldo >= mejorPuja) {
                // Venta exitosa
                saldos.put(comprador, saldo - mejorPuja);
                subastas.remove(item);

                System.out.println(comprador + " gana " + item + " por " + mejorPuja);
                return;
            }
        }

        // Si ninguna fue válida
        System.out.println("No hay pujas válidas para " + item);
    }
}