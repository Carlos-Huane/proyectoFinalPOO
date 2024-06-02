package controller.login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaInicio;

import model.Usuario;

public class ControladorInicio implements ActionListener{
    private VentanaInicio ventanaInicio;
    private Usuario usuario = new Usuario("", "");
    public ControladorInicio(VentanaInicio ventanaInicio){
        this.ventanaInicio = ventanaInicio;
        this.ventanaInicio.btnLogin.addActionListener(this);
        ventanaInicio.setVisible(true); //PARA QUE APAREZCA LA VENTANA INICIO
        
    }
    public void actionPerformed(ActionEvent e){
       if (e.getSource() == ventanaInicio.btnLogin) {
            System.out.println("hola mundo");
        }
    }
}
