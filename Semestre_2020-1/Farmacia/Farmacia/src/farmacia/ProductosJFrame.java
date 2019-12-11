/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
// vENTANA DE PRODUCTOS
public class ProductosJFrame extends javax.swing.JFrame {

    // LISTA GENERICA DE PRODUCTOS
    public ListaGen productos = new ListaGen();
    
    /**
     * Creates new form ProductosJFrame
     */
    public ProductosJFrame() {
        initComponents();
        this.setLocationRelativeTo(null); // VENTANA CENTRADA
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        consulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clave_field = new javax.swing.JTextField();
        exis_field = new javax.swing.JTextField();
        precio_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        des_field = new javax.swing.JTextArea();
        registro_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Productos");

        consulta.setText("Consulta");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        jLabel2.setText("Clave:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Precio Unitario:");

        jLabel5.setText("Existencia:");

        clave_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clave_fieldActionPerformed(evt);
            }
        });

        des_field.setColumns(20);
        des_field.setRows(5);
        jScrollPane1.setViewportView(des_field);

        registro_btn.setText("Registrar");
        registro_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clave_field))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exis_field))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio_field)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registro_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(consulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clave_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(exis_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(precio_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(registro_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // RECORRE LA LISTA DE PRODUCTOS Y TE NOTIFICA SI EXISTE EL PRODUCTO O NO POR MEDIO DE SU CLAVE
    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        // TODO add your handling code here:
        int claveBus = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese la clave del producto a buscar:","Busqueda",JOptionPane.INFORMATION_MESSAGE));
        boolean encontrado = false;
        for( var producto :  this.productos.list)
        {
            Producto pro = (Producto) producto;
            if(pro.getClave() == claveBus)
            {
                encontrado = true;
                JOptionPane.showMessageDialog(this, "Producto Encontrado: \n" + pro.toString(),"Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(encontrado == false)
            JOptionPane.showMessageDialog(this, "Producto No Existente", "Resultado", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_consultaActionPerformed

    private void clave_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clave_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clave_fieldActionPerformed

    // REGISTRA EL PRODUCTO QUE SE DESEE Y SE AGREGA A LA LISTA DE PRODUCTOS
    private void registro_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro_btnActionPerformed
        // TODO add your handling code here:
        if(this.clave_field.getText().isEmpty() || this.des_field.getText().isEmpty() || this.precio_field.getText().isEmpty() || this.exis_field.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(this, "Falta un espacio por llenar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.productos.agregar(new Producto(Integer.parseInt(this.clave_field.getText()),this.des_field.getText(),Integer.parseInt(this.exis_field.getText()),Double.parseDouble(this.precio_field.getText())));
            JOptionPane.showMessageDialog(this, "Medicamento registrado exitosamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_registro_btnActionPerformed

    // METODO "PRINICPAL" QUE RECIBE LA LISTA DE PRODUCTOS PARA OCUPARLA Y LUEGO DEVOLVERLA ACTUALIZADA
    // MUESTRA LA VENTANA
    public ListaGen frame(ListaGen productos)
    {
        this.productos = productos;
        this.setVisible(true);
        return this.productos;
    }    
    
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
            java.util.logging.Logger.getLogger(ProductosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clave_field;
    private javax.swing.JButton consulta;
    private javax.swing.JTextArea des_field;
    private javax.swing.JTextField exis_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precio_field;
    private javax.swing.JButton registro_btn;
    // End of variables declaration//GEN-END:variables
}
