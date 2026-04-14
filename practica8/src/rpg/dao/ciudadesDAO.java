package rpg.dao;

import rpg.model.ciudad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ciudadesDAO {
    private ArrayList<ciudad> ciudades;
    private conexion conexion;

    public ciudadesDAO() throws SQLException {
        this.ciudades = new ArrayList<>();
        this.conexion = new conexion();
        cargaCiudades();
    }

    public void cargaCiudades() {
        ResultSet resultset = conexion.consulta("SELECT * FROM ciudades");
        try {
            while (resultset != null && resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer nivel = resultset.getInt("nivel_minimo_acceso");
                this.ciudades.add(new ciudad(id, nombre, nivel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ciudad buscaCiudadPorId(Integer id) {
        for (ciudad c : ciudades) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    public ArrayList<ciudad> getCiudades() { return ciudades; }
}