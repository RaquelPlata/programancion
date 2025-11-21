public class Contrato {
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;

    public Contrato( int fechaCreacion,Medico medico , Hospital hospital){

        this.fechaCreacion=fechaCreacion;
        this.medico= medico;
        this.hospital=hospital;
    }
}
