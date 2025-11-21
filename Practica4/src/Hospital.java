import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private String cif ;
    private ArrayList<Areas> areas;


    public Hospital (String nombre, String cif){
        this.nombre = nombre;
        this.cif = cif;
        this.areas = new ArrayList<>();

    }
//Get
    public ArrayList<Areas> getAreas(){
        return areas;
    }

    public String getNombre() {
        return nombre;
    }
//set
    public String getCif() {
        return cif;
    }

    public void setAreas(ArrayList<Areas> areas) {
        this.areas = areas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    // ADD AGREGAR AREAS
    public void agregarAreas(Areas a ){
        this.areas.add(a);
    }
}
