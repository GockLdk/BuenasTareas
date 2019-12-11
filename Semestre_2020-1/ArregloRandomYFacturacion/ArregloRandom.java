import java.util.Scanner; //Paquete para leer desde entrada estandar

public class ArregloRandom
{
	public int [] arreglo; // Decimos que tiene un arreglo pero no se instancia
	public int n; // Tamanio del arreglo
	
	// Metodo privado que genera un numero aleatorio entre un rango de numeros definidos por inicio y fin
	private Integer numRandom(int inicio,int fin)
	{
		return (int) (Math.random() * (fin-inicio+1))+inicio ;
	}

	// Metodo que recorre el arreglo y va llenando cada campo con un numero aleatorio
	public void llenarArreglo(int inicio,int fin)
	{
		for (int i=0;i<n;i++) 
		{
			this.arreglo[i] = this.numRandom(inicio,fin); // Nota: se especifica que ocupe el arreglo y el metodo numRandom de esta (this) clase
		}
	}

	// Metodo que va recorriendo el arreglo para imprimir cada elemento y sumarlos simultaneamente para finalmente imprimirlo
	public void resultadoArreglo()
	{
		int res = 0;

		System.out.print("Arreglo:\n[");
		for (int i=0;i<n;i++) 
		{
			
			System.out.print(this.arreglo[i] + " ");
			res += this.arreglo[i];
		}
		System.out.println("]");
		System.out.println("Suma total del contenido del arreglo: " + res);

	}

	// Metodo main donde se hace la prueba
	public static void main(String[] args) 
	{
		
		ArregloRandom r = new ArregloRandom(); // Instanciamos un objeto r de la clase ArregloRandom
		Scanner sc = new Scanner(System.in); // Intnaciamos un objeto sc de la clase Scanner para leer datos
		
		System.out.print("Favor de darme el tamanio de tu arreglo: ");
		r.n = sc.nextInt(); // Guardamos en n el tamanio que nos de en la entrada estandar
		r.arreglo = new int [r.n]; // Ahora con el tamanio ya definido creamos el arreglo del objeto r con ese tamanio
		System.out.println("Favor de darme el rango de los numeros que van a ver en el arreglo");
		System.out.print("Inicio: ");
		int inicio = sc.nextInt();
		System.out.print("Final: ");
		int fin = sc.nextInt();
		r.llenarArreglo(inicio,fin); // Llenamos el arreglo
		r.resultadoArreglo(); // Mostramos resultados
	}
}