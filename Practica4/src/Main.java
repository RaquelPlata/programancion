import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public  class Main {
    static ArrayList<Hospital> hospitales = new ArrayList<>();
    static ArrayList<Areas> areas = new ArrayList<>();
    static ArrayList<Medico> medicos = new ArrayList<>();
    static ArrayList<Contrato> contratos = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
                precargarDatos();
                ejecutarMenuPrincipal();
            }


            private static void precargarDatos() {
                Direccion d1 = new Direccion("Av España", 10, 28001, "Madrid", "Madrid");
                Hospital h1 = new Hospital("Hospital Central", "CIF123", d1);
                Areas a1 = new Areas("Urgencias", "A1", 1, h1);
                h1.agregarAreas(a1);
                hospitales.add(h1);
                areas.add(a1);


                Medico m1 = new Medico("Juan Perez", a1, "12345678A", 40, "M", 30000, 2020);
                medicos.add(m1);


                Contrato c1 = new Contrato(2020, m1, h1);
                contratos.add(c1);
            }


            public static Medico buscarMedico(String dni) {
                for (Medico m : medicos) if (m.getDNI().equals(dni)) return m;
                return null;
            }


            public static Areas buscarArea(String id) {
                for (Areas a : areas) if (a.getIdentificador().equals(id)) return a;
                return null;
            }


            public static Hospital buscarHospital(String nombre) {
                for (Hospital h : hospitales) if (h.getNombre().equals(nombre)) return h;
                return null;
            }


            public static void ejecutarMenuPrincipal() {
                MenuGestor menu = new MenuGestor(hospitales, areas, medicos, contratos);
                menu.ejecutarMenuPrincipal();
            }
        }

