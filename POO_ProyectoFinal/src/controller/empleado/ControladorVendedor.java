package controller.empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.VentanaEmpleado_1;

import controller.empleado.ControladorCobrar;
public class ControladorVendedor implements ActionListener{
       
       private VentanaEmpleado_1 ventanaEmpleado_1 = new VentanaEmpleado_1();
       public ControladorVendedor(){
           ventanaEmpleado_1.setVisible(true);
           this.ventanaEmpleado_1.btnCobrar.addActionListener(this);
           this.ventanaEmpleado_1.btnAgregar.addActionListener(this);
           
       }
       public void actionPerformed(ActionEvent e){
       if (e.getSource() == ventanaEmpleado_1.btnCobrar) {
        ControladorCobrar controladorCobrar = new ControladorCobrar();
       }
       if (e.getSource() == ventanaEmpleado_1.btnAgregar) {
           String codigo = ventanaEmpleado_1.txtCodigo.getText();
           int cantidad = Integer.parseInt(ventanaEmpleado_1.txtCantidad.getText());
           
       }
       
    }
}
