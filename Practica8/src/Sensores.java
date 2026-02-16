import java.util.List;

public class Sensores extends Equipos {

    private String tipo;
    private String unidadMedida;
    private double valorActual;
    private List<Double> historialDatos;

    public Sensores(String idEquipo, String modelo, String estado,
                    String tipo, String unidadMedida,
                    double valorActual, List<Double> historialDatos) {
        super(idEquipo, modelo, estado);
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.valorActual = valorActual;
        this.historialDatos = historialDatos;
    }

    public String obtenerUltimoValor() {
        return "Último valor: " + valorActual + " " + unidadMedida;
    }
}
