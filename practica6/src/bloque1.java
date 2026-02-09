import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//El Registro de Muertes: Crea un ArrayList llamado registroCombate.
//Añade 5 eventos (ej: "Orco derrotado", "Poción usada").
// Luego, muestra el tercer evento que ocurrió.
public class bloque1 {
    public static void main(String[] args) {
        System.out.println("\nEjercicio 1: Registro de Muertes");
        ArrayList<String> registroCombate = new ArrayList<>();
        registroCombate.add("Orco derrotado");
        registroCombate.add("Poción usada");
        registroCombate.add("Trampa activada");
        registroCombate.add("Cofre abierto");
        registroCombate.add("Jefe avistado");
        System.out.println("Tercer evento: " + registroCombate.get(2));

        //Crea un HashSet de nombres de villanos.
        // Intenta añadir a "Morgoth" dos veces.
        // Al final, imprime el tamaño del Set para demostrar que no se duplicó.
        System.out.println("\nEjercicio 2: HashSet de Villanos");
        HashSet<String> villanos = new HashSet<>();
        villanos.add("Sauron");
        villanos.add("Morgoth");
        villanos.add("Morgoth");

        System.out.println("Tamaño del HashSet: " + villanos.size());

        //Crea un HashMap<String, Integer> donde la clave sea el nombre del aventurero y el valor su cantidad de oro.
        // Añade a 3 héroes y muestra el oro de uno de ellos usando su nombre.
        System.out.println("\nEjercicio 3: HashMap de Aventureros");
        HashMap<String, Integer> heroes = new HashMap<>();
        heroes.put("Pepe",150);
        heroes.put("Raquel",250);
        heroes.put("Abelardo",300);
        System.out.println("Oro de Abelardo: " + heroes.get("Abelardo"));
        System.out.println("Oro de Pepe: " + heroes.get("Pepe"));
        System.out.println("Oro de Raquel: " + heroes.get("Raquel"));

        //Usando el ArrayList del ejercicio 1, elimina el evento más antiguo (índice 0) y añade uno nuevo al final ("Dragón avistado").
        System.out.println("\nEjercicio 4: ArrayList de Eventos");
        registroCombate.remove(0);
        registroCombate.add("Dragón avistado");
        System.out.println("Eventos: " + registroCombate);

        //Crea un HashMap<String, Double> con nombres de hechizos y sus costos de maná.
        // Usa un bucle para imprimir todos los hechizos que cuesten más de 50 de maná.
        System.out.println("\nEjercicio 5: HashMap de Hechizos");
        HashMap<String, Double> hechizos = new HashMap<>();
        hechizos.put("Rayo", 60.0);
        hechizos.put("Bola de fuego", 45.0);
        hechizos.put("Hielo Purificador", 100.0);
        hechizos.put("Hielo Igneo", 40.0);

        System.out.println("Hechizos con costo > 50:");
        for (Map.Entry<String, Double> entry : hechizos.entrySet()) {
            if (entry.getValue() > 50) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }

        //En tu HashSet de villanos, verifica si "Sauron" está presente.
        // Si está, elimínalo porque ha sido derrotado.
        System.out.println("\nEjercicio 6: HashSet de Villanos");
        if (villanos.contains("Sauron")) {
            villanos.remove("Sauron");
            System.out.println("Sauron ha sido derrotado.");
        }
        System.out.println("Tamaño del HashSet: " + villanos.size());
    }
}
