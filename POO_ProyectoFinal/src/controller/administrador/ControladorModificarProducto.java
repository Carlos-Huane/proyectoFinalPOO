package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.Admin3_modificar;
public class ControladorModificarProducto implements ActionListener{
    private Admin3_modificar ventanaModificar = new Admin3_modificar();
    
    public ControladorModificarProducto(){
        ventanaModificar.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
       
    }
}
