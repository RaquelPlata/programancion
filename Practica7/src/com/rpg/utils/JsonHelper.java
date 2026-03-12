package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.Item;
import com.rpg.model.personaje;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JsonHelper {

    public JsonHelper() { }

    // Leer Items
    public static List<Item> leerItem() throws FormatoInvalidoException {
        try {
            FileReader reader = new FileReader("practica7/ficheros/Item.json");
            Gson gson = new Gson();
            List<Item> listaItem = gson.fromJson(reader, new TypeToken<List<Item>>(){}.getType());

            for (Item i : listaItem) {
                System.out.println("Item cargado: " + i.getId() + " - " + i.getNombre());
            }

            return listaItem;

        } catch (FileNotFoundException e) {
            throw new FormatoInvalidoException("Item.json no encontrado: " + e.getMessage());
        } catch (Exception e) {
            throw new FormatoInvalidoException("Error de formato en Item.json: " + e.getMessage());
        }
    }

    // Leer personajes
    public static List<personaje> leerPersonaje() throws FormatoInvalidoException {
        try {
            FileReader reader = new FileReader("practica7/ficheros/personaje.json");
            Gson gson = new Gson();
            List<personaje> listaPersonaje = gson.fromJson(reader, new TypeToken<List<personaje>>(){}.getType());

            for (personaje p : listaPersonaje) {
                System.out.println("Personaje cargado: " + p.getNombre());
            }

            return listaPersonaje;

        } catch (FileNotFoundException e) {
            throw new FormatoInvalidoException("personaje.json no encontrado: " + e.getMessage());
        } catch (Exception e) {
            throw new FormatoInvalidoException("Error de formato en personaje.json: " + e.getMessage());
        }
    }

    // Guardar personajes
    public static void guardarPersonajes(List<personaje> personajes) throws FormatoInvalidoException {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("practica7/ficheros/personaje.json"); // sobrescribe
            gson.toJson(personajes, writer);
            writer.close();
            System.out.println("Archivo personaje.json guardado correctamente.");
        } catch (IOException e) {
            throw new FormatoInvalidoException("No se pudo guardar personaje.json: " + e.getMessage());
        }
    }
}