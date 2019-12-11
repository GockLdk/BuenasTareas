// Clase Casilla
public class Casilla
{	
	// Variables privadas 
	private Boolean conejo; // true = existe conejo, false = No existe conejo
	private int revisado; // 1 = El jugador reviso esta casilla, 0 = El jugador no ha revisado esta casilla

	/* Constructor
	   Crea por defecto una casilla donde no existe un conejo
	   y no ha sido revisado por el jugador
	*/ 
	public Casilla()
	{
		this.conejo = false;
		this.revisado = 0;
	}

	// Devuelve el valor de conejo
	public Boolean getConejo()
	{
		return this.conejo;
	}

	// Modifica el valor de conejo (recibe un booleano)
	public void setConejo(Boolean cone)
	{
		this.conejo = cone;
	}

	// Devuelve el valor de revisado
	public int getRevisado()
	{
		return this.revisado;
	}

	// Modifica el valor de revisado (recibe un entero)
	public void setRevisado(int revi)
	{
		this.revisado = revi;
	}
}