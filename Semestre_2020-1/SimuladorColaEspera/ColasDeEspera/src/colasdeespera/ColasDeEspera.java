/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasdeespera;
 import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ColasDeEspera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        // TODO code application logic here
        // Muestra ventana de dialogo pidiendo las iteraciones a proceder
        int ciclos = Integer.parseInt( JOptionPane.showInputDialog(null,"Numero de repticiones de la simulacion","SIMULADOR DE COLAS",JOptionPane.PLAIN_MESSAGE));
        VentanaPrincipal vp = new VentanaPrincipal(); // Crea la ventana del banco
        vp.setVisible(true); // La muestra
        vp.simulacion(ciclos); // Empieza la simulacion con los ciclos que se solicitaron 
    }
    
}
