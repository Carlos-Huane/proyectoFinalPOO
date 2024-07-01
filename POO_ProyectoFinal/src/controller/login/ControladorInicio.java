package controller.login;

import controller.administrador.ControladorAdmin;
import controller.empleado.ControladorVendedor;
import dao.UsuarioDAO;
import model.Usuario;
import view.VentanaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorInicio implements ActionListener {
    private VentanaInicio ventanaInicio = new VentanaInicio();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public ControladorInicio() {
        this.ventanaInicio.btnLogin.addActionListener(this);
        ventanaInicio.setVisible(true); // Mostrar la ventana de inicio
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaInicio.btnLogin) {
            String nombreUsuario = ventanaInicio.txtUsuario.getText();
            String contraseña = ventanaInicio.txtContraseña.getText();

            Usuario usuario = usuarioDAO.obtenerUsuarioPorCredenciales(nombreUsuario, contraseña);

            if (usuario != null) {
                if ("administrador".equalsIgnoreCase(usuario.getRol())) {
                    // Redirigir a la ventana del administrador
                    new ControladorAdmin();
                } else if ("vendedor".equalsIgnoreCase(usuario.getRol())) {
                    // Redirigir a la ventana del vendedor
                    new ControladorVendedor();
                }
                ventanaInicio.dispose(); // Cerrar la ventana de login
            } else {
                // Mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
        }
    }
}
