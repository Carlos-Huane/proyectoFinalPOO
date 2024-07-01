package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Producto;
import model.Conexion;

public class VendedorDAO {

    public Producto obtenerProductoPorCodigo(String codigo) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();
        
        Producto producto = null;

        try {
            String query = "SELECT * FROM productos WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Utilizar el constructor con parámetros
                producto = new Producto(
                    rs.getString("Codigo"),
                    rs.getString("Nombre"),
                    rs.getFloat("Precio_de_venta"),
                    rs.getFloat("Precio_de_compra"),
                    rs.getInt("Cantidad"),
                    rs.getString("Marca")
                );
            }
            System.out.println(producto);
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return producto;
    }
}
