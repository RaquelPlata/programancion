package rpg.dao;

import rpg.model.raza;

import java.sql.*;
import java.util.ArrayList;

public class razaDAO {
    private ArrayList<raza> razas;
    private conexion conexion;

    public razaDAO() throws SQLException {
        this.conexion=new conexion();
        this.razas=new ArrayList<>();
        cargaRazas();
    }

    public ArrayList<raza> getRazas() {
        return razas;
    }

    public void setRazas(ArrayList<raza> razas) {
        this.razas = razas;
    }

    public conexion getConexion() {
        return conexion;
    }

    public void setconexion(conexion Conexion) {
        this.conexion = conexion;
    }

    public void cargaRazas(){
        ResultSet resultset = conexion.consulta("SELECT * FROM razas");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer bonificador_vida = resultset.getInt("bonificador_vida");
                Integer bonificador_fuerza = resultset.getInt("bonificador_fuerza");

                this.razas.add(new raza(id, nombre, bonificador_vida, bonificador_fuerza));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public raza buscaRazaPorId(Integer id){
        for (raza r : razas){
            if (r.getId().equals(id)){
                return r;
            }
        }
        return null;
    }
}
