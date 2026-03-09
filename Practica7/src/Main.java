import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

public class Main {
    public static void main(String[] args){
        System.out.println("Ciudades:");
        TxtHelper t = new TxtHelper();
        System.out.println(t.leerciudades());
        System.out.println("Item:");
        JsonHelper j = new JsonHelper();
        System.out.println(j.leerItem());
        System.out.println("personajes:");
        System.out.println(j.leerPersonaje());
    }
}