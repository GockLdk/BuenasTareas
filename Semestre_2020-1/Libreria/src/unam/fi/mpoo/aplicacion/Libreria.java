package unam.fi.mpoo.aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.WindowConstants;

import unam.fi.mpoo.almacen.Administrador;
import unam.fi.mpoo.controles.*;
import unam.fi.mpoo.eventos.ManejadorEventos;

@SuppressWarnings("serial")
public class Libreria extends JFrame{
    
    private JPanel panelSeccionNorte;
    private JPanel panelSeccionCentro;
    private JPanel panelConsulta;
    private JPanel panelImagen;
    private ManejadorEventos me;
    
    //componentes
    private CajaTexto tituloTxtField;
    private CajaTexto autorTxtField;
    private ListaDesplegable tipoTxtLD;
    private ListaDesplegable tipoAudioLD;
    
    private BotonSeleccion tipoRegistroTxt;
    private BotonSeleccion tipoRegistroAudio;

    private ButtonGroup grupoRadioButton; // EJERCICIO 2 BOTON GROUP
    
    
    public static final String TEXTO_LISTA="textoListaDesplegable";
    public static final String AUDIO_LISTA="audioListaDesplegable";

    public static final String REGISTRAR_BOTON="Registrar";
    public static final String CANCELAR_BOTON="Cancelar";
    public static final String CONSULTA_BOTON="Consulta"; // MENSAJE DEL BOTON DE CONSULTA EJERCICIO 3
    
    public static final String TEXTO_BOTON_SELEC="Texto";
    public static final String AUDIO_BOTON_SELEC="Audio";
    
    public final int ANCHO_VNTNA_PRINCIPAL=300;
    public final int ALTO_VNTNA_PRINCIPAL=400;
  
	public Libreria() {
        	super();
        	Administrador admin =new Administrador();
        	me = new ManejadorEventos(this,admin);
        	
        	super.setTitle("Librería El Buen Lector");
        	super.setPreferredSize(new Dimension(ANCHO_VNTNA_PRINCIPAL,ALTO_VNTNA_PRINCIPAL));

        	this.setLayout (new BorderLayout());
        
        	//seccion norte
        	this.construirPanelSeccionNorte();
        	      	
        	//seccion centro
        	this.construirPanelSeccionCentro();

        	//caracteristicas de la ventana principal
        	super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	    super.pack();
        	super.setLocationRelativeTo(null);
        	super.setResizable(false);
        	super.setVisible(true);
        	super.repaint();

	}


	public void construirPanelSeccionNorte(){		
	 	//creando el panel que contendra los datos a registrar
    	this.panelSeccionNorte = new JPanel();
    	this.panelSeccionNorte.setLayout(new BoxLayout(this.panelSeccionNorte,BoxLayout.Y_AXIS));
	
    	//titulo del panel de datos
    	this.panelSeccionNorte.add(new JLabel("Registro de Publicaciones"));
    
    	//subpanel para titulo
    	JPanel panelTitulo = new JPanel();
    	panelTitulo.setLayout(new BoxLayout(panelTitulo,BoxLayout.X_AXIS));
    	
    	JLabel tituloLbl = new Etiqueta("Titulo:");
    	panelTitulo.add(tituloLbl);
    	this.tituloTxtField = new CajaTexto(20); 
    	panelTitulo.add(this.tituloTxtField);
    	
    	//subpanel para autor
    	JPanel panelAutor = new JPanel();
    	panelAutor.setLayout(new BoxLayout(panelAutor,BoxLayout.X_AXIS));
    	JLabel autorLbl = new Etiqueta("Autor:");
    	panelAutor.add(autorLbl);
    	this.autorTxtField = new CajaTexto(20);    
    	panelAutor.add(autorTxtField);
    	
    	this.panelSeccionNorte.add(panelTitulo);
    	this.panelSeccionNorte.add(panelAutor);
	  	
    	//subpanel para botones de seleccion
    	JPanel panelBotonesSelec = new JPanel();
    	panelBotonesSelec.setLayout(new BoxLayout(panelBotonesSelec,BoxLayout.X_AXIS));
    	this.tipoRegistroTxt = new BotonSeleccion(TEXTO_BOTON_SELEC);
    	this.tipoRegistroTxt.addActionListener(me);

    	this.tipoRegistroAudio = new BotonSeleccion(AUDIO_BOTON_SELEC);
    	this.tipoRegistroAudio.addActionListener(me);
    	
    	// CREANDO GRUPO DE RADIOBUTTON Y AGREGADO AL GRUPO LOS RADIO BUTTON  "EJERCICIO 2"
    	this.grupoRadioButton = new ButtonGroup();
    	this.grupoRadioButton.add(tipoRegistroTxt);
    	this.grupoRadioButton.add(tipoRegistroAudio);

    	panelBotonesSelec.add(this.tipoRegistroTxt);
    	panelBotonesSelec.add(this.tipoRegistroAudio);
    	
    	this.panelSeccionNorte.add(panelBotonesSelec);
    	   	
	  	//subpanel para listas desplegables
	  	JPanel panelListas = new JPanel();
	  	panelListas.setLayout(new BoxLayout(panelListas,BoxLayout.Y_AXIS));
	  	
	  	//lista desplegable texto
	  	String[] opcionesTxt = new String[]{"Revistas","Periódicos","Libros"}; 
	  	this.tipoTxtLD = new ListaDesplegable(opcionesTxt);
	  	tipoTxtLD.addActionListener(me);
	  	tipoTxtLD.setActionCommand(TEXTO_LISTA);
	  	tipoTxtLD.setVisible(false);
	  	
	  	panelListas.add(tipoTxtLD);
	  	
	  //lista desplegable audio
	  	String[] opcionesAudio = new String[]{"LP","Cassette","CD"}; 
	  	this.tipoAudioLD = new ListaDesplegable(opcionesAudio);
	  	this.tipoAudioLD.addActionListener(me);
	  	this.tipoAudioLD.setActionCommand(AUDIO_LISTA);
	  	tipoAudioLD.setVisible(false);
	  	
	  	panelListas.add(tipoAudioLD);
	  	
	  	this.panelSeccionNorte.add(panelListas);
	    	this.add(this.panelSeccionNorte, BorderLayout.NORTH);
	}
	
	public void construirPanelSeccionCentro(){
		this.panelSeccionCentro = new JPanel(new FlowLayout());
		//this.panelSeccionCentro.setBackground(Color.RED);
	  	
    	//subpanel para botones
    	JPanel panelBotones = new JPanel();
    	panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.X_AXIS));
    	Boton registrarBtn = new Boton(REGISTRAR_BOTON,me);
    	Boton cancelarBtn = new Boton(CANCELAR_BOTON, me);
    	Boton consultaBtn = new Boton(CONSULTA_BOTON,me); // EJERCICIO 3 SE CREA EL BOTON DE CONSULTA
    	// EJERCICIO 2 SE ACTIVA EL PANEL CON BOTONES REGISTRAR Y CANCELAR
    	registrarBtn.addActionListener(me);
    	cancelarBtn.addActionListener(me);
    	consultaBtn.addActionListener(me); // EJERCICIO 3 SE AGREGA UN EVENTO AL BOTON
    	
    	panelSeccionCentro.add(registrarBtn);
    	panelSeccionCentro.add(consultaBtn); // EJERCICIO 3 SE AGREGA AL PANEL
    	panelSeccionCentro.add(cancelarBtn);

    	
    	add(panelSeccionCentro, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		//new Administrador(); // EJERCICIO 2 SE BORRA EL ADMIN POR QUE YA ESTA UNO EN LIBRERIA 
	        new Libreria();	
	}


	public JPanel getPanelSeccionNorte() {
		return panelSeccionNorte;
	}


	public void setPanelSeccionNorte(JPanel panelSeccionNorte) {
		this.panelSeccionNorte = panelSeccionNorte;
	}


	public JPanel getPanelSeccionCentro() {
		return panelSeccionCentro;
	}


	public void setPanelSeccionCentro(JPanel panelSeccionCentro) {
		this.panelSeccionCentro = panelSeccionCentro;
	}


	public JPanel getPanelImagen() {
		return panelImagen;
	}


	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}


	public ManejadorEventos getMe() {
		return me;
	}


	public void setMe(ManejadorEventos me) {
		this.me = me;
	}


	public CajaTexto getTituloTxtField() {
		return tituloTxtField;
	}


	public void setTituloTxtField(CajaTexto tituloTxtField) {
		this.tituloTxtField = tituloTxtField;
	}


	public CajaTexto getAutorTxtField() {
		return autorTxtField;
	}


	public void setAutorTxtField(CajaTexto autorTxtField) {
		this.autorTxtField = autorTxtField;
	}


	public ListaDesplegable getTipoTxtLD() {
		return tipoTxtLD;
	}


	public void setTipoTxtLD(ListaDesplegable tipoTxtLD) {
		this.tipoTxtLD = tipoTxtLD;
	}


	public ListaDesplegable getTipoAudioLD() {
		return tipoAudioLD;
	}


	public void setTipoAudioLD(ListaDesplegable tipoAudioLD) {
		this.tipoAudioLD = tipoAudioLD;
	}


	public BotonSeleccion getTipoRegistroTxt() {
		return tipoRegistroTxt;
	}


	public void setTipoRegistroTxt(BotonSeleccion tipoRegistroTxt) {
		this.tipoRegistroTxt = tipoRegistroTxt;
	}


	public BotonSeleccion getTipoRegistroAudio() {
		return tipoRegistroAudio;
	}


	public void setTipoRegistroAudio(BotonSeleccion tipoRegistroAudio) {
		this.tipoRegistroAudio = tipoRegistroAudio;
	}
	
}
