import java.util.ArrayList;
import java.util.Scanner;

class MenuGestor {
    private ArrayList<Hospital> hospitales;
    private ArrayList<Areas> areas;
    private ArrayList<Medico> medicos;
    private ArrayList<Contrato> contratos;
    private Scanner sc = new Scanner(System.in);

    public MenuGestor(ArrayList<Hospital> hospitales, ArrayList<Areas> areas,
                      ArrayList<Medico> medicos, ArrayList<Contrato> contratos) {
        this.hospitales = hospitales;
        this.areas = areas;
        this.medicos = medicos;
        this.contratos = contratos;
    }

    public void ejecutarMenuPrincipal() {
        int opcion;
        do {
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
            opcion = sc.nextInt(); sc.nextLine();

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
        } while (opcion != 0);
    }

    private void crearHospital() {
        System.out.print("Nombre hospital: "); String nombre = sc.nextLine();
        System.out.print("CIF: "); String cif = sc.nextLine();
        System.out.print("Calle: "); String calle = sc.nextLine();
        System.out.print("Número: "); int numero = sc.nextInt(); sc.nextLine();
        System.out.print("CP: "); int cp = sc.nextInt(); sc.nextLine();
        System.out.print("Localidad: "); String loc = sc.nextLine();
        System.out.print("Provincia: "); String prov = sc.nextLine();
        Direccion d = new Direccion(calle, numero, cp, loc, prov);
        hospitales.add(new Hospital(nombre, cif, d));
        System.out.println("Hospital creado.");
    }

    private void crearArea() {
        System.out.print("Nombre hospital: "); String nomHosp = sc.nextLine();
        Hospital h = Main.buscarHospital(nomHosp);
        if (h == null) return;
        System.out.print("Nombre área: "); String nombre = sc.nextLine();
        System.out.print("ID área: "); String id = sc.nextLine();
        System.out.print("Planta: "); int planta = sc.nextInt(); sc.nextLine();
        Areas a = new Areas(nombre, id, planta, h);
        h.agregarAreas(a);
        areas.add(a);
        System.out.println("Área creada.");
    }

    private void crearMedico() {
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("DNI: "); String dni = sc.nextLine();
        System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Sexo: "); String sexo = sc.nextLine();
        System.out.print("Salario bruto: "); double sb = sc.nextDouble(); sc.nextLine();
        System.out.print("Año de inicio: "); int fi = sc.nextInt(); sc.nextLine();
        System.out.print("ID área trabajo: "); String id = sc.nextLine();
        Areas area = Main.buscarArea(id);
        Medico m = new Medico(nombre, area, dni, edad, sexo, sb, fi);
        medicos.add(m);
        contratos.add(new Contrato(fi, m, area.getHospital()));
        System.out.println("Médico creado y contrato registrado.");
    }

    private void modificarMedico() {
        System.out.print("DNI médico: "); String dni = sc.nextLine();
        Medico m = Main.buscarMedico(dni);
        if (m == null) return;
        System.out.println("1. Sueldo 2. Área");
        int opc = sc.nextInt(); sc.nextLine();
        switch (opc) {
            case 1 -> { System.out.print("Nuevo sueldo: "); m.setSalario_bruto(sc.nextDouble()); }
            case 2 -> { System.out.print("ID nueva área: "); Areas nueva = Main.buscarArea(sc.nextLine()); m.cambiarArea(nueva); }
        }
    }

    private void modificarHospital() {
        System.out.print("Nombre hospital: "); Hospital h = Main.buscarHospital(sc.nextLine());
        if (h == null) return;
        System.out.println("1. Nombre 2. Dirección"); int opc = sc.nextInt(); sc.nextLine();
        if (opc == 1) { System.out.print("Nuevo nombre: "); h.setNombre(sc.nextLine()); }
        else {
            System.out.print("Nueva calle: "); String calle = sc.nextLine();
            System.out.print("Número: "); int numero = sc.nextInt(); sc.nextLine();
            System.out.print("CP: "); int cp = sc.nextInt(); sc.nextLine();
            System.out.print("Localidad: "); String loc = sc.nextLine();
            System.out.print("Provincia: "); String prov = sc.nextLine();
            h.setDireccion(new Direccion(calle, numero, cp, loc, prov));
        }
    }

    private void calcularAntiguedad() {
        System.out.print("DNI médico: "); Medico m = Main.buscarMedico(sc.nextLine());
        if (m != null) System.out.println("Antigüedad: " + m.getAniosAntiguedad() + " años");
    }

    private void calcularSueldoNeto() {
        System.out.print("DNI médico: "); Medico m = Main.buscarMedico(sc.nextLine());
        System.out.print("% retención: "); double ret = sc.nextDouble(); sc.nextLine();
        System.out.println("Sueldo neto: " + m.calcularSueldoNeto(ret));
    }

    private void comprobarEdad() {
        System.out.print("DNI médico: "); Medico m = Main.buscarMedico(sc.nextLine());
        System.out.print("Edad mínima: "); int min = sc.nextInt(); sc.nextLine();
        System.out.println(m.esMayorEdad(min) ? "Mayor de edad" : "No cumple");
    }

    private void proporcionMedicosArea() {
        System.out.print("Nombre hospital: "); Hospital h = Main.buscarHospital(sc.nextLine());
        System.out.print("ID área: "); Areas a = Main.buscarArea(sc.nextLine());
        System.out.println("Proporción: " + h.getroponcionMedicosArea(a.getIdentificador()));
    }

    private void capacidadArea() {
        System.out.print("ID área: "); Areas a = Main.buscarArea(sc.nextLine());
        System.out.print("Capacidad máxima: "); int max = sc.nextInt(); sc.nextLine();
        System.out.println("Capacidad restante: " + a.calcularCapacidadRestante(max));
    }

    private void compararAreas() {
        System.out.print("ID área 1: "); Areas a1 = Main.buscarArea(sc.nextLine());
        System.out.print("ID área 2: "); Areas a2 = Main.buscarArea(sc.nextLine());
        System.out.println(a1.compararMedicos(a2));
    }

    private void contratosPorAnio() {
        System.out.print("Año: "); int anio = sc.nextInt(); sc.nextLine();
        for (Contrato c : contratos) if (c.esDeAnio(anio)) System.out.println(c.getMedico().getNombre());
    }
}
