package org.example.Entities.Connection;

import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection ConectarBD() {
        Connection conexion;
        String url = "jdbc:mysql://localhost:3306/BuenSabor";
        String usuario = "root";
        String password = "";
        try {
            conexion = (Connection) DriverManager.getConnection(url,usuario,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }
    public static void Desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
