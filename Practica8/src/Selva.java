public class Selva extends Biomas {

    private double nivelHumedad;
    private int hectareas;

    public Selva(int idBioma, String nombre, double temperatura, double oxigeno,
                 double nivelHumedad, int hectareas) {
        super(idBioma, nombre, temperatura, oxigeno);
        this.nivelHumedad = nivelHumedad;
        this.hectareas = hectareas;
    }
}
