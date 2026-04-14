package rpg.model;

import java.util.ArrayList;
import java.util.List;

public class clase {
    private Integer id;
    private String nombre;
    private List<habilidad> lista_Habilidades;
    public clase(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.lista_Habilidades = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
