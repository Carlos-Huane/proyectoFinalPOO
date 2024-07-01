package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Conexion;


public class UsuarioDAO {
    public Usuario obtenerUsuarioPorCredenciales(String usuario, String contraseña) {
    Usuario user = null; // Variable para almacenar el usuario encontrado (si existe).
    Conexion conexion = new Conexion(); // Crear una instancia de la clase Conexion.
    Connection con = conexion.obtenerConexion(); // Obtener una conexión a la base de datos.

    if (con != null) { // Verificar si la conexión se estableció correctamente.
        try {
            // Query SQL para buscar el usuario en la base de datos.
            String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
            
            // Preparar el statement para ejecutar la consulta SQL.
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, usuario); // Establecer el primer parámetro (?).
            pstmt.setString(2, contraseña); // Establecer el segundo parámetro (?).
            
            // Ejecutar la consulta y obtener el resultado.
            ResultSet rs = pstmt.executeQuery();

            // Si el resultado tiene una fila, significa que las credenciales son válidas.
            if (rs.next()) {
                // Extraer los datos del usuario del ResultSet.
                String nombreUsuario = rs.getString("usuario");
                String rol = rs.getString("rol");
                // Crear una instancia del Usuario con los datos obtenidos.
                user = new Usuario(nombreUsuario, contraseña, rol);
            }

            // Cerrar la conexión después de usarla.
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Manejar cualquier excepción que ocurra.
        }
    }
    return user; // Retornar el usuario encontrado o null si no existe.
    }

}
