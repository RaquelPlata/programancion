public class Biomas {

    private int idBioma;
    private String nombre;
    private double temperatura;
    private double oxigeno;

    //Constructor
    public Biomas(int idBioma, String nombre, double temperatura, double oxigeno) {
        this.idBioma = idBioma;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.oxigeno = oxigeno;
    }

    //función
    public String agregarBioma() {
        return "Bioma agregado: " + nombre;
    }
}
