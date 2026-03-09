package com.rpg.utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.model.Item;
import com.rpg.model.personaje;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    public JsonHelper(){}
    public static List<Item> leerItem() {

        List<Item> listaItem = new ArrayList<>();

        try {
            FileReader reader = new FileReader("practica7/ficheros/item.json");
            Gson g = new Gson();
            List<Item> lista = g.fromJson(reader, new TypeToken<List<Item>>() {}.getType());

            for (Item t : lista) {
                System.out.println(t.getNombre());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaItem;
    }
    public static List<personaje> leerPersonaje() {

        List<personaje> listaPersonaje = new ArrayList<>();

        try {
            FileReader reader = new FileReader("practica7/ficheros/personaje.json");
            Gson g = new Gson();
            List<personaje> lista = g.fromJson(reader, new TypeToken<List<personaje>>() {}.getType());

            for (personaje p : lista) {
                System.out.println(p.getNombre());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaPersonaje;
    }
}





