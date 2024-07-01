package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.ProductoDAO;
import javax.swing.JOptionPane;
import view.Admin4_eliminar;

public class ControladorEliminarProducto implements ActionListener{
    private Admin4_eliminar ventanaEliminar = new Admin4_eliminar();
    
    public ControladorEliminarProducto(){
        ventanaEliminar.setVisible(true);
        this.ventanaEliminar.btnEliminar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ventanaEliminar.btnEliminar) {
            String codigo = ventanaEliminar.txtCodigo.getText();
            
            // Llamar al método para eliminar el producto en la base de datos
            ProductoDAO productoDAO = new ProductoDAO();
            boolean exito = productoDAO.eliminarProducto(codigo);
            
            if (exito) {
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                
            } else {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto.");
            }
        }
    }
}
