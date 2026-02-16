public class Actuadores extends Equipos implements Diagnostico {

    private double potencia;
    private String tipo;
    private String estado;
    public Actuadores(String idEquipo, String modelo, String estado,
                      double potencia, String tipo) {
        super(idEquipo, modelo, estado);
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public boolean ejecutarDiagnostico() {
        return getEstado().equalsIgnoreCase("operativo");
    }
}
