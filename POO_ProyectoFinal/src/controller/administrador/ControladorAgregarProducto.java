package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import view.Admin2_agregar;
import dao.ProductoDAO;
import model.Producto;

public class ControladorAgregarProducto implements ActionListener {
    private Admin2_agregar ventanaAgregar = new Admin2_agregar();
    
    public ControladorAgregarProducto() {
        ventanaAgregar.setVisible(true);
        this.ventanaAgregar.btnAgregarProducto.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaAgregar.btnAgregarProducto) { //si se presiona el boton, se realiza el guardado de los datos ingresados en los campos de texto
            
            // a continuación se guardarán las variables previac conversión a String
            String codigo = ventanaAgregar.txtCodigo.getText(); 
            String nombre = ventanaAgregar.txtNombre.getText(); 
            float precioVenta = Float.parseFloat(ventanaAgregar.txtPrecioVenta.getText()); 
            float precioCompra = Float.parseFloat(ventanaAgregar.txtPrecioCompra.getText()); 
            int cantidad = Integer.parseInt(ventanaAgregar.txtCantidad.getText()); 
            String marca = ventanaAgregar.txtMarca.getText(); 
            
            // Crear un objeto Producto con los datos ingresados
            Producto producto = new Producto(codigo, nombre, precioVenta, precioCompra, cantidad, marca);
            
            // Instanciar el ProductoDAO y agregar el producto a la base de datos
            ProductoDAO productoDAO = new ProductoDAO();
            boolean exito = productoDAO.agregarProducto(producto);
            
            if (exito) {
                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
                ventanaAgregar.dispose(); // Cerrar la ventana después de agregar
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar el producto");
            }
        }
    }
}
