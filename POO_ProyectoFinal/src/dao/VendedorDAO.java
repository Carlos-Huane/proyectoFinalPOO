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
    // Nuevo método para actualizar la cantidad de un producto
    public boolean actualizarCantidadProducto(String codigo, int nuevaCantidad) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();

        boolean exito = false;

        try {
            String query = "UPDATE productos SET Cantidad = ? WHERE Codigo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, codigo);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        return exito;
    }
}
