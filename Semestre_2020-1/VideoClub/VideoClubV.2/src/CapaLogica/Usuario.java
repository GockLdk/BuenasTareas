/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 
 */
// CLASE USUARIO
// DE AQUI SE CREARAN LOS OBJETO DE TIPO USUARIO DEL VIDEO CLUB
// ES SERIALIZABLE YA QUE SE PREFIRIO GUARDAR LA INFO COMO ARCHIVOS .SER YA QUE SON MAS LIVIANOS YA QUE AL SER ARCHIVOS CON INFORMACION
// SERIALIZADA SON PUROS 0 Y 1 (lENGUAJE MAQUINA) POR LO QUE SON MAS LIGEROS Y FACIL DE ESCRIBIR, CREAR Y BORRAR.
public class Usuario implements Serializable
{
    /* Atributos de los usuarios
    // tipoUsuario :
    //      1 = Admin
    //      2 = Normal
    //      3 = VIP
    // ciudadanoOro:
    //      false = No es ciudadano Oro
    //      true = Es ciudadano Oro
`   */
    private String nombre;
    private int id;
    private int contrasena;
    private int edad;
    private int telefono;
    private String correo;
    private int tipoUsuario;
    private boolean ciudadanoOro;
    public ArrayList<Producto> alquilados; // LISTA PARA GUARDAR LOS PRODUCTOS QUE ALQUILA EL CLIENTE
    
    public Usuario(String nom,int id,int pass,int ed,int tel,String mail,int tipo)
    {
        this.nombre = nom;
        this.id = id;
        this.contrasena = pass;
        this.edad = ed;
        this.telefono = tel;
        this.correo = mail;
        this.tipoUsuario = tipo;
        // Si es Usuario es mayor de 65 anios, por lo tanto es un cidadano oro
        this.ciudadanoOro = ed >= 65;
        this.alquilados = new ArrayList<>();
    }
    
    // GETTERS Y SETTERS
    public void setNombre(String nom)
    {
        this.nombre = nom;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
     public void setContrasena(int pass)
    {
        this.contrasena = pass;
    }
    
    public int getContrasena()
    {
        return this.contrasena;
    }
    
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    
    public int getEdad()
    {
        return this.edad;
    }
    
    public void setTelefono(int tel)
    {
        this.telefono = tel;
    }
    
    public int getTelefono()
    {
        return this.telefono;
    }
    
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
    public String getCorreo()
    {
        return this.correo;
    }
    
    public void setTipoUsuario(int tipo)
    {
        this.tipoUsuario = tipo;
    }
    
    public int getTipoUsuario()
    {
        return this.tipoUsuario;
    }
    
    
    public void setCiudadanoOro(boolean oro)
    {
        this.ciudadanoOro = oro;
    }
    
    public boolean getCiudadanoOro()
    {
        return this.ciudadanoOro;
    }
    
    // SOBRE ESCRITURA DEL METODO TOSTRING
    @Override
    public String toString()
    {
        String data = "ID: " + this.id + "\nCiudadano: " + this.nombre + "\nEdad: " + this.edad + "\nTelefono: " + this.telefono + "\nCorreo: " + this.correo + "\nTipo de Usuario: ";
        switch(this.tipoUsuario)
        {
            case 1:
                data =  data + " Administrador\n";
            break;
            case 2:
                data =  data + " Cliente Normal\n";
            break;
            case 3:
                data =  data + " Cliente VIP\n";
            break;
        }
        
        if(this.ciudadanoOro)
            data = data + "Ciudadano Oro: SI\n";
        else
            data = data + "Ciudadano Oro: NO\n";
        
        return data;
    }
    
    public void main()
    {
       Usuario admin = new Usuario("Admin",123456789,1234,43,55987645,"admin@videoclub.com",1);
        Usuario normal = new Usuario("Laura",134756789,9876,23,52387645,"Laura@videoclub.com",2);
        Usuario vip = new Usuario("Carlos",123287789,8172,65,55985645,"Carlos@videoclub.com",3);
        
        System.out.println(admin.toString());
        System.out.println(normal.toString());
        System.out.println(vip.toString());
    }
}
