package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/tu_base";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_password";

    public static Connection getConexion() {
        Connection con = null;
        try {
            // Si usas MySQL 8+
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }
}


