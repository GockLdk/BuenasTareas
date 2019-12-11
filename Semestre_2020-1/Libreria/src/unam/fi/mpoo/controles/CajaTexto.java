package unam.fi.mpoo.controles;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class CajaTexto extends JTextField {

	public CajaTexto(String texto) {
		super(texto);
	}
	
	public CajaTexto(int caracteres){
		super(caracteres);
	}
}
