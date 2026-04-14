package rpg.ui;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.logic.Combate;
import rpg.model.*;
import rpg.utils.Log;
import java.sql.SQLException;
import java.util.*;

public class Menu {

    private Scanner sc;
    private boolean ejecutar;

    // DAOs
    private PersonajeDAO personajeDAO;
    private ItemsDAO itemsDAO;
    private ciudadesDAO ciudadesDAO;
    private razaDAO razaDAO;
    private clase_rpgDAO claseDAO;
    private Combate motor;

    public Menu(Combate motor) {
        this.motor = motor;
        this.sc = new Scanner(System.in);
        this.ejecutar = true;
        try {
            this.personajeDAO = new PersonajeDAO();
            this.itemsDAO = new ItemsDAO();
            this.ciudadesDAO = new ciudadesDAO();
            this.razaDAO = new razaDAO();
            this.claseDAO = new clase_rpgDAO();
        } catch (SQLException e) {
            System.out.println("❌ Error de base de datos al iniciar.");
            this.ejecutar = false;
        }
    }

    public void iniciar() {
        while (ejecutar) {
            System.out.println("\n--------------------------------------------");
            System.out.println("       XRPG GUILD MASTER v1.0      ");
            System.out.println("--------------------------------------------");
            System.out.println("1. Gestión de Personajes y Exploración");
            System.out.println("2. Tienda e Inventario");
            System.out.println("3. Eventos del Mundo (Impuestos)");
            System.out.println("4. Sistema de Combate");
            System.out.println("5. Centro de Estadísticas");
            System.out.println("6. Salir");
            System.out.print("\nSelecciona una opción: ");

            try {
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1: menuPersonajes(); break;
                    case 2:
                        personaje pTienda = elegirPersonaje("¿Quién va a comprar?");
                        if (pTienda != null) menuTienda(pTienda);
                        break;
                    case 3: eventoImpuestos(); break;
                    case 4: menuCombate(); break;
                    case 5: centroEstadisticas(); break;
                    case 6:
                        ejecutar = false;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default: System.out.println("⚠ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        }
    }

    // --- MÉTODOS AUXILIARES ---
    private personaje elegirPersonaje(String mensaje) {
        ArrayList<personaje> lista = personajeDAO.getPersonajes();
        if (lista.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return null;
        }
        System.out.println("\n" + mensaje);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i).getNombre());
        }
        int idx = Integer.parseInt(sc.nextLine());
        return lista.get(idx);
    }

    // --- 1. GESTIÓN DE PERSONAJES ---
    private void menuPersonajes() {
        System.out.println("\n--- GESTIÓN ---");
        System.out.println("1. Crear Nuevo Personaje");
        System.out.println("2. Viajar a otra ciudad");
        int opt = Integer.parseInt(sc.nextLine());

        if (opt == 1) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Selecciona Raza:");
            for (raza r : razaDAO.getRazas()) System.out.println(r.getId() + ". " + r.getNombre());
            raza rSel = razaDAO.buscaRazaPorId(Integer.parseInt(sc.nextLine()));
            System.out.println("Selecciona Clase:");
            for (clase c : claseDAO.getClases()) System.out.println(c.getId() + ". " + c.getNombre());
            clase cSel = claseDAO.buscaClasePorId(Integer.parseInt(sc.nextLine()));
            ciudad ciuIni = ciudadesDAO.buscaCiudadPorId(1);
            Integer id = personajeDAO.insertarPesonajeEnBD(nombre, 1, 100, 100, rSel, cSel, ciuIni);
            if (id != null) {
                Log.Error("Creado personaje: " + nombre + " (ID: " + id + ")");
                System.out.println("✅ Personaje creado con éxito.");
            }
        } else if (opt == 2) {
            viajar();
        }
    }

    private void viajar() {
        personaje p = elegirPersonaje("Selecciona personaje para viajar:");
        if (p == null) return;

        System.out.println("\nCiudades disponibles:");
        for (ciudad c : ciudadesDAO.getCiudades()) {
            System.out.println(c.getId() + ". " + c.getNombre() + " (Nivel min: " + c.getNivel_minimo_acceso() + ")");
        }
        System.out.print("ID de ciudad destino: ");
        int idCiu = Integer.parseInt(sc.nextLine());
        ciudad destino = ciudadesDAO.buscaCiudadPorId(idCiu);

        try {
            if (p.getNivel() < destino.getNivel_minimo_acceso()) {
                throw new NivelInsuficienteException("❌ Nivel insuficiente. Requieres nivel " + destino.getNivel_minimo_acceso());
            }
            personajeDAO.cambiarCiudadPersonaje(p, destino);
            System.out.println("✅ ¡Viaje con éxito! " + p.getNombre() + " ahora está en " + destino.getNombre());
            Log.Error(p.getNombre() + " viajó a " + destino.getNombre());
        } catch (NivelInsuficienteException e) {
            System.err.println(e.getMessage());
            Log.Error("Fallo de viaje: " + e.getMessage());
        }
    }

    // --- 2. TIENDA ---
    private void menuTienda(personaje p) {
        System.out.println("\n--- TIENDA (Comprador: " + p.getNombre() + " | Oro: " + p.getOro() + ") ---");
        for (items i : itemsDAO.items) {
            System.out.println(i.getId() + ". " + i.getNombre() + " - Precio: " + i.getPrecio_oro());
        }
        System.out.print("¿Qué deseas comprar? (ID): ");
        int itemID = Integer.parseInt(sc.nextLine());
        items seleccionado = itemsDAO.getItemById(itemID);

        try {
            if (seleccionado == null) return;
            if (p.getOro() < seleccionado.getPrecio_oro()) {
                throw new FondosInsuficientesException("No tienes suficiente oro.");
            }
            p.setOro(p.getOro() - seleccionado.getPrecio_oro());
            personajeDAO.actualizarOro(p); // Debes tener este método en el DAO
            System.out.println("✅ Compra exitosa: " + seleccionado.getNombre());
            Log.Error("Compra realizada: " + p.getNombre() + " compró " + seleccionado.getNombre());
        } catch (FondosInsuficientesException e) {
            System.err.println("❌ " + e.getMessage());
            Log.Error("Intento de compra fallido: " + e.getMessage());
        }
    }

    // --- 3. EVENTOS (IMPUESTOS) ---
    private void eventoImpuestos() {
        System.out.println("\n--- 🌍 COBRO DE IMPUESTOS ---");
        List<personaje> lista = personajeDAO.getPersonajes();
        Iterator<personaje> it = lista.iterator();
        while (it.hasNext()) {
            personaje p = it.next();
            p.setOro(p.getOro() - 20);
            System.out.println(p.getNombre() + " ha pagado 20 de oro. Restante: " + p.getOro());
            if (p.getOro() < 0) {
                System.out.println("💥 " + p.getNombre() + " ha sido desterrado por deudas.");
                personajeDAO.desterrar(p); // Debes tener este método que ponga ciudad a NULL
                it.remove();
                Log.Error("Personaje desterrado: " + p.getNombre());
            } else {
                personajeDAO.actualizarOro(p);
            }
        }
    }

    // --- 4. COMBATE ---
    private void menuCombate() {
        System.out.println("\n--- MOTOR DE COMBATE ---");
        personaje p1 = elegirPersonaje("Selecciona el primer combatiente:");
        personaje p2 = elegirPersonaje("Selecciona el segundo combatiente:");
        if (p1 != null && p2 != null && p1 != p2) {
            motor.iniciarCombate(p1, p2);
        } else {
            System.out.println("Selección de combatientes inválida.");
        }
    }

    // --- 5. ESTADÍSTICAS ---
    private void centroEstadisticas() {
        System.out.println("\n--- 📊 ESTADÍSTICAS ---");
        ArrayList<personaje> lista = new ArrayList<>(personajeDAO.getPersonajes());
        if (lista.isEmpty()) return;

        lista.sort((p1, p2) -> p2.getOro().compareTo(p1.getOro()));
        System.out.println("Top 3 más ricos:");
        for (int i = 0; i < Math.min(3, lista.size()); i++) {
            System.out.println((i+1) + ". " + lista.get(i).getNombre() + " (" + lista.get(i).getOro() + ")");
        }

        HashMap<String, Integer> censo = new HashMap<>();
        for (personaje p : lista) {
            String nClase = p.getClase().getNombre();
            censo.put(nClase, censo.getOrDefault(nClase, 0) + 1);
        }
        System.out.println("\nCenso de población:");
        censo.forEach((k, v) -> System.out.println(k + ": " + v + " personajes"));
    }
}