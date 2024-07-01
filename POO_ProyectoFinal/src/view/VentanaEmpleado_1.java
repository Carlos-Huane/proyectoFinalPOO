package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleado_1 extends javax.swing.JFrame {
    public JTable tableProductos;
    public DefaultTableModel tableModel;
    
    public VentanaEmpleado_1() {
        initComponents();
        setLocationRelativeTo(null);
        tableProductos = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"Orden", "Código", "Nombre", "Cantidad", "Precio U."}, 0);
        tableProductos.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProductos); // Agregar la tabla a un JScrollPane
        bg1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 620, 240)); // Ajustar posición y tamaño
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        bg1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg1.setBackground(new java.awt.Color(193, 211, 254));
        bg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Roboto", 3, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(10, 10, 10));
        jLabel6.setText("VENTA DE PRODUCTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bg1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 70));

        jLabel4.setBackground(new java.awt.Color(30, 30, 30));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("PRECIO U.");
        bg1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        bg1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 70, 30));

        btnAgregar.setBackground(new java.awt.Color(193, 211, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Images/plus.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        bg1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        jLabel5.setBackground(new java.awt.Color(30, 30, 30));
        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("CÓDIGO DE PRODUCTO");
        bg1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        bg1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, 30));

        jLabel7.setBackground(new java.awt.Color(30, 30, 30));
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("CANTIDAD");
        bg1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel8.setBackground(new java.awt.Color(30, 30, 30));
        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("ORDEN");
        bg1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel9.setBackground(new java.awt.Color(30, 30, 30));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("CÓDIGO");
        bg1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel10.setBackground(new java.awt.Color(30, 30, 30));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("NOMBRE");
        bg1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel11.setBackground(new java.awt.Color(30, 30, 30));
        jLabel11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("CANTIDAD");
        bg1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Images/cancel.png"))); // NOI18N
        bg1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 464, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Images/minus.png"))); // NOI18N
        bg1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        btnCobrar.setBackground(new java.awt.Color(193, 211, 254));
        btnCobrar.setForeground(new java.awt.Color(0, 0, 255));
        btnCobrar.setText("COBRAR");
        btnCobrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        btnCobrar.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        bg1.add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 180, 40));

        jButton4.setBackground(new java.awt.Color(193, 211, 254));
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("      CANCELAR VENTA");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jButton4.setMargin(new java.awt.Insets(2, 30, 3, 14));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        bg1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 40));

        jButton5.setBackground(new java.awt.Color(193, 211, 254));
        jButton5.setForeground(new java.awt.Color(255, 69, 0));
        jButton5.setText("         CANCELAR PRODUCTO");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 69, 0), 2));
        jButton5.setMargin(new java.awt.Insets(2, 30, 3, 14));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        bg1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 180, 40));

        bg.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmpleado_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bg1;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCobrar;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
