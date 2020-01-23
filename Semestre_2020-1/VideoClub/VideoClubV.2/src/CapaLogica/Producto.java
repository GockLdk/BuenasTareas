/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author 
 */
// CLASE PRODUCTO QUE DEFINIRA LOS PRODUCTOS DEL VIDEO CLUB
// SIGUE LA MISMA LOGICA DE LA CLASE USUARIO AL HABLAR QUE IMPLEMENTA LA INTERFAZ SERIALIZABLE
public class Producto implements Serializable
{
    // Atributos de los Productos
    /* tipo:
    //     1 = Pelicula
    //     2 = Videjuego
    //     3 = Cartelera
    */
    private int codigo;
    private int tipo;
    private String nombre;
    private int creacion;
    private int existencia;
    
    public Producto(int cod, int tip,String nom,int anio,int ex)
    {
        this.codigo = cod;
        this.tipo = tip;
        this.nombre = nom;
        this.creacion = anio;
        this.existencia = ex;
    }
    // SETTERS Y GETTERS
    
    public void setCodigo(int cod)
    {
        this.codigo = cod;
    }
    
    public int getCodigo()
    {
        return this.codigo;
    }
    
    public void setTipo(int tip)
    {
        this.tipo = tip;
    }
    
    public int getTipo()
    {
        return this.tipo;
    }
    
    public void setNombre(String nom)
    {
        this.nombre = nom;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setCreacion(int anio)
    {
        this.creacion = anio;
    }
    
    public int getCreacion()
    {
        return this.creacion;
    }
    
    public void setExistencia(int ex)
    {
        this.existencia = ex;
    }
    
    public int getExistencia()
    {
        return this.existencia;
    }
    // SOBRE ESCIRUTRA DLE METODO TOSTRING
    @Override
    public String toString()
    {
        String info = "";
        switch(this.tipo)
        {
            case 1:
                info = "Pelicula\n";
            break;
            
            case 2:
                info = "Videojuego\n";
            break;
            
            case 3:
                info = "Cartelera\n";
            break;
        }
        info = info + "Codigo: " + this.codigo + "\nNombre: " + this.nombre + "\nAño de Creacion: " + this.creacion + "\nExistencia: " + this.existencia + "\n";
        
        return info ;
    }
    
    public void main()
    {
        Producto peli = new Producto(123456,1,"Shrek",2001,5);
        Producto juego = new Producto(987654,2,"Halo 5",2015,10);
        Producto carte = new Producto(817263,3,"Star Wars",2019,7);
        
        System.out.println(peli.toString());
         System.out.println(juego.toString());
          System.out.println(carte.toString());
    }
}
