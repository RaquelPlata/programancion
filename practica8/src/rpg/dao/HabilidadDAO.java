package rpg.dao;

import rpg.model.habilidad;
import rpg.model.habilidad;
import rpg.model.personaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadDAO {
    private ArrayList<habilidad> habilidades;
    private conexion conexion;

    public HabilidadDAO() throws SQLException {
        this.habilidades = new ArrayList<>();
        this.conexion = new conexion();
        cargaHabilidades();
    }

    public void cargaHabilidades() {
        ResultSet resultset = conexion.consulta("SELECT * FROM Habilidades");
        try {
            while (resultset != null && resultset.next()) {
                this.habilidades.add(new habilidad(
                        resultset.getInt("id"),
                        resultset.getString("nombre"),
                        resultset.getInt("dano_base"),
                        resultset.getInt("usos_maximos"),
                        resultset.getInt("id_clase")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargaHabilidadesEnPersonajes(personaje p) {
        ResultSet rs = conexion.consulta("SELECT * FROM personajes_habilidades WHERE id_personaje = " + p.getId());
        try {
            while (rs != null && rs.next()) {
                habilidad h = buscahabilidadPorId(rs.getInt("id_habilidad"));
                if (h != null) {
                    p.getHabilidades().put(h, rs.getBoolean("equipada_combate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public habilidad buscahabilidadPorId(Integer id) {
        for (habilidad h : habilidades) {
            if (h.getId().equals(id)) return h;
        }
        return null;
    }
}