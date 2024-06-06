package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.Admin4_eliminar;

public class ControladorEliminarProducto implements ActionListener{
    private Admin4_eliminar ventanaEliminar = new Admin4_eliminar();
    
    public ControladorEliminarProducto(){
        ventanaEliminar.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
       
    }
}
