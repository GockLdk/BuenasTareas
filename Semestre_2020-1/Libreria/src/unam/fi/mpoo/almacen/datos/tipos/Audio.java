package unam.fi.mpoo.almacen.datos.tipos;

import java.io.Serializable;

// EJERCICIO 2
// SE HACEN LOS OBJETOS SERIALIZABLES PARA PODER HACERLOS ARCHIVOS .SER
public class Audio implements Serializable{

	// EJERCICIO 1
	public final int tipo = 2;

	private String autor;
	private String titulo;
	private String info;

	public Audio() {
		// TODO Auto-generated constructor stub
	}

	public Audio(String aut,String tit, String informacion)
	{
		this.autor = aut;
		this.titulo = tit;
		this.info = informacion;
	}

	public String getAutor()
	{
		return this.autor ;
	}

	public void setAutor(String auto)
	{
		this.autor = auto;
	}

	public String getTitulo()
	{
		return this.titulo;
	}

	public void setTitulo(String tit)
	{
		this.titulo = tit;
	}

	public String getInfo()
	{
		return this.info;
	}

	public void setInfo(String inf)
	{
		this.info = inf;
	}

	public String toString()
	{
		return "Audiolibro\nTitulo: " + this.titulo + "\nAutor: " + this.autor + "\nTipo: " + this.info;
	}
}
