// Clase para registro de alumnos

// Paquetes a usar 
import java.util.Scanner; // Lectura de datos
// Listas
import java.util.ArrayList; 
import java.util.List;

public class Registro
{
	// Atributos de la clase registro
	public List<Alumno> listaAlumnos; // Lista de alumnos donde se guardaran
	public Scanner sc; // Scanner para la lectura de datos

	// Constructor de la clase registro
	public Registro()
	{
		this.listaAlumnos = new ArrayList<Alumno>();
		this.sc = new Scanner(System.in);
	}

	// Metodo para limpiar la pantalla (Puramente Estetica)
	public static void limpiarPantalla()
	{
		// Limpiar pantalla
		System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}

	// Imprime todo los datos de la lista
	public void imprimirLista()
	{
		System.out.println("[------------- Lista de Alumnos -------------]");
		// Recorre toda la lista
		for (Alumno alumno : this.listaAlumnos) 
			System.out.println(alumno.toString());	// Imprime los datos del alumno donde se ubica
		
	}

	// Registro de Alumnos en la lista
	public void registrarAlumno()
	{
		System.out.println("--> Registrar Alumno \nFavor de porpocionar los datos solicitados del alumno");
		// Se solicita todos los datos del alumno
		System.out.print("Matricula: ");
		int matricula = this.sc.nextInt();
		System.out.print("Nombre: ");
		this.sc.nextLine(); // Atrapa el enter del anterior (No quitar)
		String nombre = this.sc.nextLine();
		System.out.print("Carrera: ");
		String carrera = this.sc.nextLine();
		System.out.print("Turno: ");
		String turno = this.sc.nextLine();
		System.out.print("Edad: ");
		int edad = this.sc.nextInt();
		System.out.print("Id: ");
		int id = this.sc.nextInt();

		// Crea un alumno con los datos proporcionados para luego agregarlo a la lista de alumos
		this.listaAlumnos.add(new Alumno(matricula,nombre,carrera,turno,edad,id));


		this.limpiarPantalla();
		System.out.println(">>>>>>>>>>>>> REGISTRO EXITOSO <<<<<<<<<<<<<<");
	}

	// Metodo para buscar alumno mediante la matricula
	// En caso de encontrarlo devuelve la posicion de donde se ubica
	// devueleve -1 en caso de no encontralo
	public int buscarAlumno()
	{
		System.out.print("--> Buscar Alumno \nFavor de porpocionar el numero de matricula del alumno a buscar\nMatricula: ");	
		int matriculaBus = this.sc.nextInt();
		int posicion = 0;
		// Recorre toda la lista
		for (Alumno alumno : this.listaAlumnos )
		{
			if(alumno.getMatricula() == matriculaBus) // y si en la posicion donde esta la matriculas coinciden
			{
				return posicion; // Regresa la posicion donde esta
			}
			posicion++; // en caso de que no solo aumenta la posicion
		}
	
		return -1; // si despues de recorrer la lista no devolvio nada, devuelve -1
	}

	// Metodo para editar alumno (recibe la posicion de la lista del alumno a modificar)
	public void editarAlumno(int pos)
	{
		// Imprime los datos antes de la modificacion
		System.out.println("--> Editar Alumno\n\nDatos Originales: " + this.listaAlumnos.get(pos).toString());
		//Solicita los datos
		System.out.println("\nFavor de porpocionar los datos solicitados del alumno");
		System.out.print("Matricula: ");
		int matricula = this.sc.nextInt();
		System.out.print("Nombre: ");
		this.sc.nextLine();
		String nombre = this.sc.nextLine();
		System.out.print("Carrera: ");
		String carrera = this.sc.nextLine();
		System.out.print("Turno: ");
		String turno = this.sc.nextLine();
		System.out.print("Edad: ");
		int edad = this.sc.nextInt();
		System.out.print("Id: ");
		int id = this.sc.nextInt();

		// Modifica el alumno en la posicion que se recibio
		this.listaAlumnos.set(pos,new Alumno(matricula,nombre,carrera,turno,edad,id));

		this.limpiarPantalla();
	}

	// Main Principal
	public static void main(String[] args) 
	{
		// Se crea el registro y se agregan dos alumnos por defecto
		Registro registro = new Registro();
		Alumno pedro = new Alumno(123456789,"Pedro Picapiedra","Ing. Civil","Matutino",38,1234);
		Alumno pablo = new Alumno(987654321,"Pablo Marmol","Ing. Civil","Matutino",36,5678);
		registro.listaAlumnos.add(pedro);
		registro.listaAlumnos.add(pablo);

		boolean salir = false; // variable que define cuando salir del programa
		int opc = 0; // variable que define que define que va a hacer el programa

		Registro.limpiarPantalla();

		while(salir ==false) // mientras no se quiera salir
		{
			// imprime menu y guarda la opcion deseada
			System.out.println("\n******Registro de Alumnos******\nIngrese el numero de su opcion deseada");
			System.out.print("1.- Registrar\n2.- Buscar\n3.- Editar\n4.- Imprimir lista de Alumnos\n5.- Salir\nOpc: ");
			opc = registro.sc.nextInt();

			// Se compara que opcion se eligio
			switch(opc)
			{
				// Si fue la 1, entonces se hace un registro
				case 1:
					Registro.limpiarPantalla();  
					registro.registrarAlumno();
				break;

				// Si fue la 2, entonces se hace una buqueda
				case 2:
					Registro.limpiarPantalla();  
					int res = registro.buscarAlumno();
					if(res== -1) // Si se recibio un -1 Se notifica que no se encontro el alumno
					{
						Registro.limpiarPantalla();
						System.out.println("-------------> ALUMNO NO ENCONTRADO <-------------\n\n");
					}
					else // En caso contrario se notifica e imprime la info del alumno
					{
						System.out.println("-------------> ALUMNO ENCONTRADO <-------------");
						System.out.println(registro.listaAlumnos.get(res).toString());
					}
				break;

				// Si fue 3 , entonces se reutiliza la busqueda para saber si el alumno a editar existe
				case 3:
					Registro.limpiarPantalla();  
					int resu = registro.buscarAlumno();
					if(resu== -1) // en caso de que no, se notifica
					{
						Registro.limpiarPantalla();
						System.out.println("-------------> ALUMNO NO ENCONTRADO <-------------\n\n");
					}
					else // en caso de que exista
					{
						Registro.limpiarPantalla();
						System.out.println("-------------> ALUMNO ENCONTRADO <-------------");
						registro.editarAlumno(resu); // Manda a editar los datos del alumno
						System.out.println("-------------> EDICION EXITOSA <-------------");
					}
				break;

				// Si fue un 4 , entonces se imprime toda la lista de alumnos
				case 4:
					Registro.limpiarPantalla(); 
					registro.imprimirLista();
				break;

				// si fue un 5, se marca la variable como true para salir del ciclo
				case 5:
					Registro.limpiarPantalla();
					salir = !salir;
					System.out.println("\n\n-------------> Hasta Luego :) <-------------\n\n");
				break;

				// Notifica si no ingreso un numero no valido
				default:
					Registro.limpiarPantalla();
					System.out.println("\n\n-------------> OPCION INVALIDA <-------------\n\n");
				break;


			}
		} 
	}
}