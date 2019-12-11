/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;

/**
 *
 * @author 
 */
// VENTANA MOSTRADOR
public class Mostrador extends javax.swing.JFrame {

    // DOS LISTAS GENERICAS QUE TENDRAN LOS CLIENTES Y PRODUCTOS 
    public ListaGen clientes = new ListaGen();
    public ListaGen productos = new ListaGen();
    
    /**
     * Creates new form Mostrador
     */
    public Mostrador() {
        initComponents();
        this.setLocationRelativeTo(null); // VENTENA EN CENTRO DE LA PANTALLA
        // UN CLIENTE Y PRODUCTO POR DEFECTO
        this.clientes.agregar(new Cliente(1234,"Pancho","Pancho Lopez","Mexico","panchito@gmail.com"));
        this.productos.agregar(new Producto(9876,"Paracetamol",7,19.50));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        clientes_btn = new javax.swing.JButton();
        productos_btn = new javax.swing.JButton();
        ventas_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Titulo.setText("Farmacia");

        clientes_btn.setText("Clientes");
        clientes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_btnActionPerformed(evt);
            }
        });

        productos_btn.setText("Productos");
        productos_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productos_btnActionPerformed(evt);
            }
        });

        ventas_btn.setText("Ventas");
        ventas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventas_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientes_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productos_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes_btn)
                .addGap(18, 18, 18)
                .addComponent(productos_btn)
                .addGap(18, 18, 18)
                .addComponent(ventas_btn)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // MUESTRA LA VENTANA DE CLIENTES Y LE PASA LA LISTA DE CLIENTES PARA LUEGO DEVOLVER LA LISTA ACTUALIZADA
    private void clientes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_btnActionPerformed
        // TODO add your handling code here:
        ClientesJFrame cl = new ClientesJFrame();
        this.clientes = cl.frame(this.clientes);
    }//GEN-LAST:event_clientes_btnActionPerformed

    // MUESTRA LA VENTANA DE PRODUCTOS Y LE PASA LA LISTA DE PRODUCTOS PARA LUEGO DEVOLVER LA LISTA ACTUALIZADA
    private void productos_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productos_btnActionPerformed
        // TODO add your handling code here:
        ProductosJFrame cl = new ProductosJFrame();
        this.productos = cl.frame(this.productos);
    }//GEN-LAST:event_productos_btnActionPerformed

    // MUESTRA LA VENTANA DE VENTAS Y LE PASA AMBAS LISTAS PARA LUEGO DEVOLVERLAS ACTUALIZADAS
    private void ventas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventas_btnActionPerformed
        // TODO add your handling code here:
        VentasJFrame cl = new VentasJFrame();
        cl.frame(this.clientes,this.productos);
    }//GEN-LAST:event_ventas_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Mostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mostrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton clientes_btn;
    private javax.swing.JButton productos_btn;
    private javax.swing.JButton ventas_btn;
    // End of variables declaration//GEN-END:variables
}
