import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Clase principal del programa
public class Main {

    // Lista que almacena todos los hospitales del sistema
    static ArrayList<Hospital> hospitales = new ArrayList<>();

    // Lista que almacena todas las áreas de los hospitales
    static ArrayList<Areas> areas = new ArrayList<>();

    // Lista que almacena todos los médicos registrados
    static ArrayList<Medico> medicos = new ArrayList<>();

    // Lista que almacena los contratos de cada médico
    static ArrayList<Contrato> contratos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Precarga datos por defecto para poder usar el programa sin introducir manualmente
        precargarDatos();

        // Llama al menú principal del sistema
        ejecutarMenuPrincipal();
    }

    // metodo que crea objetos iniciales para trabajar: direcciones, hospitales, áreas, médicos y contratos
    private static void precargarDatos() {

        // Se crean direcciones para los hospitales
        Direccion d1 = new Direccion("Av Ronda", 10, 28001, "Madrid", "Madrid");
        Direccion d2 = new Direccion("Av España", 20, 28005, "Bornos", "Cadiz");

        // Se crean hospitales con su dirección
        Hospital h1 = new Hospital("Hospital Central", "CIF123", d1);
        Hospital h2 = new Hospital("Hospital sur", "CIF321", d2);

        // Se crean áreas asociadas a los hospitales
        Areas a1 = new Areas("Urgencias", "A1", 1, h1);
        Areas a2 = new Areas("Pediatría", "A2", 2, h2);

        // Se agrega el área A1 al hospital H1
        h1.agregarAreas(a1);

        // Se añaden los hospitales a la lista global
        hospitales.add(h1);
        hospitales.add(h2);

        // Se añaden las áreas a la lista global
        areas.add(a1);
        areas.add(a2);

        // Se crean médicos, indicando su área y datos personales
        Medico m1 = new Medico("Juana", a1, "12345678A", 40, "Mujer", 30000, 20200226);
        Medico m2 = new Medico("Pepe", a2, "20607431Y", 30, "Hombre", 40000, 20100915);

        // Se agregan los médicos a la lista global
        medicos.add(m1);
        medicos.add(m2);

        // Se crean contratos, asociando médico con hospital y año de inicio
        Contrato c1 = new Contrato(2020, m1, h1);
        contratos.add(c1);

        Contrato c2 = new Contrato(2015, m2, h2);
        contratos.add(c2);
    }

    // metodo que busca un médico por su DNI
    // Devuelve el objeto Medico si lo encuentra, o null si no existe
    public static Medico buscarMedico(String dni) {
        for (Medico m : medicos)
            if (m.getDNI().equals(dni))
                return m;

        return null; // Si no se encuentra, devuelve null
    }

    // metodo que busca un área por su identificador
    public static Areas buscarArea(String id) {
        for (Areas a : areas)
            if (a.getIdentificador().equals(id))
                return a;

        return null; // No encontrada
    }

    // metodo que busca un hospital por su nombre
    public static Hospital buscarHospital(String nombre) {
        for (Hospital h : hospitales)
            if (h.getNombre().equals(nombre))
                return h;

        return null; // No encontrado
    }

    // metodo que inicia el menú principal usando la clase MenuGestor
    public static void ejecutarMenuPrincipal() {

        // Crea un objeto menú que tiene acceso a todas las listas
        MenuGestor menu = new MenuGestor(hospitales, areas, medicos, contratos);

        // Llama al menú para que empiece la ejecución interactiva
        menu.ejecutarMenuPrincipal();
    }
}
