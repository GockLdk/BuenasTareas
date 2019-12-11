package unam.fi.mpoo.almacen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

// EJERCICIO 2
// BIBLIOTECAS QUE SE USAN PARA CREAR ARCHIVOS SERIALIZABLES
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import unam.fi.mpoo.almacen.datos.Registro;
import unam.fi.mpoo.almacen.datos.tipos.Audio;
import unam.fi.mpoo.almacen.datos.tipos.Texto;

public class Administrador {
	
	public final static String RUTA_ARCHIVO_1="./almacen/Texto/";
	public final static String RUTA_ARCHIVO_2="./almacen/Audio/";
	public final static String RUTA_IMAGENES_2="./imagenes/";
	public final static String NOMBRE_ARCHIVO="Almacen.txt";
	private final static String SEPARADOR_INFORMACION=":";
	File almacen;

	public ArrayList<Texto> list = new ArrayList<>();
	public ArrayList<Audio> list2 = new ArrayList<>();

	public int totalTxt = 0;
	public int totalAud = 0;
	
	public Administrador() {
		this.almacen= generarClaseFile(1, NOMBRE_ARCHIVO);	
	}
	

	//ToDo cambiar el método para que almacene en dos archivos diferentes de acuerdo al tipo de Registro
	public void registraInformacion(Registro r) {
		try {
			BufferedWriter bw= new BufferedWriter(new FileWriter(almacen,true));
			bw.write(r.convertirATexto());
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ToDo cambiar el método para que solicite la información de acuerdo al tipo de archivo
	public String mostrarInformacion(int indice){		
		String data="";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(almacen));
			while( (data=br.readLine())!=null){
				StringTokenizer dataToken = new StringTokenizer(data, SEPARADOR_INFORMACION);
				if(dataToken.hasMoreTokens()){
					String token = dataToken.nextToken();
					if(token.equals(""+indice))
						break;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static File generarClaseFile(int opcion, String f){
		String rutaCompleta="";
		switch (opcion) {
		case 1:
			rutaCompleta=RUTA_ARCHIVO_1+f;
			break;
		case 2:
			rutaCompleta=RUTA_IMAGENES_2+f;
			break;
		default:
			break;
		}
		System.out.println("rutaCompleta:"+rutaCompleta);
		return new File(rutaCompleta);
	}

	// EJERCICIO 2
	// FUNCION QUE DEPENDIENDO DEL TIPO HACE UN ARCHIVO CON LOS DATOS DEL REGISTRO
	// EN LA CARPETA TEXT (1) O AUDIO (2) SEGUN SU TIPO
	public void insert(String autor, String titulo, String info, int tipo) throws IOException {
        
        try {
        	if(tipo ==1)
        	{
            	Texto txt = new Texto(autor,titulo,info);
            	ObjectOutput out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_1 + titulo + ".ser"));
          		out.writeObject(txt);
            	out.close();
        	}
            else if (tipo ==2)
            {
            	Audio aud = new Audio(autor,titulo,info);
            	ObjectOutput out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_2 + titulo + ".ser"));
            	out.writeObject(aud);
            	out.close();
            }

            
        }
        catch(FileNotFoundException e){
        	if(tipo==1)
        	{
            	File f = new File(RUTA_ARCHIVO_1);
            	f.mkdir();
            
            	Texto txt = new Texto(autor,titulo,info);
            	ObjectOutput out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_1 + titulo + ".ser"));
            	out.writeObject(txt);
            	out.close();
            }
            else if(tipo ==2)
            {
            	File f = new File(RUTA_ARCHIVO_2);
            	f.mkdir();
            
            	Audio aud = new Audio(autor,titulo,info);
            	ObjectOutput out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_1 + titulo + ".ser"));
            	out.writeObject(aud);
            	out.close();
            }
        }
    }

    // EJERCICIO 3
    // FUNCION QUE CREA LA LISTA DE TODOS LOS REGISTROS DE LIBROS DE TEXTO Y AUDIOLIBROS
    public void consulta() throws Exception {
        File f = new File(RUTA_ARCHIVO_1);

        String archivos[] = f.list();
        ArrayList<Texto> libros = new ArrayList<>();
        for (String archivo : archivos) {
            ObjectInput in = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO_1 + archivo));
            Texto txt = (Texto) in.readObject();
            libros.add(txt);
            in.close();
        }
        this.list = new ArrayList<>(libros);
        this.totalTxt = this.list.size() -1;

        File f1 = new File(RUTA_ARCHIVO_2);

        String archivos1[] = f1.list();
        ArrayList<Audio> audiolibros = new ArrayList<>();
        for (String archivo : archivos1) {
            ObjectInput in = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO_2 + archivo));
            Audio aud = (Audio) in.readObject();
            audiolibros.add(aud);
            in.close();
        }
        this.list2 = new ArrayList<>(audiolibros);
        this.totalAud = this.list2.size()-1;
    }
 	// EJERCICIO 3
 	// MUESTRA UNA VENTANA CON LA INFORMACION DE LA LISTA DE TEXTO
    public void registroTexto()
    {
    	String lista = "";
    	for (Texto tex : this.list ) 
    	{
    		lista +=  "-------------------------------------------------\n" + tex.toString() + "\n";	
    	}

    	JOptionPane.showMessageDialog(null, lista);

    }

    // EJERCICIO 3
 	// MUESTRA UNA VENTANA CON LA INFORMACION DE LA LISTA DE AUDIO
    public void registroAudio()
    {

    	String lista = "";
    	for (Audio aud : this.list2 ) 
    	{
    		lista +=  "-------------------------------------------------\n" + aud.toString() + "\n";	
    	}

    	JOptionPane.showMessageDialog(null, lista);
    }

    // EJERCICIO 3
    // BUSCA POR TITULO EL LIBRO DE TEXTO
    // SI LO ENCUENTRA MUESTRA LA INFO
    // SI NO LO NOTIFICA
    public void busTituloTXT(String titu)
    {
    	boolean encontrado = false;
    	for (Texto tex : this.list ) {
    		if(tex.getTitulo().equals(titu))
    		{
    			JOptionPane.showMessageDialog(null, tex.toString() );
    			encontrado = true;
    		}
    	}
    	if(encontrado == false)
    		JOptionPane.showMessageDialog(null, "No hay registro del libro " + titu );

    }

    // EJERCICIO 3
    // BUSCA POR TITULO EL LIBRO DE AUDIO
    // SI LO ENCUENTRA MUESTRA LA INFO
    // SI NO LO NOTIFICA
    public void busTituloAUD(String titu)
    {
    	boolean encontrado = false;
    	for (Audio tex : this.list2 ) {
    		if(tex.getTitulo().equals(titu))
    		{
    			JOptionPane.showMessageDialog(null, tex.toString() );
    			encontrado = true;
    		}
    	}
    	if(encontrado == false)
    		JOptionPane.showMessageDialog(null, "No hay registro del libro " + titu );

    }

	// EJERCICIO 3
    // BUSCA POR INDICE EL LIBRO DE TEXTO
    // SI LO ENCUENTRA MUESTRA LA INFO (SI EL INDICE ESTA DENTRO DEL RANGO DE LA LISTA)
    // SI NO LO NOTIFICA    
    public void busIndTXT(int ind)
    {
    	if(ind>=0 && ind <= this.totalTxt)
    		JOptionPane.showMessageDialog(null, this.list.get(ind).toString());
    	else
    		JOptionPane.showMessageDialog(null, "No hay registro del libro\nIndice erroneo" );

    }

    // EJERCICIO 3
    // BUSCA POR INDICE EL LIBRO DE AUDIO
    // SI LO ENCUENTRA MUESTRA LA INFO (SI EL INDICE ESTA DENTRO DEL RANGO DE LA LISTA)
    // SI NO LO NOTIFICA
    public void busIndAUD(int ind)
    {
    	if(ind>=0 && ind <= this.totalAud)
    		JOptionPane.showMessageDialog(null, this.list2.get(ind).toString());
    	else
    		JOptionPane.showMessageDialog(null, "No hay registro del libro\nIndice erroneo" );

    }
}
