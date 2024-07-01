package controller.empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Producto;
import dao.VendedorDAO;
import view.VentanaEmpleado_1;

public class ControladorVendedor implements ActionListener {
    private VentanaEmpleado_1 ventanaEmpleado_1;
    private List<Producto> listaProductos; // Lista para almacenar los productos agregados
    private VendedorDAO vendedorDAO; // DAO para obtener información del producto

    public ControladorVendedor() {
        ventanaEmpleado_1 = new VentanaEmpleado_1();
        listaProductos = new ArrayList<>();
        vendedorDAO = new VendedorDAO();

        ventanaEmpleado_1.setVisible(true);
        this.ventanaEmpleado_1.btnCobrar.addActionListener(this);
        this.ventanaEmpleado_1.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaEmpleado_1.btnCobrar) {
            // Implementar lógica para cobrar
            new ControladorCobrar(listaProductos);
        }
        if (e.getSource() == ventanaEmpleado_1.btnAgregar) {
            agregarProducto();
        }
    }

    private void agregarProducto() {
    String codigo = ventanaEmpleado_1.txtCodigo.getText();
    String cantidadTexto = ventanaEmpleado_1.txtCantidad.getText();
    
    if (codigo.isEmpty() || cantidadTexto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar código y cantidad del producto.");
        return;
    }

    int cantidad;
    try {
        cantidad = Integer.parseInt(cantidadTexto);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero.");
        return;
    }

    Producto producto = vendedorDAO.obtenerProductoPorCodigo(codigo);
    if (producto != null) {
        // Si el producto ya está en la lista, incrementar su cantidad
        boolean encontrado = false;
        for (Producto p : listaProductos) {
            
            if (p.getCodigo().equals(producto.getCodigo())) {
                p.setCantidad(p.getCantidad() + cantidad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            // Si el producto no está en la lista, agregarlo con la cantidad especificada
            producto.setCantidad(cantidad);
            listaProductos.add(producto);
        }
        actualizarTabla(); // Actualizar la tabla después de modificar la lista de productos
    } else {
        JOptionPane.showMessageDialog(null, "Producto no encontrado en la base de datos.");
    }
    }

    private void actualizarTabla() {
        ventanaEmpleado_1.tableModel.setRowCount(0); // Limpiar la tabla antes de volver a agregar filas
        int orden = 1;
        System.out.println(listaProductos.size());
        for (Producto producto : listaProductos) {
            //System.out.println(producto.getNombre());
            System.out.println("debugeando -->"+producto.getPrecioVenta());
            if(producto.getPrecioVenta() < 0){
                continue;
            }
            ventanaEmpleado_1.tableModel.addRow(new Object[]{
                orden++, 
                producto.getCodigo(), 
                producto.getNombre(), 
                producto.getCantidad(), 
                producto.getPrecioVenta() // Asegúrate de que este método sea correcto
            });
            
        }
    }

}
