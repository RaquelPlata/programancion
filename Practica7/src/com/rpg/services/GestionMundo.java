package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Item;
import com.rpg.model.personaje;
import com.rpg.model.ciudades;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionMundo {

    private List<ciudades> listaCiudades;
    private List<personaje> personajes;
    private List<Item> listaItem;
    private HashMap<String, Item> mapItems;

    public GestionMundo() {
        listaCiudades = new ArrayList<>();
        personajes = new ArrayList<>();
        listaItem = new ArrayList<>();
        mapItems = new HashMap<>();
    }

    public void cargarTodo() {
        System.out.println("Las ciudades son:");
        listaCiudades = TxtHelper.leerciudades();
        System.out.println("Las personaje son:");
        personajes = JsonHelper.leerPersonaje();
        System.out.println("Las item son:");
        listaItem = JsonHelper.leerItem();

        for (Item i : listaItem) {
            mapItems.put(i.getId(), i);
        }
    }

    public void crearPersonaje(String nombre, String raza, Integer nivel, List<String> idItems) throws DatoInvalidoException , RecursoNoEncontradoException, RPGDataException {

        List<Item> equipo = new ArrayList<>();

        for (String id : idItems) {

            if (!mapItems.containsKey(id)) {
                throw new DatoInvalidoException("El item no existe");
            }

            equipo.add(mapItems.get(id));
        }

        personaje p = new personaje(nombre, raza, nivel);
        p.setEquipo(equipo);

        personajes.add(p);
    }
}