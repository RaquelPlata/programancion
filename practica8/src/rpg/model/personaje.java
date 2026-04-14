package rpg.model;

import java.util.HashMap;
import java.util.Map;

public class personaje {
    private Integer id;
    private String nombre;
    private Integer nivel;
    private Integer oro;
    private Integer vida_actual;
    private raza raza;
    private clase clase;
    private ciudad ciudad;
    private Map<items,Integer> inventario;
    private Map<habilidad, Boolean> habilidades;

    public personaje(Integer id, String nombre, Integer nivel, Integer oro, Integer vida_actual, raza raza, clase clase, ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.raza = raza;
        this.clase = clase;
        this.ciudad = ciudad;
        this.inventario = new HashMap<>();
        this.habilidades = new HashMap<>();
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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOro() {
        return oro;
    }

    public void setOro(Integer oro) {
        this.oro = oro;
    }

    public Integer getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(Integer vida_actual) {
        this.vida_actual = vida_actual;
    }

    public raza getRaza() {
        return raza;
    }

    public void setRaza(raza Raza) {
        this.raza = Raza;
    }

    public clase getClase() {
        return clase;
    }

    public void setClase(clase Clase) {
        this.clase = Clase;
    }

    public ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(ciudad Ciudad) {
        this.ciudad = Ciudad;
    }

    public Map<items, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(Map<items, Integer> inventario) {
        this.inventario = inventario;
    }

    public Map<habilidad, Boolean> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Map<habilidad, Boolean> habilidades) {
        this.habilidades = habilidades;
    }

}




