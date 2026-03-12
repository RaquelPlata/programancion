import com.rpg.handler.RPGDataException;
import com.rpg.services.GestionMundo;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws RPGDataException {

        GestionMundo gestion = new GestionMundo();

        gestion.cargarTodo();

        gestion.crearPersonaje("Guerrero", "Humano", 100, new ArrayList<>(List.of( "W01"))
        );

    }
}