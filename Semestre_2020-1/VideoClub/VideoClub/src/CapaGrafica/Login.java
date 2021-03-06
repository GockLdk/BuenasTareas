/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaGrafica;

import CapaDatos.RegistroClientes;
import CapaLogica.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
// Login
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
        initComponents();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        bienvenidoLabel = new javax.swing.JLabel();
        usuarioPanel = new javax.swing.JPanel();
        usuarioLabel = new javax.swing.JLabel();
        contrasenaPanel = new javax.swing.JPanel();
        contrasenaLabel = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        contrasenaField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        fondoPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VideoClub");
        setAlwaysOnTop(true);
        setResizable(false);

        panelPrincipal.setLayout(null);

        bienvenidoLabel.setForeground(new java.awt.Color(255, 255, 255));
        bienvenidoLabel.setText("Bienvenido");
        panelPrincipal.add(bienvenidoLabel);
        bienvenidoLabel.setBounds(220, 10, 70, 14);

        usuarioPanel.setBackground(new java.awt.Color(0, 0, 0));
        usuarioPanel.setLayout(null);

        usuarioLabel.setBackground(new java.awt.Color(0, 0, 0));
        usuarioLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioLabel.setText("Usuario :");
        usuarioPanel.add(usuarioLabel);
        usuarioLabel.setBounds(10, 0, 50, 20);

        panelPrincipal.add(usuarioPanel);
        usuarioPanel.setBounds(10, 130, 60, 20);

        contrasenaPanel.setBackground(new java.awt.Color(0, 0, 0));
        contrasenaPanel.setLayout(null);

        contrasenaLabel.setBackground(new java.awt.Color(0, 0, 0));
        contrasenaLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        contrasenaLabel.setForeground(new java.awt.Color(255, 255, 255));
        contrasenaLabel.setText("Contraseña :");
        contrasenaPanel.add(contrasenaLabel);
        contrasenaLabel.setBounds(0, 0, 70, 20);

        panelPrincipal.add(contrasenaPanel);
        contrasenaPanel.setBounds(10, 160, 70, 20);

        usuarioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioFieldActionPerformed(evt);
            }
        });
        panelPrincipal.add(usuarioField);
        usuarioField.setBounds(90, 130, 90, 20);

        contrasenaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaFieldActionPerformed(evt);
            }
        });
        panelPrincipal.add(contrasenaField);
        contrasenaField.setBounds(90, 160, 90, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton1);
        jButton1.setBounds(190, 150, 90, 19);

        fondoPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaGrafica/img/Videoclub.jpg"))); // NOI18N
        panelPrincipal.add(fondoPanel);
        fondoPanel.setBounds(0, 0, 300, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // CUANDO SE DA EL BOTON INGRESAR
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS
        if( this.usuarioField.getText().isEmpty() || this.contrasenaField.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Falta de llenar algun espacio","Faltan Datos",JOptionPane.INFORMATION_MESSAGE);
        else
        { // SI NO LO ESTAN
        String user = this.usuarioField.getText();
        int pass = Integer.parseInt(this.contrasenaField.getText());
        
        /*System.out.println(user);
        System.out.println(pass);*/
        
            try { // BUSCAN AL USUARIO
                Usuario usuario = RegistroClientes.busqueda(user);
                if(usuario == null)
                    JOptionPane.showMessageDialog(null, "Usuario Inexistente","Usuario no Encontrado",JOptionPane.INFORMATION_MESSAGE);
                else // SI LO ENCUENTRAN
                {
                    // VERIFICA TANTO CONTRASENA COMO TIPO DE USUARIO
                    if(usuario.getContrasena() == pass)
                    {
                        switch(usuario.getTipoUsuario())
                        {
                            // DEPENDIENDO DEL USUARIO INICIA EL FORM CORRESPONDIENTE
                            // ADMIN = ADMINFORM , DEMAS = CLIENTEFORM
                            case 1:
                                AdminForm f = null;
                                 try 
                                 {
                                    f = new AdminForm();
                                 } catch (IOException ex) {
                                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                 } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                f.setVisible(true);
                                this.contrasenaField.setText("");
                                this.usuarioField.setText("");
                            break;
                            
                            case 2:
                                 ClienteForm c = new ClienteForm(usuario);
                                 c.setVisible(true);
                                this.contrasenaField.setText("");
                                this.usuarioField.setText("");
                            break;
                            
                            case 3:
                                ClienteForm d = new ClienteForm(usuario);
                                d.setVisible(true);
                                this.contrasenaField.setText("");
                                this.usuarioField.setText("");
                            break;
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Contrasena Incorrecta","Datos Invalidos",JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuarioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioFieldActionPerformed

    private void contrasenaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenidoLabel;
    private javax.swing.JTextField contrasenaField;
    private javax.swing.JLabel contrasenaLabel;
    private javax.swing.JPanel contrasenaPanel;
    private javax.swing.JLabel fondoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField usuarioField;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JPanel usuarioPanel;
    // End of variables declaration//GEN-END:variables

}
