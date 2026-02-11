import java.util.*;

public class Subastas {

    // Mapa que guarda los items en subasta
    // Clave: nombre del item
    // Valor: cola de prioridad con las pujas (la más alta sale primero)
    private HashMap<String, PriorityQueue<Pujas>> mercado;

    // Mapa con el saldo de oro de cada jugador
    // Clave: nombre del jugador
    // Valor: cantidad de oro disponible
    private HashMap<String, Double> saldos;

    // Constructor: inicializa las estructuras
    public Subastas() {
        mercado = new HashMap<>();
        saldos = new HashMap<>();
    }

    // Añade un jugador y su oro inicial
    public void añadirJugador(String nombre, double oro) {
        saldos.put(nombre, oro);
    }

    // Añade un item al mercado de subastas
    // La PriorityQueue ordena las pujas de mayor a menor
    public void añadirItem(String item) {
        mercado.put(item, new PriorityQueue<>(
                (a, b) -> Double.compare(b.getCantidad(), a.getCantidad())
        ));
    }

    // Añade una puja a un item concreto
    public void añadirPuja(String item, Pujas puja) {
        mercado.get(item).add(puja);
    }

    // FUNCIÓN procesarVenta
    public void procesarVenta(String item) {

        // Obtenemos la cola de pujas del item
        PriorityQueue<Pujas> pujas = mercado.get(item);

        // Mientras haya pujas disponibles
        while (!pujas.isEmpty()) {

            // Sacamos la puja más alta
            Pujas mejorPuja = pujas.poll();

            String jugador = mejorPuja.getJugador();
            double cantidad = mejorPuja.getCantidad();

            // Obtenemos el oro del jugador
            double oroJugador = saldos.get(jugador);

            // Comprobamos si el jugador tiene suficiente oro
            if (oroJugador >= cantidad) {

                // Restamos el oro de la puja ganadora
                saldos.put(jugador, oroJugador - cantidad);

                // Eliminamos el item del mercado
                mercado.remove(item);

                // Mostramos el resultado
                System.out.println(
                        jugador + " gana " + item + " por " + cantidad);
                return;
            }
            // Si no tiene oro suficiente, se descarta la puja
            // y se pasa a la siguiente más alta
        }

        // Si ninguna puja es válida
        System.out.println("No hay pujas válidas para " + item);
    }

    // Muestra el saldo final de todos los jugadores
    public void mostrarSaldos() {
        System.out.println("Saldos finales:");
        for (String jugador : saldos.keySet()) {
            System.out.println(jugador + " -> " + saldos.get(jugador));
        }
    }
}