package controller.login;

import controller.administrador.ControladorAdmin;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaInicio;

import controller.empleado.ControladorVendedor;
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
            
            //aca debemos establecer que atravez de una llamada a la base de datos diriga a la ventana admin o empleado
            //ControladorVendedor controladorVendedor = new ControladorVendedor();
            ControladorAdmin controladorAdmin = new ControladorAdmin();
        }
    }
}
