package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.Admin1_buscar;

//CONTROLADORES
import controller.administrador.ControladorAgregarProducto;
import controller.administrador.ControladorAgregarMercancia;
import controller.administrador.ControladorEliminarProducto;
import controller.administrador.ControladorModificarProducto;

public class ControladorAdmin implements ActionListener{
    private Admin1_buscar ventanaAdmin = new Admin1_buscar();
    
    public ControladorAdmin(){
        ventanaAdmin.setVisible(true);
        this.ventanaAdmin.btnAgregarProducto.addActionListener(this);
        this.ventanaAdmin.btnEliminarProducto.addActionListener(this);
        this.ventanaAdmin.btnModificarProducto.addActionListener(this);
        this.ventanaAdmin.btnAgregarMercancia.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
       if (e.getSource() == ventanaAdmin.btnAgregarMercancia) {
        ControladorAgregarMercancia agregarMercancia = new ControladorAgregarMercancia();
       }
       if (e.getSource() == ventanaAdmin.btnEliminarProducto) {
        ControladorEliminarProducto eliminarProducto = new ControladorEliminarProducto();
       }
       if (e.getSource() == ventanaAdmin.btnAgregarProducto) {
        ControladorAgregarProducto agregarProducto = new ControladorAgregarProducto();
       }
       if (e.getSource() == ventanaAdmin.btnModificarProducto) {
        ControladorModificarProducto modificarProducto = new ControladorModificarProducto();
       }
    }
}
