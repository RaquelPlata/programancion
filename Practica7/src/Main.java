import com.rpg.handler.RPGDataException;
import com.rpg.services.GestionMundo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws RPGDataException {

        GestionMundo gestion = new GestionMundo();

        gestion.cargarTodo();

        gestion.crearPersonaje(
                "Mago",
                "Enano",
                150,
                new ArrayList<>(List.of( "P01"))
        );

    }
}