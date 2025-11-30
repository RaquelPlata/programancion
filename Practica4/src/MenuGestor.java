import java.util.ArrayList;
import java.util.Scanner;

// Clase que gestiona el menú principal del sistema y todas sus funcionalidades
class MenuGestor {
public static int salario_bruto ;

    // Listas con todos los elementos del sistema
    private ArrayList<Hospital> hospitales;  // Lista de hospitales
    private ArrayList<Areas> areas;          // Lista de áreas
    private ArrayList<Medico> medicos;       // Lista de médicos
    private ArrayList<Contrato> contratos;   // Lista de contratos

    // Scanner para entrada por teclado
    private static Scanner sc = new Scanner(System.in);

    // Constructor que recibe las listas del sistema
    public MenuGestor(ArrayList<Hospital> hospitales, ArrayList<Areas> areas,
                      ArrayList<Medico> medicos, ArrayList<Contrato> contratos) {
        this.hospitales = hospitales;
        this.areas = areas;
        this.medicos = medicos;
        this.contratos = contratos;
    }

    // metodo principal que ejecuta el menú interactivo
    public void ejecutarMenuPrincipal() {
        int opcion;
        do {
            // Muestra el menú
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Crear Área");
            System.out.println("3. Crear Médico");
            System.out.println("4. Modificar Médico");
            System.out.println("5. Modificar Hospital");
            System.out.println("6. Calcular Antigüedad");
            System.out.println("7. Calcular Sueldo Neto");
            System.out.println("8. Comprobar Edad");
            System.out.println("9. Proporción Médicos Área");
            System.out.println("10. Capacidad de Área");
            System.out.println("11. Comparar Áreas");
            System.out.println("12. Contratos por Año");
            System.out.println("0. Salir");

            // Lee la opción del usuario
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

            // Ejecuta la opción elegida
            switch (opcion) {
                case 1 -> crearHospital();
                case 2 -> crearArea();
                case 3 -> crearMedico();
                case 4 -> modificarMedico();
                case 5 -> modificarHospital();
                case 6 -> calcularAntiguedad();
                case 7 -> calcularSueldoNeto();
                case 8 -> comprobarEdad();
                case 9 -> proporcionMedicosArea();
                case 10 -> capacidadArea();
                case 11 -> compararAreas();
                case 12 -> contratosPorAnio();
            }

        } while (opcion != 0); // Repite hasta elegir salir
    }


    //                CREAR HOSPITAL


    // Metodo para crear un nuevo hospital
    private void crearHospital() {
        System.out.print("Nombre hospital: ");
        String nombre = sc.nextLine();

        System.out.print("CIF: ");
        String cif = sc.nextLine();

        System.out.print("Calle: ");
        String calle = sc.nextLine();

        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("CP: ");
        int cp = sc.nextInt();
        sc.nextLine();

        System.out.print("Localidad: ");
        String loc = sc.nextLine();

        System.out.print("Provincia: ");
        String prov = sc.nextLine();

        // Se crea la dirección y el hospital
        Direccion d = new Direccion(calle, numero, cp, loc, prov);
        hospitales.add(new Hospital(nombre, cif, d));

        System.out.println("Hospital creado.");
    }


    //                  CREAR ÁREA


    private void crearArea() {
        System.out.print("Nombre hospital: ");
        String nomHosp = sc.nextLine();

        System.out.print("CIF: ");
        String cif = sc.nextLine(); // (Parece que no se usa, pero lo dejo igual)

        // Se busca el hospital
        Hospital h = Main.buscarHospital(nomHosp);
        if (h == null) return;

        System.out.print("Nombre área: ");
        String nombre = sc.nextLine();

        System.out.print("ID área: ");
        String id = sc.nextLine();

        System.out.print("Planta: ");
        int planta = sc.nextInt();
        sc.nextLine();

        // Se crea la nueva área
        Areas a = new Areas(nombre, id, planta, h);
        h.agregarAreas(a); // Se agrega al hospital
        areas.add(a);      // Se agrega a la lista global

        System.out.println("Área creada.");
    }


    //                CREAR MÉDICO


    private static void crearMedico() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Sexo: ");
        String sexo = sc.nextLine();
        System.out.print("Sueldo bruto: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();

        System.out.print("Día inicio: ");
        int dia = sc.nextInt();
        System.out.print("Mes inicio: ");
        int mes = sc.nextInt();
        System.out.print("Año inicio: ");
        int anio = sc.nextInt();
        sc.nextLine();

        // SOLO AÑO PARA EL CONTRATO
        int fecha_i = anio;

        // Seleccionar área
        System.out.println("Selecciona el área del médico:");
        for (int i = 0; i < Main.areas.size(); i++) {
            System.out.println(i + ": " + Main.areas.get(i).getNombre() +
                    " (ID: " + Main.areas.get(i).getIdentificador() + ")");
        }
        int indexArea = sc.nextInt();
        sc.nextLine();
        Areas areaSeleccionada = Main.areas.get(indexArea);

        // Crear médico

        Medico m = new Medico(nombre, areaSeleccionada, dni, edad, sexo, fecha_i, salario_bruto);
        Main.medicos.add(m);
        System.out.println("Médico creado correctamente.");

        // Seleccionar hospital para el contrato
        System.out.println("Selecciona el hospital para el contrato:");
        for (int i = 0; i < Main.hospitales.size(); i++) {
            System.out.println(i + ": " + Main.hospitales.get(i).getNombre());
        }
        int indexHospital = sc.nextInt();
        sc.nextLine();
        Hospital h = Main.hospitales.get(indexHospital);

        // Crear contrato usando SOLO EL AÑO
        Contrato c = new Contrato(fecha_i, m, h);
        Main.contratos.add(c);
        System.out.println("Contrato creado correctamente.");
    }


    //               MODIFICAR MÉDICO


    private void modificarMedico() {
        System.out.print("DNI médico: ");
        String dni = sc.nextLine();

        Medico m = Main.buscarMedico(dni);
        if (m == null) return;

        System.out.println("1. Sueldo 2. Área");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1 -> {
                System.out.print("Nuevo sueldo: ");
                m.setSalario_bruto(sc.nextDouble());
            }
            case 2 -> {
                System.out.print("ID nueva área: ");
                Areas nueva = Main.buscarArea(sc.nextLine());
                m.cambiarArea(nueva);
            }
        }
    }


    //             MODIFICAR HOSPITAL


    private void modificarHospital() {
        System.out.print("Nombre hospital: ");
        Hospital h = Main.buscarHospital(sc.nextLine());
        if (h == null) return;

        System.out.println("1. Nombre 2. Dirección");
        int opc = sc.nextInt();
        sc.nextLine();

        if (opc == 1) {
            System.out.print("Nuevo nombre: ");
            h.setNombre(sc.nextLine());
        } else {
            // Modificación de la dirección del hospital
            System.out.print("Nueva calle: ");
            String calle = sc.nextLine();

            System.out.print("Número: ");
            int numero = sc.nextInt();
            sc.nextLine();

            System.out.print("CP: ");
            int cp = sc.nextInt();
            sc.nextLine();

            System.out.print("Localidad: ");
            String loc = sc.nextLine();

            System.out.print("Provincia: ");
            String prov = sc.nextLine();

            h.setDireccion(new Direccion(calle, numero, cp, loc, prov));
        }
    }

    //           CALCULAR ANTIGÜEDAD MÉDICO


    private void calcularAntiguedad() {
        System.out.print("DNI médico: ");
        Medico m = Main.buscarMedico(sc.nextLine());
        if (m != null)
            System.out.println("Antigüedad: " + m.getAniosAntiguedad() + " años");
    }


    //            CALCULAR SUELDO NETO MÉDICO


    private void calcularSueldoNeto() {
        System.out.print("DNI médico: ");
        Medico m = Main.buscarMedico(sc.nextLine());

        System.out.print("% retención: ");
        double ret = sc.nextDouble();
        sc.nextLine();

        System.out.println("Sueldo neto: " + m.calcularSueldoNeto(ret));
    }


    //            COMPROBAR EDAD MÍNIMA


    private void comprobarEdad() {
        System.out.print("DNI médico: ");
        Medico m = Main.buscarMedico(sc.nextLine());

        System.out.print("Edad mínima: ");
        int min = sc.nextInt();
        sc.nextLine();

        System.out.println(m.esMayorEdad(min) ? "Mayor de edad" : "No cumple");
    }


    //          PROPORCIÓN MÉDICOS POR ÁREA


    private void proporcionMedicosArea() {
        System.out.print("Nombre hospital: ");
        Hospital h = Main.buscarHospital(sc.nextLine());

        System.out.print("ID área: ");
        Areas a = Main.buscarArea(sc.nextLine());

        System.out.println("Proporción: " + h.getProporcionMedicosArea(a.getIdentificador()));
    }


    //            CAPACIDAD RESTANTE DEL ÁREA


    private void capacidadArea() {
        System.out.print("ID área: ");
        Areas a = Main.buscarArea(sc.nextLine());

        System.out.print("Capacidad máxima: ");
        int max = sc.nextInt();
        sc.nextLine();

        System.out.println("Capacidad restante: " + a.calcularCapacidadRestante(max));
    }


    //               COMPARAR DOS ÁREAS


    private void compararAreas() {
        System.out.print("ID área 1: ");
        Areas a1 = Main.buscarArea(sc.nextLine());

        System.out.print("ID área 2: ");
        Areas a2 = Main.buscarArea(sc.nextLine());

        System.out.println(a1.compararMedicos(a2));
    }


    //          LISTAR CONTRATOS POR AÑO


    private void contratosPorAnio() {
        System.out.print("Año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        for (Contrato c : contratos)
            if (c.esDeAnio(anio))
                System.out.println(c.getMedico().getNombre());

    }
}
