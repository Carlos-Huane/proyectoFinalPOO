package controller.administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.ProductoDAO;
import javax.swing.JOptionPane;
import view.Admin5_mercancia;

public class ControladorAgregarMercancia implements ActionListener{
    private Admin5_mercancia ventanaMercancia = new Admin5_mercancia();
    
    public ControladorAgregarMercancia(){
        ventanaMercancia.setVisible(true);
        this.ventanaMercancia.btnAgregarMercancia.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ventanaMercancia.btnAgregarMercancia) {
            String codigo = ventanaMercancia.txtCodigo.getText();
            int añadir = Integer.parseInt(ventanaMercancia.txtAñadir.getText());
            
            // Llamar al método para agregar mercancía al producto en la base de datos
            ProductoDAO productoDAO = new ProductoDAO();
            boolean exito = productoDAO.agregarMercancia(codigo, añadir);
            
            if (exito) {
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Mercancia agregada exitosamente");
            } else {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "Error al agregar mercancia");
            }
        }
    }
}
