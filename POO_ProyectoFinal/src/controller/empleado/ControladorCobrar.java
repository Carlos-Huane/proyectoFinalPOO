package controller.empleado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import model.Producto;

import view.VentanaEmpleado_2;
public class ControladorCobrar implements ActionListener{
    private VentanaEmpleado_2 ventanaCobrar = new VentanaEmpleado_2();
    
    public ControladorCobrar(List<Producto> listaProductos){
        ventanaCobrar.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
       
    }
}
