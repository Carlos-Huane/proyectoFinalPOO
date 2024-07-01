package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con;

    public Connection obtenerConexion() {
        String bd = "dbprueba";
        String host = "localhost";
        String port = "1433";
        String user = "sa";
        String password = "12345678";

        // Opción 1: Confiar en el certificado del servidor (útil en desarrollo)
        String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + bd + ";encrypt=true;trustServerCertificate=true;";

        // Opción 2: Deshabilitar el cifrado (útil en entornos seguros donde SSL no es necesario)
        // String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + bd + ";encrypt=false;";

        // Opción 3: Si importaste el certificado al almacén de certificados de Java, usa la cadena básica:
        // String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + bd + ";encrypt=true;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Éxito en conexión");
            return con;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}
