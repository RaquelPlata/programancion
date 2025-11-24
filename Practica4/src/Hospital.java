import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private String cif;
    private Direccion direccion;
    private ArrayList<Areas> areas;


    public Hospital(String nombre, String cif, Direccion direccion) {
        this.nombre = nombre;
        this.cif = cif;
        this.areas = new ArrayList<>();
        this.direccion= direccion;

    }

    //GET
    public ArrayList<Areas> getAreas() {
        return areas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    //SET
    public void setAreas(ArrayList<Areas> areas) {
        this.areas = areas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // ADD AGREGAR AREAS
    public void agregarAreas(Areas a) {
        this.areas.add(a);
    }

    //NUMERO TOTAL DE MEDICOS
    public int getNumeroTotalMedicos() {
        int total = 0;
        for (Areas area : this.areas) {
            total += area.getNumMedicos();
        }
        return total;
    }

    //PROPORCION DE MEDICOS
    public double getroponcionMedicosArea(String idArea) {
        Areas area = buscarArea(idArea);
        if (area != null & getNumeroTotalMedicos() > 0) {
            return (double) area.getNumMedicos() / getNumeroTotalMedicos();
        }
        return 0;
    }
            //EXISTE AREA POR ID
            public boolean existeArea(String idArea) {
                return buscarArea(idArea) != null;
            }
                //AGREGAR BUSCAR AREA PARA LA PROPORCION Y LA EXISTENCIA DEL ID
                public Areas buscarArea(String idArea) {
                    for (Areas area : areas) {
                        if (area.getIdentificador().equals(idArea)) return area;
                    }
                    return null;
                }
    public String toString() {
        return this.nombre + " (" + this.cif + ") - " + this.direccion;
    }
}


