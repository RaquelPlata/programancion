public class Equipos {

    private String idEquipo;
    private String modelo;
    private String estado;

    public Equipos(String idEquipo, String modelo, String estado) {
        this.idEquipo = idEquipo;
        this.modelo = modelo;
        this.estado = estado;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
