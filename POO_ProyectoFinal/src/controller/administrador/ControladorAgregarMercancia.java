package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.Admin5_mercancia;
public class ControladorAgregarMercancia implements ActionListener{
    Admin5_mercancia ventana = new Admin5_mercancia();
    
    public ControladorAgregarMercancia(){
        ventana.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
     
    }
}
