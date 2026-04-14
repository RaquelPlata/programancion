package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    // Asegúrate de que la carpeta "ficheros" exista en la raíz de tu proyecto
    private static final String RUTA_LOG = "info.log";

    public static void Error(String mensaje) {
        // El bloque try(...) asegura que el BufferedWriter se cierre solo al terminar
        try (FileWriter fw = new FileWriter(RUTA_LOG, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            LocalDateTime tiempo = LocalDateTime.now();
            DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");

            String fecha = tiempo.format(formateo);
            String linea = "{" + fecha + "} " + mensaje;

            bw.write(linea);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}