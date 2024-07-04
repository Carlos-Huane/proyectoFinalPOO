package dao;

import model.Usuario; //importamos esta clase para almacenar el valor de retorno del método obtenerUsuarioPorCredenciales
import java.sql.Connection; //clase usada para almacenar el resultado de la conexión a la BD (el método establecido en la clase Conexion)
import model.Conexion;//clase creada para colocar todo lo referente a la configuración de la conexión y establecer el método que genere la conexión a la BD

import java.sql.PreparedStatement; //clase para preparar una consulta en la base de datos (BD)
import java.sql.ResultSet; //clase para obtener el resultado de la consulta

public class UsuarioDAO {
    public Usuario obtenerUsuarioPorCredenciales(String usuario, String contraseña) {
    Usuario user = null; // Variable para almacenar el usuario encontrado (si existe).
    Conexion conexion = new Conexion(); // Crear una instancia de la clase Conexio para hacer uso de su método y establecer la conexión
    Connection con = conexion.obtenerConexion(); // Obtener una conexión a la base de datos.

    if (con != null) { // Verificar si la conexión se estableció correctamente.
        try {
            // Query SQL para buscar el usuario en la BD ('?' simboliza los valores a reemplazar: el usuario y contraseña ingresados)
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
