package controller.login;

import controller.administrador.ControladorAdmin;
import controller.empleado.ControladorVendedor;
import dao.UsuarioDAO;
import model.Usuario;
import view.VentanaInicio;

import java.awt.event.ActionEvent; //clase del paquete java.awt.event
import java.awt.event.ActionListener; //interface del paquete java.awt.event

import javax.swing.JOptionPane;

public class ControladorInicio implements ActionListener {
    private VentanaInicio ventanaInicio = new VentanaInicio(); //permite interactuar con el formulario (hacer uso de los botones y cuadros de texto)
    private UsuarioDAO usuarioDAO = new UsuarioDAO(); //permite usar el método obtenerUsuarioPorCredenciales

    public ControladorInicio() {
        this.ventanaInicio.btnLogin.addActionListener(this); //configura a btnLogin como un listener, para que escuche un evento como darle click al botón
        ventanaInicio.setVisible(true); // Mostrar la ventana de inicio
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaInicio.btnLogin) { //si se aprieta el boton ingresar
            String nombreUsuario = ventanaInicio.txtUsuario.getText(); //se captura el usuario ingresado
            String contraseña = ventanaInicio.txtContraseña.getText(); //se captura la contraseña ingresada

            Usuario usuario = usuarioDAO.obtenerUsuarioPorCredenciales(nombreUsuario, contraseña);
            //se usa el método de UsuarioDAO para corroborar el login y se almacena en una variable 
            //del tipo Usuario porque así está definido en el método
            
            if (usuario != null) { //si se encuentra un usuario en la BD se pasará a evaluar una 2da condición
                //según sea el rol del usuario, se abrirá la ventana correspondiente
                if ("administrador".equalsIgnoreCase(usuario.getRol())) {
                    // Redirigir a la ventana del administrador
                    new ControladorAdmin(); //se llama al constructor y se abre la ventana
                } else if ("vendedor".equalsIgnoreCase(usuario.getRol())) {
                    // Redirigir a la ventana del vendedor
                    new ControladorVendedor(); //se llama al constructor y se abre la ventana
                }
                ventanaInicio.dispose(); // Al abrir la ventana anterior, se cerrará la ventana de login
            } else {
                // Mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
        }
    }
}
