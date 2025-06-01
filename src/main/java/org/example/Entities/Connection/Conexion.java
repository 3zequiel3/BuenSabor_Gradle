package org.example.Entities.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection ConectarBD() {
        Connection conexion;
        String url = "jdbc:mysql://localhost:3306/buensabor" ;
        String usuario = "root";
        String password = "";
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }
    public static void Desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
