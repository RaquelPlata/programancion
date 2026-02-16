public class Base implements Diagnostico {

    private int idBase;
    private String nombre;
    private String estado;
    private String ubicacion;

    public Base(int idBase, String nombre, String estado, String ubicacion) {
        this.idBase = idBase;
        this.nombre = nombre;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public String buscarEquipo(String idEquipo) {
        return "Buscando equipo con ID: " + idEquipo;
    }


    public boolean ejecutarDiagnostico() {
        return estado.equalsIgnoreCase("activo");
    }
}
