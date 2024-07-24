package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Conexion instancia;
    private Connection connection;

    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbancog8","root","root");
            this.connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexion getConexion() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getSQLConexion() {
        try {
            if (connection == null || connection.isClosed()) {
            	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbancog8","root","root");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void cerrarConexion() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instancia = null;
    }
}