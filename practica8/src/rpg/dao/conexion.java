package rpg.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static final String url ="jdbc:postgresql://localhost:5432/XRPG";
    private static final String user = "xrpg_user";
    private static final String password = "xrpg_password";

    public static conexion getConexion() throws SQLException {
        try {
            return (conexion) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("No se ha podido establecer conexion con la base de datos", e);
        }
    }

}

