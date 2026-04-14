package rpg.dao;

import rpg.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonajeDAO {
     private ArrayList<personaje> personajes;
     private conexion conexion;
     private razaDAO razaDAO;
     private clase_rpgDAO clase_rpgDAO;
     private ciudadesDAO ciudadesDAO;
     private HabilidadDAO habilidadDAO;

     public PersonajeDAO() throws SQLException {
          this.personajes = new ArrayList<>();
          this.conexion = new conexion();
          this.razaDAO = new razaDAO();
          this.clase_rpgDAO = new clase_rpgDAO();
          this.ciudadesDAO = new ciudadesDAO();
          this.habilidadDAO = new HabilidadDAO();
          cargaPersonaje();
     }

     public void cargaPersonaje() {
          // Limpiamos la lista local para recargarla de la base de datos
          this.personajes.clear();
          ResultSet rs = conexion.consulta("SELECT * FROM personajes");
          try {
               while (rs != null && rs.next()) {
                    raza r = razaDAO.buscaRazaPorId(rs.getInt("id_raza"));
                    clase c = clase_rpgDAO.buscaClasePorId(rs.getInt("id_clase"));
                    ciudad ciu = ciudadesDAO.buscaCiudadPorId(rs.getInt("id_ciudad_actual"));

                    personaje p = new personaje(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("nivel"),
                            rs.getInt("oro"),
                            rs.getInt("vida_actual"),
                            r, c, ciu
                    );

                    habilidadDAO.cargaHabilidadesEnPersonajes(p);
                    this.personajes.add(p);
               }
          } catch (SQLException e) {
               e.printStackTrace();
          }
     }

     // --- 1. MÉTODO PARA VIAJAR (ACTUALIZAR CIUDAD) ---
     public void cambiarCiudadPersonaje(personaje p, ciudad c) {
          String sql = "UPDATE personajes SET id_ciudad_actual = " + c.getId() + " WHERE id = " + p.getId();
          conexion.executeUpdate(sql);
          p.setCiudad(c); // Actualizamos el objeto en memoria
     }

     // --- 2. MÉTODO PARA LA TIENDA Y COMBATE (ACTUALIZAR ORO) ---
     public void actualizarOro(personaje p) {
          String sql = "UPDATE personajes SET oro = " + p.getOro() + " WHERE id = " + p.getId();
          conexion.executeUpdate(sql);
     }

     // --- 3. MÉTODO PARA LOS IMPUESTOS (DESTIERRO) ---
     public void desterrar(personaje p) {
          // Según la práctica, si no tienen oro se quedan sin ciudad (NULL)
          String sql = "UPDATE personajes SET id_ciudad_actual = NULL WHERE id = " + p.getId();
          conexion.executeUpdate(sql);
          p.setCiudad(null);
     }

     // --- 4. MÉTODO PARA EL MENÚ (OBTENER LISTA) ---
     public ArrayList<personaje> getPersonajes() {
          return personajes;
     }

     public Integer insertarPesonajeEnBD(String nombre, Integer nivel, Integer oro, Integer vida, raza r, clase c, ciudad ciu) {
          String sql = String.format(
                  "INSERT INTO personajes (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) " +
                          "VALUES ('%s', %d, %d, %d, %d, %d, %d) RETURNING id",
                  nombre, nivel, oro, vida, r.getId(), c.getId(), ciu.getId()
          );

          ResultSet rs = conexion.consulta(sql);
          try {
               if (rs != null && rs.next()) return rs.getInt("id");
          } catch (SQLException e) {
               e.printStackTrace();
          }
          return null;
     }
}