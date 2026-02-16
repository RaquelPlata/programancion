public class Desierto extends Biomas {

    private double temperaturaMax;
    private int hectareas;

    //Constructor
    public Desierto(int idBioma, String nombre, double temperatura, double oxigeno,
                    double temperaturaMax, int hectareas) {
        super(idBioma, nombre, temperatura, oxigeno);
        this.temperaturaMax = temperaturaMax;
        this.hectareas = hectareas;
    }
}
