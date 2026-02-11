public class Pujas {
    //nombre del jugador
    private String jugador;
    private double cantidad;

    //Constructor
    public Pujas(String jugador , double cantidad){
        this.jugador = jugador;
        this.cantidad= cantidad;
    }
    public  String getJugador() {
        return jugador;
    }
    public  double getCantidad(){
        return cantidad;
    }
}