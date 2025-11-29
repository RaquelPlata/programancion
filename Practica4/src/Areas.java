public class Areas {
    private String Nombre ;
    private String Identificador ;
    private Integer planta ;
    private   Hospital hospital ;//Área pertenece a un hospital
    private int numMedicos;

    public Areas ( String nombre , String identificador , int planta , Hospital hospital){
        this.Nombre = nombre ;
        this.Identificador = identificador;
        this.planta = planta;
        this.hospital= hospital ;
        this.numMedicos = 0;
    }

    //GET
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

    //SET

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setIdentificador(String identificador) {
        Identificador = identificador;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    //Aumentar medico
    public void aumentarMedicos() {
        this.numMedicos ++;
    }
    //Decremenetar medico
    public void decrementarMedico() {
        this.numMedicos --;
    }
    //  Comparación de médicos entre áreas
    public String compararMedicos(Areas otraArea) {
        if (this.numMedicos > otraArea.getNumMedicos()) {
            return "El área " + this.Nombre + " tiene más médicos que " + otraArea.getNombre() + ".";
        } else if (this.numMedicos < otraArea.getNumMedicos()) {
            return "El área " + otraArea.getNombre() + " tiene más médicos que " + this.Nombre + ".";
        } else {
            return "Las dos áreas cuentan con el mismo número de médicos.";
        }
    }

    // Calcular capacidad restante
    public int calcularCapacidadRestante(int capacidadMaxima) {
        int restante = capacidadMaxima - this.numMedicos;
        return (restante > 0) ? restante : 0; // Si se excede, devuelve 0
    }
}




