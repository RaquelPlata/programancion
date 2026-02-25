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
        public static List<Item> leerItem(){
            List<Item> listaItem=new ArrayList<>();
            try {
                FileReader reader = new FileReader("Practica7/ficheros/Item.json");
                Gson gson = new Gson();
                List<Item> lista = gson.fromJson(reader, new TypeToken<List<Item>>() {
                }.getType());

                for (Item i : lista) {
                    System.out.println(i.getNombre());
                }
            }catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return listaItem;

        }
    public static List<personaje> leerpersonaje(){
        List<personaje> listapersonaje=new ArrayList<>();
        try {
            FileReader reader = new FileReader("Practica7/ficheros/personaje.json");
            Gson gson = new Gson();
            List<personaje> lista = gson.fromJson(reader, new TypeToken<List<personaje>>() {
            }.getType());

            for (personaje p : lista) {
                System.out.println(p.getNombre());
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listapersonaje;

    }
}






