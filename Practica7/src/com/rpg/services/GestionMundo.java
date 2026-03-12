package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.Item;
import com.rpg.model.ciudades;
import com.rpg.model.personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;
import com.rpg.utils.LoggerCustom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionMundo {

    private List<ciudades> listaCiudades;
    private List<personaje> personajes;
    private List<Item> listaItem;
    private HashMap<String, Item> mapItems;

    public GestionMundo() {
        personajes = new ArrayList<>();
        listaCiudades = new ArrayList<>();
        listaItem = new ArrayList<>();
        mapItems = new HashMap<>();
    }

    public void cargarTodo() throws FormatoInvalidoException {
        System.out.println("Ciudades:");
        listaCiudades = TxtHelper.leerciudades();
        System.out.println("Personaje:");
        personajes = JsonHelper.leerPersonaje();
        System.out.println("Item:");
        listaItem = JsonHelper.leerItem();

        // Llenar el mapa de items
        for (Item i : listaItem) {
            mapItems.put(i.getId(), i);
        }
    }

    public void crearPersonaje(String nombre, String raza, Integer nivel, List<String> idItems) throws DatoInvalidoException {
        List<Item> equipo = new ArrayList<>();

        for (String id : idItems) {
            if (!mapItems.containsKey(id)) {
                LoggerCustom.registrarError("Intento de usar item inexistente: " + id + " para " + nombre);
                throw new DatoInvalidoException("El item no existe: " + id);
            }
            equipo.add(mapItems.get(id));
        }

        personaje p = new personaje(nombre, raza, nivel);
        p.setEquipo(equipo);
        personajes.add(p);

        System.out.println("Personaje nuevo creado: " + nombre + " con " + equipo.size() + " items");
    }

    public HashMap<String, Item> getMapItems() {
        return mapItems;
    }
}