package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaInicio;
import model.Usuario;
public class ControladorInicio implements ActionListener{
    private VentanaInicio ventanaInicio;
    private Usuario usuario;
    public ControladorInicio(VentanaInicio ventanaInicio, Usuario usuario){
        this.ventanaInicio = ventanaInicio;
        this.usuario = usuario;
        ventanaInicio.setVisible(true); //PARA QUE APAREZCA LA VENTANA INICIO
    }
    public void actionPerformed(ActionEvent e){
       
    }
}
