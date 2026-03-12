package com.rpg.utils;

import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.ciudades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {

    public TxtHelper() { }

    public static List<ciudades> leerciudades() throws FormatoInvalidoException {
        List<ciudades> listaCiudades = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica7/ficheros/ciudades.txt"));

            for (String linea : lineas) {
                String[] datos = linea.split(";");

                if (datos.length != 4) {
                    throw new FormatoInvalidoException("Formato incorrecto en la línea: " + linea);
                }

                ciudades c = new ciudades(
                        datos[0],
                        Integer.parseInt(datos[1]),
                        datos[2],
                        Integer.parseInt(datos[3])
                );

                listaCiudades.add(c);
            }

            for (ciudades c : listaCiudades) {
                System.out.println("Ciudad cargada: " + c.getNombre());
            }

            return listaCiudades;

        } catch (IOException e) {
            throw new FormatoInvalidoException("No se pudo leer ciudades.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new FormatoInvalidoException("Número inválido en ciudades.txt: " + e.getMessage());
        }
    }
}