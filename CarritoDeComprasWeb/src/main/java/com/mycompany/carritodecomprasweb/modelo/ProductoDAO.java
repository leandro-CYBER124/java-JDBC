package com.mycompany.carritodecomprasweb.modelo;

import com.mycompany.carritodecomprasweb.configuraciones.Coneccion;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Connection con;
    Coneccion cn = new Coneccion();
    PreparedStatement ps;
    ResultSet rs;

    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        String sql = "select *from producto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mostrar errores
        }
        return productos;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?"+id;
        try (OutputStream outputStream = response.getOutputStream()) {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                try (InputStream inputStream = rs.getBinaryStream("foto");
                     BufferedInputStream bis = new BufferedInputStream(inputStream);
                     BufferedOutputStream bos = new BufferedOutputStream(outputStream)) {
                    int i;
                    while ((i = bis.read()) != -1) {
                        bos.write(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mostrar errores
        }
    }
}
