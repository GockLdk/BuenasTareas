// Importando Paquetes
import java.util.Random; // Numero Aleatorios
import java.util.Scanner; // Scanner

public class Tablero
{
	// Atributos
	public Casilla tablero [][]; // Tablero de conejos
	public int intentos; // Numero de intentos
	public int totalConejos; // Contador de conejos totales no encontrados

	// Constructor que inicializa el tablero con 4 conejos aleatorios
	public Tablero()
	{
		this.tablero = new Casilla [5][5];
		this.intentos = 6;
		this.totalConejos = 0;
		this.inicializarTablero();

	}

	// Se crea en cada casilla del tablero un objeto de tipo Casilla
	// Donde se marca en cada una que no hay conejos y no han sido revisadas
	// Para finalmente llamar a insertaConejos()
	public void inicializarTablero()
	{
		for (int i = 0;i<5;i++) 
		{
			for (int j =0;j<5;j++) 
			{
				this.tablero[i][j] = new Casilla();				
			}
		}
		this.insertarConejos();
	}

	// Recorre todo el tablero y dependiendo si hay conejos o no y si ya se reviso o no en cada casilla
	// imprime un simbolo diferente para cada caso
	// Ademas de imprimir el numero de intentos y conejos que faltan para encontrar
	public void imprimirTablero()
	{
		System.out.println("Numero de Intentos: " + this.intentos);
		System.out.println("Conejos Restantes: " + this.totalConejos);
		System.out.println(" ? -> Casilla no revisada\n * -> Casilla revisada sin Conejo encontrado\n X -> Casilla revisada con Conejo encontrado");
		System.out.println("------------------------------");
		System.out.println("| / || 1 || 2 || 3 || 4 || 5 |");
		for (int i = 0;i<5;i++) 
		{
			System.out.println("------------------------------");
			System.out.print("| " + (i+1) + " |");
			for (int j =0;j<5;j++) 
			{
				if( this.tablero[i][j].getConejo() == false && this.tablero[i][j].getRevisado() == 0 )
					System.out.print("| ? |");				
				else if (this.tablero[i][j].getConejo() == false && this.tablero[i][j].getRevisado() == 1 )
					System.out.print("| * |");	
				else if (this.tablero[i][j].getConejo() == true && this.tablero[i][j].getRevisado() == 0 )
					System.out.print("| ? |");
				else if (this.tablero[i][j].getConejo() == true && this.tablero[i][j].getRevisado() == 1 )
					System.out.print("| X |");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

	// Recorre todo el tablero y segun haya conejos o no te imprime algo diferente
	// En resumen te imprime la posicion de cada conejo en el tablero
	public void respuestaTablero()
	{	
		System.out.println("***JUEGO FINALIZADO***\nCONEJOS EN EL TABLERO");
		System.out.println("------------------------------");
		System.out.println("| / || 1 || 2 || 3 || 4 || 5 |");
		for (int i = 0;i<5;i++) 
		{
			System.out.println("------------------------------");
			System.out.print("| " + (i+1) + " |");
			for (int j =0;j<5;j++) 
			{
				if( this.tablero[i][j].getConejo() == false )
					System.out.print("| ? |");
				else
					System.out.print("| X |");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		System.out.println("Conejos Encontrados " + (4 - this.totalConejos) + " de 4");
	}

	// Saca dos numeros aleatorios del 0 al 4 los cuales indicaran una posicion en el tablero
	// y en esa posicion insertara un conejo si es que no hay
	// Y en caso de haber saca otros dos numeros aleatorios para insertar el conejo en otro lado
	// Finalmente llama a conejosTotales()
	public void insertarConejos()
	{
		Random r = new Random();
		for (int i = 0;i<4;i++) 
		{
			int ren = r.nextInt(5);
			int col = r.nextInt(5);
			if(this.tablero[ren][col].getConejo() == false) // Si no hay conejo
			{
				this.tablero[ren][col].setConejo(true); // Lo inserta
			}
			else // si no
			{
				this.tablero[r.nextInt(5)][r.nextInt(5)].setConejo(true); // Inserta conejo en otra posicion
			}
		}
		this.conejosTotales();
	}

	// Recorre el tablero cuenta la cantidad de conejos en el tablero
	// Sirve para verificar si no hubo un problema a la hora de insertarlos
	public void conejosTotales()
	{
		for (int i = 0;i<5;i++) 
		{
			for (int j =0;j<5;j++) 
			{
				if( this.tablero[i][j].getConejo() == true )
					this.totalConejos+=1;
			}
		}
	} 

	// Metodo principal donde se ocupa todos los metodos
	// Mientras tenga intentos o no encuentre todos los conejos,
	// se imprimira el tablero con las informacion del estado actual del jugador
	// se le pedira el renglon y columna de la casilla donde se revisara
	// y si los numero son validos, checara si hay conejo o no, te lo indicara,
	// marca como revisado y si se encontro un conejo se decrementa uno totalConejos
	// y si no habia conejo decrementa uno el numero de intentos
	public int juego()
	{
		Scanner sc = new Scanner(System.in);
		while(this.intentos != 0 && this.totalConejos != 0) // Mientras tengas intentos y no hayas encontrado todos los conejos
		{
			this.imprimirTablero();
			//this.respuestaTablero(); // Para verficar que se puede ganar descomentar esta linea y comentar la de arriba
			System.out.println("En que casilla esta el conejo?");
			System.out.print("Renglon: ");
			int ren = sc.nextInt();
			while(ren < 1 || ren > 5) // Si el numero del renglon no es valido
			{
				// se repetira hasta que ingrese uno valido
				System.out.println("Favor de poner un numero de renglon valido (1-5)");
				System.out.print("Renglon: ");
				ren = sc.nextInt();
			}
			System.out.print("Columna: ");
			int col = sc.nextInt();	
			while(col < 1 || col > 5) // si el numero de la columna no es valido
			{
				// se repetira hasta que se ingrese uno valido
				System.out.println("Favor de poner un numero de columna valido (1-5)");
				System.out.print("Columna: ");
				col = sc.nextInt();
			}
			// Simula limpiar pantalla en la consola (En caso de no funcionar, quite las lineas)
			System.out.print("\033[H\033[2J");
			System.out.flush();
			// Simula limpiar pantalla en la consola
			if(this.tablero[ren-1][col-1].getConejo() == true) // Si hay conejo en la casilla seleccionada
			{
				if (this.tablero[ren-1][col-1].getRevisado() == 1) // y si esta revisada
				{
					System.out.println("****CONEJO YA ENCONTRADO****"); // Se te notifica que el conejo ya se encontro
				}
				else // si no esta revisado
				{
					this.tablero[ren-1][col-1].setRevisado(1); // se checa como revisado
					this.totalConejos-=1; // decrementa uno el total de conejos no encontrados
					System.out.println("****ENCONTRASTE UN CONEJO****");
				}
			}
			else // En caso de no haber conejo
			{
				this.tablero[ren-1][col-1].setRevisado(1); // Se marca como revisado
				this.intentos -= 1; // se decrementa uno los intentos
				System.out.println("****NO HABIA CONEJO****"); // Se notifica
			}
		}
		// Simula limpiar pantalla en la consola (En caso de no funcionar, quite las lineas)
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// Simula limpiar pantalla en la consola
		this.respuestaTablero(); // Al final se muestra las ubicaciones de los conejos
		if(this.totalConejos ==0 ) // Dependiendo si los encontraste todos sin gastar todos los intentos te inidicara si ganaste o perdiste 
		{	
			System.out.println("***FELICIDADES GANASTE :)***");
			return 1;
		}
		System.out.println("SUERTE PARA LA PROXIMA");
		return 0;
	}

	// Main exclusivo para pruebas de esta clase (No es el main del proyecto)
	public static void main(String[] args) 
	{
		Tablero tab = new Tablero();
		/*
		tab.tablero[3][2].setRevisado(1);
		tab.tablero[1][2].setConejo(true);
		tab.tablero[1][3].setConejo(true);
		tab.tablero[1][3].setRevisado(1);
		
		tab.insertarConejos();
		tab.imprimirTablero();	
		System.out.println();
		tab.respuestaTablero();
		System.out.println(tab.totalConejos);
		*/
		tab.juego();
	}
}