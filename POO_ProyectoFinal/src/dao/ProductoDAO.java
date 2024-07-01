package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Conexion;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean agregarProducto(Producto producto) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();
        
        if (con != null) {
            try {
                String query = "INSERT INTO Productos (Codigo, Nombre, Precio_de_venta, Precio_de_compra, Cantidad, Marca) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, producto.getCodigo());
                pstmt.setString(2, producto.getNombre());
                pstmt.setFloat(3, producto.getPrecioVenta());
                pstmt.setFloat(4, producto.getPrecioCompra());
                pstmt.setInt(5, producto.getCantidad());
                pstmt.setString(6, producto.getMarca());
                
                int resultado = pstmt.executeUpdate(); //Devuelve un entero que representa el número de filas afectadas por la operación SQL.
                con.close();
                
                return resultado > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    // Método para modificar un producto existente en la base de datos
    public boolean modificarProducto(Producto producto) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();
        
        if (con != null) {
            try {
                String query = "UPDATE Productos SET Nombre = ?, Precio_de_venta = ?, Precio_de_compra = ?, Cantidad = ?, Marca = ? WHERE Codigo = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, producto.getNombre());
                pstmt.setFloat(2, producto.getPrecioVenta());
                pstmt.setFloat(3, producto.getPrecioCompra());
                pstmt.setInt(4, producto.getCantidad());
                pstmt.setString(5, producto.getMarca());
                pstmt.setString(6, producto.getCodigo());
                
                int resultado = pstmt.executeUpdate(); // Ejecutar la actualización
                
                con.close();
                
                return resultado > 0; // Devuelve true si se actualizó al menos una fila
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    // Método para eliminar un producto de la base de datos por su código
    public boolean eliminarProducto(String codigo) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();
        
        if (con != null) {
            try {
                String query = "DELETE FROM Productos WHERE Codigo = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, codigo);
                
                int resultado = pstmt.executeUpdate(); // Ejecutar la eliminación
                
                con.close();
                
                return resultado > 0; // Devuelve true si se eliminó al menos una fila
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean agregarMercancia(String codigo, int cantidad) {
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();
        
        if (con != null) {
            try {
                // Consulta para actualizar la cantidad de mercancía del producto
                String query = "UPDATE Productos SET Cantidad = Cantidad + ? WHERE Codigo = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, cantidad);
                pstmt.setString(2, codigo);
                
                int resultado = pstmt.executeUpdate(); // Ejecutar la actualización
                
                con.close();
                
                return resultado > 0; // Devuelve true si se actualizó al menos una fila
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public List<Producto> obtenerTodosProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        Conexion conexionBD = new Conexion();
        Connection con = conexionBD.obtenerConexion();

        if (con != null) {
            try {
                String query = "SELECT * FROM Productos";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Producto producto = new Producto(
                        rs.getString("Codigo"),
                        rs.getString("Nombre"),
                        rs.getFloat("Precio_de_venta"),
                        rs.getFloat("Precio_de_compra"),
                        rs.getInt("Cantidad"),
                        rs.getString("Marca")
                    );

                    listaProductos.add(producto);
                }

                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaProductos;
    }
}
