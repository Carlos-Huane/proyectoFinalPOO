package controller.administrador;

import dao.ProductoDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Producto;

import javax.swing.JOptionPane;

import view.Admin3_modificar;
public class ControladorModificarProducto implements ActionListener{
    private Admin3_modificar ventanaModificar = new Admin3_modificar();
    
    public ControladorModificarProducto(){
        ventanaModificar.setVisible(true);
        this.ventanaModificar.btnModificarProducto.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == ventanaModificar.btnModificarProducto) {
         String codigo = ventanaModificar.txtCodigo.getText();
         String nombre = ventanaModificar.txtNombre.getText();
         float precioVenta = Float.parseFloat(ventanaModificar.txtPrecioVenta.getText());
         float precioCompra = Float.parseFloat(ventanaModificar.txtPrecioCompra.getText());
         int cantidad = Integer.parseInt(ventanaModificar.txtCantidad.getText());
         String marca = ventanaModificar.txtMarca.getText();

         // Crear un objeto Producto con los datos ingresados
         Producto producto = new Producto(codigo, nombre, precioVenta, precioCompra, cantidad, marca);

         // Llamar al método para modificar el producto en la base de datos
         ProductoDAO productoDAO = new ProductoDAO();
         boolean exito = productoDAO.modificarProducto(producto);

         if (exito) {
             // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
         } else {
             // Mostrar mensaje de error
             JOptionPane.showMessageDialog(null, "Error al modificar el producto.");
         }
     }
    }
}
