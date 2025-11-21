public class Areas {
    private String Nombre ;
    private String Identificador ;
    private Integer planta ;
    private  Hospital hospital ;//Área pertenece a un hospital
    private int numMedicos;

    public Areas ( String nombre , String identificador , int planta , Hospital hospital){
        this.Nombre = nombre ;
        this.Identificador = identificador;
        this.planta = planta;
        this.hospital= hospital ;
        this.numMedicos = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getNumMedicos() {
        return numMedicos;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}

