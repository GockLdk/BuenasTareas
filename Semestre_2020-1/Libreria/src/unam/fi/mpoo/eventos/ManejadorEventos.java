package unam.fi.mpoo.eventos;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.aplicacion.Libreria;
import unam.fi.mpoo.controles.Imagen;

import java.awt.*;

// EJERCICIO 3
// LIBRERIA DE CUADROS DE AVISO
import javax.swing.JOptionPane;

public class ManejadorEventos implements ActionListener{

	Libreria lib;
	Administrador admin; // EJERCICIO 2 SE AGREGA UN ADMIN POR DEFECTO EN EL MANEJADOR DE EVENTOS
	public ManejadorEventos(Libreria libreria, Administrador admin){
		this.lib = libreria;
		this.admin = admin;
	}
		
    public void actionPerformed(ActionEvent e){
    		System.out.println("Evento ejecutado por:" + e.getActionCommand());
    		switch (e.getActionCommand()) {
			case Libreria.TEXTO_BOTON_SELEC:
				System.out.println(">>nombre archivo:"+Libreria.TEXTO_BOTON_SELEC);
				System.out.println(">>nombre archivo:"+Libreria.TEXTO_BOTON_SELEC);
				// MOSTRANDO LA LISTA DE TEXTO Y OCULTANDO LA DE AUDIO  "EJERCICIO 2"
				this.lib.getTipoTxtLD().setVisible(true);
				this.lib.getTipoAudioLD().setVisible(false);
				break;
				
			case Libreria.AUDIO_BOTON_SELEC:	
				System.out.println(">>nombre archivo:"+Libreria.AUDIO_BOTON_SELEC);
				// MOSTRANDO LA LISTA DE AUDIO Y OCULTANDO LA DE TEXTO  "EJERCICIO 2"
				this.lib.getTipoTxtLD().setVisible(false);
				this.lib.getTipoAudioLD().setVisible(true);
				break;
			
			// EJERCICIO 2
			// SI LE DAN CLICK A REGISTRAR DEPENDIENDO DEL TIPO TOMA LOS VALORES
			// Y CREA UN ARCHIVO EN LA CARPETA AUDIO O TEXTO
			case Libreria.REGISTRAR_BOTON:
				System.out.println("Registro");
				int tipo = 0;
				String autor = lib.getAutorTxtField().getText();
				String titulo = lib.getTituloTxtField().getText();
				String info = "";
				if(lib.getTipoRegistroTxt().isSelected())
				{
					tipo = 1;
					info = lib.getTipoTxtLD().getSelectedItem().toString();
				}
				else if (lib.getTipoRegistroAudio().isSelected())
				{
					tipo = 2;
					info = lib.getTipoAudioLD().getSelectedItem().toString();
				}

				try{

				admin.insert(autor,titulo,info,tipo);
				JOptionPane.showMessageDialog(null,"Registro Exitoso");
			}catch(IOException io)
			{
				System.out.println("Exception");
				
			}
			break;
			// EJERCICIO 3
			// EVENTO SI SE PRESIONA EL BOTON DE CONSULTA
			case Libreria.CONSULTA_BOTON:
				try
			{
				admin.consulta(); // HACE UNA LISTA DE TODOS LOS LIBROS SEGUN SU TIPO
			}catch(Exception i)
			{
				System.out.println("Exception2");
			}
			// VENTANA DE OPCIONES SUBMENU
			String[] options1 = {"Libros de Texto", "AudioLibros"};
			 int y = JOptionPane.showOptionDialog(null, "Que desea consultar?","Selecciona una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]); 
			 if(y ==0) // OPCIONES DE LOS LIBROS DE TEXTO
			 { //VENTANA DE OPCIONES SUBMENU
			 	String[] options = {"Todos", "Titulo", "Indice", "Cancelar"};
				int x = JOptionPane.showOptionDialog(null, "Consulta de Libros de Texto por: ","Selecciona una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			 	switch(x)
			 	{
			 		case 0:
			 			admin.registroTexto(); // MUESTRA UNA VENTANA DE TODOS LOS LIBROS DE TEXTO
			 		break;
			 		case 1:
			 			String name = JOptionPane.showInputDialog("Titulo del libro a buscar"); // PIDE EL TITULO A BUSCAR
			 			admin.busTituloTXT(name); //MUESTRA EL TITULO
			 		break;
			 		case 2:
			 			int num = Integer.parseInt(JOptionPane.showInputDialog("Indice del libro a buscar\nIndice Max: " + admin.totalTxt)); // PIDE EL INDICE A BUSCAR
			 			admin.busIndTXT(num); // MUESTRA EL INDICE
			 		break;

			 	}
			 }
			 else if(y==1)
			 {
			 	// LO MISMO PERO CON LA LISTA DE LOS AUDIOLIBROS
			 	String[] options = {"Todos", "Titulo", "Indice", "Cancelar"};
				int x = JOptionPane.showOptionDialog(null, "Consulta de AudioLibros por: ","Selecciona una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			 	switch(x)
			 	{
			 		case 0:
			 			admin.registroAudio();
			 		break;
			 		case 1:
			 			String name = JOptionPane.showInputDialog("Titulo del libro a buscar");
			 			admin.busTituloAUD(name);
			 		break;
			 		case 2:
			 			int num = Integer.parseInt(JOptionPane.showInputDialog("Indice del libro a buscar\nIndice Max: " + admin.totalAud));
			 			admin.busIndAUD(num);
			 		break;
			 	}
			 }
			break;

			// EJERCICIO 2
			// SI LE DAN AL BOTON CANCELAR CIERRA LA VENTANA
			case Libreria.CANCELAR_BOTON:
				//System.out.println("Cancelo");
			
				System.exit(0);
				break;

			default:
				System.out.println(">>opción inválida");
				break;
			}    		    		    	
    }

	public Libreria getLibreria() {
		return lib;
	}
	public void setLibreria(Libreria libreria) {
		this.lib = libreria;
	}
}
