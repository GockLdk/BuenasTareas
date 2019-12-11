// Importando Paquetes
import java.util.Scanner;

// Clase principal del proyecto
// Hereda de Tablero para poder manejar el juego de Conejos
public class Arcade extends Tablero 
{
	// Contadores
	public int juegosTotales;
	public int juegosGanados;

	// Constructor
	public Arcade()
	{
		this.juegosTotales = 0;
		this.juegosGanados = 0;
	}

	// Metodo para jugar en la Arcade
	public void jugar()
	{	
		int opc = 1; // Variable que define si se quiere volver a jugar
		Scanner sc = new Scanner(System.in); // Scanner

		System.out.println("******** Busca Conejos ********\n******** BIENVENID@ ********");
		while(opc == 1)
		{
			// Crea un Arcade con el Tablero de conejos
			Arcade juegoCone = new Arcade();
			int resultado = juegoCone.juego(); // Inicia el juego
			this.juegosTotales += 1;
			this.juegosGanados += resultado;
			System.out.print("\nQuieres volver a jugar?\nSelecciona el numero segun su respuesta:\n1.-Si\n2.-No\nRes:");
			opc = sc.nextInt();
		}
		// Simula limpiar pantalla en la consola (En caso de no funcionar, quite las lineas)
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// Simula limpiar pantalla en la consola
		System.out.println("******** Busca Conejos ********");
		System.out.println("ESTADISTICAS");
		System.out.println("Partidas Totales Jugadas: " + this.juegosTotales);
		System.out.println("Partidas Ganadas: " + this.juegosGanados);
		System.out.println("Partidas Perdidas: " + (this.juegosTotales-this.juegosGanados));
		System.out.println("Porcentaje de Victorias (Efectividad): " + (double) ((double)this.juegosGanados/((double)this.juegosTotales))*100 + "%");
		System.out.println("******** HASTA LUEGO <3 ********");
	} 

	// Main del proyecto
	public static void main(String[] args) 
	{
		// Se crea una Arcade y se juega el Busca Conejos
		Arcade arcade = new Arcade();
		arcade.jugar();
	}

}