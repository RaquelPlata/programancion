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
            System.out.println("Error de base de datos al iniciar.");
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
