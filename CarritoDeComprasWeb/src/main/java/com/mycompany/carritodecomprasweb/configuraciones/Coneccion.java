package com.mycompany.carritodecomprasweb.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;

public class Coneccion {
    
    Connection con;

    // ✅ Ajustado con tu configuración
    String url = "jdbc:mysql://localhost:3307/dbcarritocompras"; // <-- Cambia "dbcarritocompras" si tu base se llama diferente
    String user = "root";
    String pass = "123456"; // <-- Poné tu contraseña si tiene

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
             System.out.println("------con");
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("Error conexión: " + e.getMessage());
        }
        return con;
    }
}

