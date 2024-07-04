package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.Producto;
import dao.ProductoDAO;
import view.Admin1_buscar;

public class ControladorAdmin implements ActionListener {
    private Admin1_buscar ventanaAdmin = new Admin1_buscar(); //instancia para usar los métodos requeridos
    private ProductoDAO productoDAO = new ProductoDAO(); // Instancia para usar su método (obtenerTodosProductos) actualizarTablaProductos definida al final de esta clase

    public ControladorAdmin() {
        ventanaAdmin.setVisible(true);
        this.ventanaAdmin.btnAgregarProducto.addActionListener(this);
        this.ventanaAdmin.btnEliminarProducto.addActionListener(this);
        this.ventanaAdmin.btnModificarProducto.addActionListener(this);
        this.ventanaAdmin.btnAgregarMercancia.addActionListener(this);
        this.ventanaAdmin.btnActualizarTabla.addActionListener(this);
         
        actualizarTablaProductos();// Llama a este método al iniciar para cargar los productos
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == ventanaAdmin.btnActualizarTabla) {
            actualizarTablaProductos();
        }
    }
    
    //este método se define aquí mismo porque no te abre una ventana como los otros botones, 
    //por lo tanto no tiene una clase controlador como los demás.
    private void actualizarTablaProductos() {
        // Obtener lista de productos desde el DAO
        List<Producto> listaProductos = productoDAO.obtenerTodosProductos();

        // Modelo de tabla para la JTable
        DefaultTableModel modeloTabla = (DefaultTableModel) ventanaAdmin.tablaProductos.getModel();
        // Limpiar la tabla existente
        modeloTabla.setRowCount(0);

        // Llenar el modelo con los productos obtenidos
        for (Producto producto : listaProductos) {
            System.out.println(producto.getNombre());
            modeloTabla.addRow(new Object[]{
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecioVenta(),
                producto.getPrecioCompra(),
                producto.getCantidad(),
                producto.getMarca()
            });
        }
    }
}
