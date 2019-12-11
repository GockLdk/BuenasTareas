/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author 
 */
// CLASE CLIENTE CON TODO LO CORRESPONDIENTE A ELLA
public class Cliente{
    
    private int clave;
    private String nombre;
    private String razon;
    private String dir;
    private String email;
    
    public Cliente(int clave, String nom, String razon, String dir, String mail)
    {
        this.clave = clave;
        this.dir = dir;
        this.email = mail;
        this.nombre =  nom;
        this.razon = razon;
    }
    
    public void setClave(int clave)
    {
        this.clave = clave;
    }
    
    public int getClave()
    {
        return this.clave;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setDir(String dir)
    {
        this.dir = dir;
    }
    
    public String getDir()
    {
        return this.dir;
    }
    
    public void setRazon(String razon)
    {
        this.razon = razon;
    }
    
    public String getRazon()
    {
        return this.razon;
    }
    
    public void setEmail(String mail)
    {
        this.email = mail;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    @Override
    public String toString() {
        return "Clave: " + this.clave
                + "\nNombre: " + this.nombre
                + "\nRazon Social: " + this.razon
                + "\nDireccion: " + this.dir
                + "\nEmail: " + this.email;
    }
}
