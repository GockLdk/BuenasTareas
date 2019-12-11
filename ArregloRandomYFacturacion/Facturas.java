import java.util.ArrayList; // Paquete de la ArrayList o lista
import java.util.Scanner; // Scanner

public class Facturas
{
	// Atributos de las facturas
	public int codigo;
	public int litros;
	public Double precio;

	// Constructor de facturas que recibe los litros y el precio de ellas y el codigo se genera aleatorio
	Facturas(int lts,Double precio)
	{
		this.codigo = this.codigoRandom();
		this.litros = lts;
		this.precio = precio;
	}

	// Metodo para generar codigo de la factura
	public Integer codigoRandom()
	{
		return (int) (Math.random() * (90000-10000+1))+10000 ;
	}

	// Imprimir datos de la factura
	public void datosFactura()
	{
		System.out.println("Factura: " + this.codigo);
		System.out.println("Litros Totales: " + this.litros);
		System.out.println("Precio Total: " + this.precio);
	}


	public static void main(String[] args) 
	{
		ArrayList<Facturas> facturas = new ArrayList<Facturas>(); // Creamos lista de facturas
		Scanner sc =  new Scanner(System.in); // Scanner

		System.out.println("**********Facturacion*********");
		// Para 5 facturas
		for (int i=1;i<=5;i++) 
		{
			Double precio = 0.00;                               //
			int litros = 0;										//
			System.out.println("Datos de la Factura " + i);		//
			System.out.print("Litros Totales: ");				// Se crea una factura con los datos pedidos
			litros = sc.nextInt();								// 
			System.out.print("Precio Total: "); 				//
			precio = sc.nextDouble();							//
			Facturas f = new Facturas(litros,precio);			//
			facturas.add(f); // Se guarda la factura en la lista de facturas
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("*******Datos de las Facturas*********");
		Double precioTotal = 0.00;
		// Optenemos la facturacion total recorriendo la lista y sumando el precio de cada factura
		for (Facturas fac : facturas ) 
		{
			precioTotal += fac.precio;
		}
		System.out.println("Facturacion Total: " + precioTotal); // Se imprime la facturacion total
		System.out.println("Litros vendidos en la Factura 1: "+ (facturas.get(0)).litros); // Se imprime los litros de la primer factura
		System.out.println("***Facturas de mas de 1,500.00 MXN***"); 
		// Se recorre la lista 
		for (Facturas fac : facturas ) 
		{
			// Y si el precio de la factura es mayor a 1500
			if(fac.precio>1500.00)
			{
				// Se imprimen sus datos
				System.out.println("-----------------------");
				fac.datosFactura();
			}
		}
	}
}