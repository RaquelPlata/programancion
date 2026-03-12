import com.rpg.handler.RPGDataException;
import com.rpg.services.GestionMundo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws RPGDataException {

        GestionMundo gestion = new GestionMundo();

        gestion.cargarTodo();

        gestion.crearPersonaje(
                "Aragorn",
                "Humano",
                20,
                new ArrayList<>(List.of( "E01"))
        );

    }
}