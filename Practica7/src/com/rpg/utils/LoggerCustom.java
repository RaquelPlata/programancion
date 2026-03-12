package com.rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerCustom {

    private static String rutaArchivoLog = "practica7/ficheros/info.log";

    public static void registrarError(String mensaje) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoLog, true));
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String linea = "[" + fechaActual.format(formato) + "] ERROR: " + mensaje;
            bw.write(linea);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el log: " + e.getMessage());
        }
    }
}