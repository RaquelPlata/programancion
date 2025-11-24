public class Direccion {
    private String calle;
    private int numero;
    private int codigopotal;
    private String localodad;
    private String provincia;

    public Direccion (String calle, int numero, int codigopostal ,String localidad,String provincia){
        this.calle=calle;
        this.numero= numero;
        this.codigopotal= codigopostal;
        this.localodad=localidad;
        this.provincia=provincia;

    }

    //GET
    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigopotal() {
        return codigopotal;
    }

    public String getLocalodad() {
        return localodad;
    }

    public String getProvincia() {
        return provincia;
    }

    //SET

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigopotal(int codigopotal) {
        this.codigopotal = codigopotal;
    }

    public void setLocalodad(String localodad) {
        this.localodad = localodad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public String toString() {
        return this.calle + " " + this.numero + ", " + this.codigopotal + this.localodad + " (" + this.provincia + ") ";
    }
}
