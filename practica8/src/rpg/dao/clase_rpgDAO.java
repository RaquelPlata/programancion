package rpg.dao;

import rpg.model.clase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clase_rpgDAO {
    private ArrayList<clase> clases; // Corregido de <conexion> a <clase>
    private conexion conexion;

    public clase_rpgDAO() throws SQLException {
        this.clases = new ArrayList<>();
        this.conexion = new conexion();
        cargarClases();
    }

    public void cargarClases() {
        ResultSet resultset = conexion.consulta("SELECT * FROM clases_rpg");
        try {
            while (resultset != null && resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                this.clases.add(new clase(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public clase buscaClasePorId(Integer id) {
        for (clase c : clases) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    public ArrayList<clase> getClases() { return clases; }
}