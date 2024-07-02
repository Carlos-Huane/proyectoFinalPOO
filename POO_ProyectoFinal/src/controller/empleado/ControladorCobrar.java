package controller.empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

import model.Producto;
import dao.VendedorDAO;
import view.VentanaEmpleado_2;

public class ControladorCobrar implements ActionListener {
    private VentanaEmpleado_2 ventanaCobrar;
    private List<Producto> listaProductos; // Lista de productos a cobrar
    private VendedorDAO vendedorDAO; // DAO para actualizar la cantidad de productos

    public ControladorCobrar(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        this.vendedorDAO = new VendedorDAO();

        ventanaCobrar = new VentanaEmpleado_2();
        ventanaCobrar.setVisible(true);
        this.ventanaCobrar.btnCobrar.addActionListener(this);
        this.ventanaCobrar.btnCancelar.addActionListener(this);
                
        // Calcular cantidad total de productos y precio total
        int cantidadTotal = totalCantidadProductos(listaProductos);
        float precioTotal = totalPrecioProductos(listaProductos);

        // Mostrar los valores en los campos de texto
        ventanaCobrar.txtCantidad.setText(String.valueOf(cantidadTotal));
        ventanaCobrar.txtTotal.setText(String.format("%.2f", precioTotal));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaCobrar.btnCobrar) {
            cobrarProductos();
        }
        if (e.getSource() == ventanaCobrar.btnCancelar) {
            ventanaCobrar.setVisible(false);
        }
    }

    // Método para calcular la cantidad total de productos
    public int totalCantidadProductos(List<Producto> listaProductos) {
        int cantidadTotal = 0;
        for (Producto producto : listaProductos) {
            cantidadTotal += producto.getCantidad();
        }
        return cantidadTotal;
    }

    // Método para calcular el precio total de los productos
    public float totalPrecioProductos(List<Producto> listaProductos) {
        float precioTotal = 0;
        for (Producto producto : listaProductos) {
            precioTotal += producto.getCantidad() * producto.getPrecioVenta();
        }
        return precioTotal;
    }

    // Método para manejar la lógica de cobro
    private void cobrarProductos() {
    boolean exito = true;

    for (Producto producto : listaProductos) {
        // Obtener el producto actual de la base de datos para obtener la cantidad disponible
        Producto productoActualEnBD = vendedorDAO.obtenerProductoPorCodigo(producto.getCodigo());

        if (productoActualEnBD == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en la base de datos: " + producto.getNombre());
            exito = false;
            break;
        }

        // Restar la cantidad comprada de la cantidad disponible en stock
        int nuevaCantidad = productoActualEnBD.getCantidad() - producto.getCantidad();

        if (nuevaCantidad < 0) {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock para el producto: " + producto.getNombre());
            exito = false;
            break;
        }

        // Actualizar la cantidad en la base de datos
        boolean resultado = vendedorDAO.actualizarCantidadProducto(producto.getCodigo(), nuevaCantidad);

        if (!resultado) {
            exito = false;
            break;
        }
    }

    if (exito) {
        JOptionPane.showMessageDialog(null, "Productos cobrados exitosamente.");
        listaProductos.clear(); // Limpiar la lista de productos después del cobro
        ventanaCobrar.setVisible(false);
    } else {
        JOptionPane.showMessageDialog(null, "Error al cobrar los productos. Verifique los datos e intente nuevamente.");
    }
    }

}
