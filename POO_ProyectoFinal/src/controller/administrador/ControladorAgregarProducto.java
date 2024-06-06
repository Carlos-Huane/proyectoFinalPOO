package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.Admin2_agregar;
public class ControladorAgregarProducto implements ActionListener{
    private Admin2_agregar ventanaAgregar = new Admin2_agregar();
    
    public ControladorAgregarProducto(){
        ventanaAgregar.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
       
    }
}
