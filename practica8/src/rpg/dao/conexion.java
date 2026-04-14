package rpg.dao;

import java.sql.*;

public class conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private static final String USER = "xrpg_user";
    private static final String PASSWORD = "xrpg_password";
    private static Connection connection;

    public conexion() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error de conexión: " + e.getMessage());
        }
    }

    public ResultSet consulta(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void closeConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}