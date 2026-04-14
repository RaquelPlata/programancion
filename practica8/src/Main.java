import rpg.ui.Menu;
import rpg.logic.Combate;
import rpg.dao.PersonajeDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonajeDAO pDAO = new PersonajeDAO();
        Combate motor = new Combate(pDAO);
        new Menu(motor).iniciar();
    }
}