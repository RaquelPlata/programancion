package com.rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerCustom {
    private static String rutaarchivoLog = "practica7/ficheros/info.log";

    public static  void registrarError(String mensaje){

        try {
            FileWriter escritorArchivo = new FileWriter(rutaarchivoLog,true);
            BufferedWriter bufferedWriter= new BufferedWriter(escritorArchivo);
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formatofecha = DateTimeFormatter.ofPattern("yyyy-MM HH:mm:ss");
            String fechaFormateada = fechaActual.format(formatofecha);

            // Crear línea del log

            String lineaLog = "[" + fechaFormateada + "] ERROR: " + mensaje;
            bufferedWriter.write(lineaLog); // escribir en el archivo
            bufferedWriter.newLine(); // salto de línea
            bufferedWriter.close(); // cerrar writer



        } catch (IOException e) {

            System.out.println("Error escribiendo en el log.");

        }

    }

}


