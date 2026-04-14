package rpg.dao;

import rpg.model.items;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsDAO {
    public ArrayList<items> items;
    private conexion conexion;

    public ItemsDAO() throws SQLException {
        this.conexion = new conexion();
        this.items = new ArrayList<>();
        cargaItems();
    }

    public void cargaItems() {
        ResultSet rs = conexion.consulta("SELECT * FROM Items");
        try {
            while (rs != null && rs.next()) {
                this.items.add(new items(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("precio_oro"),
                        rs.getInt("bonificador_ataque"),
                        rs.getInt("bonificador_defensa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public items getItemById(int id) {
        for (items i : items) {
            if (i.getId() == id) return i;
        }
        return null;
    }
}