// Clase Alumno con todos los datos del alumno
public class Alumno
{
	// Atributos del Alumno
	private int matricula;
	private String nombre;
	private String carrera;
	private String turno;
	private int edad;
	private int id;

	// Constructor
	public Alumno(int matri,String nom,String carr,String tur,int ed, int id)
	{
		this.matricula = matri;
		this.nombre = nom;
		this.carrera = carr;
		this.turno = tur;
		this.edad = ed;
		this.id = id;
	}

	//Getters y Setters de cada Atributo para poder modificarlos

	public void setMatricula(int matri)
	{
		this.matricula = matri;
	}

	public int getMatricula()
	{
		return this.matricula;
	}

	public void setNombre(String nom)
	{
		this.nombre = nom;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setCarrera(String carr)
	{
		this.carrera = carr;
	}

	public String getCarrera()
	{
		return this.carrera;
	}

	public void setTurno(String tur)
	{
		this.turno = tur;
	}

	public String getTurno()
	{
		return this.turno;
	}

	public void setEdad(int ed)
	{
		this.edad = ed;
	}

	public int getEdad()
	{
		return this.edad;
	}

	public void setId(int id)
	{
		this.id =id;
	}

	public int getId()
	{
		return this.id;
	}

	// Sobreescirbimos el metodo toString() para poder imprimir con cierto formato la informacion del alumno
	@Override
	public String toString()
	{
		return "\nMatricula: " + this.matricula + "\nNombre: " + this.nombre + "\nCarrera: " + this.carrera + "\nTurno: " + this.turno + "\nEdad: " + this.edad + "\nId: " + this.id + "\n";
	}

	// Main de prueba de la clase alumno
	public static void main(String[] args) 
	{
		
		// Instanciando 2 alumnos
		Alumno pedro = new Alumno(123456789,"Pedro Picapiedra","Ing. Civil","Matutino",38,1234);
		Alumno pablo = new Alumno(987654321,"Pablo Marmol","Ing. Civil","Matutino",36,5678);
		// Imprimiendo toda la info de pedro
		System.out.println(pedro.toString());
		// Imprimiendo solo el nombre de pedro
		System.out.println(pedro.getNombre());
		// Cambiando la carrera de pablo
		pablo.setCarrera("Ing. Compu");
		// Imprimiendo todo la info de pablo
		System.out.println(pablo.toString());
	}

}