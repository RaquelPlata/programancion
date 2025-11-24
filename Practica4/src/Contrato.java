public class Contrato {
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;

    public Contrato( int fechaCreacion,Medico medico , Hospital hospital){

        this.fechaCreacion=fechaCreacion;
        this.medico= medico;
        this.hospital=hospital;
    }

    //GET

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public Medico getMedico() {
        return medico;
    }

    public Hospital getHospital() {
        return hospital;
    }

    //SET
    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    //comprobación de año
    public boolean esDeAnio(int anio){
        if(fechaCreacion == anio){
            return true;
        }else {
            return false;
        }
    }

    //Comprobación de año
    public  int diasDeCreacion(int fechaHoyAnio,int fechaCreacionAnio){
        return 365*(fechaCreacionAnio - fechaHoyAnio);
    }

}

