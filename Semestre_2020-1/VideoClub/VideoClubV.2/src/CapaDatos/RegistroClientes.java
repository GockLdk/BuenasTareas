/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

import CapaLogica.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author 
 */
// CLASE RESPONSABLE DE LA PERSISTENCIA DE LOS DATOS
// EN RESUMEN SE ENCARGA DE BUSCAR, CREAR , BORRAR Y SOBREESCRIBIR LOS ARCHIVOS .SER CON LA INFO DE CADA USUARIO
// CADA USUARIO SE GUARDAN EN SU CARPETA CORRESPONDIENTE ADMIN , NORMAL O VIP
// ESTAS CARPETAS ESTAN UBICADA EN LA CARPETA cLIENTES QUE ESTA DENTRO DE DATOS, Y DATOS ESTA UBICADA A LA ALTURA DE LA CARPETA SRC DEL PROYECTO DE NETBEANS
public class RegistroClientes 
{
    // LISTAS DE LOS USUARIOS DE CAD TIPO
    public ArrayList<String> listaAdmin;
    public ArrayList<String> listaNormal;
    public ArrayList<String> listaVIP;
    
    public RegistroClientes()
    {
        this.listaAdmin = new ArrayList<>();
        this.listaNormal = new ArrayList<>();
        this.listaVIP = new ArrayList<>();
        
    }
    
    /**
     *
     * @return
     */
    // DEVUELVE UNA DEFAULT LIST CON LA INFO MAS IMPORTANTE DE TODOS LOS USUARIO
    // DEVUELVE LA DEFAULT LIST YA QUE ESO RECIBE EL JLIST PARA FUNCIONAR
    public DefaultListModel actualizarJList() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // LIMPIAR LAS LISTAS
        this.listaAdmin.clear();
        this.listaNormal.clear();
        this.listaVIP.clear();
        DefaultListModel model = new DefaultListModel(); // CREA LA MODELLIST
        // SE VA A LA CARPETA
         File f = new File(".\\Datos\\Clientes\\Admin\\");

                String archivos[] = f.list(); // GUARDA EN UNA LISTA TODOS LOS NOMBRES DE LOS ARCHIVOS DENTRO DE ELLA

                for (String archivo : archivos) // RECORRE LA LISTA
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Admin\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject(); // LEE LA INFO DE CADA USUARIO
                    }
                    this.listaAdmin.add(user.getId() + "    " + user.getNombre() + "    " + user.getEdad() + "    " + user.getCorreo() + "    Administrador" + "    " + user.getContrasena()  );    // GUARDA LA INFO MAS RELEVENATE
                }
                // LO ANTERIOR FUE PARA LA CARPETA DE LOS USUARIOS ADMIN, LO DEMAS SE REPITE PERO PARA LAS DEMAS CARPETAS, Y ASI OBTENER LAS LISTAS LLENAS CON SUS USUARIOS CORRESPONDIENTES 
        f = new File(".\\Datos\\Clientes\\Normal\\");

                String archivos2[] = f.list();

                for (String archivo : archivos2) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Normal\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    this.listaAdmin.add(user.getId() + "    " + user.getNombre() + "    " + user.getEdad() + "    " + user.getCorreo() + "    Normal" + "    " + user.getContrasena());    
                }
                
        f = new File(".\\Datos\\Clientes\\VIP\\");

                String archivos3[] = f.list();

                for (String archivo : archivos3) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\VIP\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    this.listaAdmin.add(user.getId() + "    " + user.getNombre() + "    " + user.getEdad() + "    " + user.getCorreo() + "    VIP" + "    " + user.getContrasena());    
                }
        
                // GUARDA LA INFO DE CADA LISTA EN LA MODELLIST PARA LA JLIST
        for(String info : this.listaAdmin )
            model.addElement(info);
        
        for(String info : this.listaNormal )
            model.addElement(info);
        
        for(String info : this.listaVIP )
            model.addElement(info);
        
        return model;
    }
    
    // CREA UN ARCHIVO SER CON LOS DATOS DE UN USUARIO
    public void insert(Usuario user) throws IOException {
        
        // DEPENDIEDO DEL TIPO DE USUARIO
        switch(user.getTipoUsuario())
        {
            // pARA ADMIN
            case 1:
                try 
                {
                    // CREA UN OBJETO DE SALIDA DE FLUJO CON EL NOMBRE DEL ID DEL USUARIO
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\Admin\\" + user.getId() + ".ser"));
                    out.writeObject(user); // ESCRIBE ESE ARCHIVO (LO CREA O SOBRESECRIBE SEGUN EL CASO)
                    out.close(); // CIERRA EL FLUJO
                }
                catch(FileNotFoundException e)
                {
                    // EN CASO DE NO EXISTIR LA CARPTE ADMIN
                    File f = new File(".\\Datos\\Clientes\\Admin\\");
                    f.mkdir(); // LA CREA
                    // REPITE LO DEL FLUJO
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\Admin\\" + user.getId() + ".ser"));
                    out.writeObject(user);
                    out.close();
                }
            break;
            // hACE LOS MISMO PERO DEPENDIENDO DEL USUARIO LO GUARDA EN LAS OTRAS CARPETAS
            case 2:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\Normal\\" + user.getId() + ".ser"));
                    out.writeObject(user);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Clientes\\Normal\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\Normal\\" + user.getId() + ".ser"));
                    out.writeObject(user);
                    out.close();
                }
            break;
            
            case 3:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\VIP\\" + user.getId() + ".ser"));
                    out.writeObject(user);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Clientes\\VIP\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Clientes\\VIP\\" + user.getId() + ".ser"));
                    out.writeObject(user);
                    out.close();
                }
            break;
        }
        
    }
    // bUSQUEDA DE USUARIO QUE DEVUELVE EL USUARIO SI LO ENCUENTRA
     public Usuario bus(int id,int tipo) throws Exception {
        // pARA CADA USUARIO
         switch(tipo)
         {
            case 1:
                File f = new File(".\\Datos\\Clientes\\Admin\\");

                String archivos[] = f.list();
                // RECORRE LA CARPTEA CORRESPONDIENTE
                for (String archivo : archivos) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Admin\\" + archivo))) 
                    {
                        // lEE EL ARCHIVO CON LOS DATOS
                        user = (Usuario) in.readObject();
                    }
                    // Y SI COINCIDE LA ID PROPORCIONADA CON LA DELA ARCHIVO, DEVUELVE EL OBJETO
                    if (user.getId() == id) 
                        return user;
                }
            break;
            
            case 2:
                File f2 = new File(".\\Datos\\Clientes\\Normal\\");

                String archivos2[] = f2.list();

                for (String archivo : archivos2) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Normal\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    if (user.getId() == id) 
                        return user;
                }
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Clientes\\VIP\\");

                String archivos3[] = f3.list();

                for (String archivo : archivos3) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\VIP\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    if (user.getId() == id) 
                        return user;
                }
            break;
         }
         
        
        return null;
    }
     // BORRA USUARIO
    public int delete(int id,int tipo) throws Exception
    {
        // DEPENDIENDO DEL TIPO DE USUARIO
        switch(tipo)
        {
            case 1:
                // BORRA EL ARCHIVO
                File f = new File(".\\Datos\\Clientes\\Admin\\" + id + ".ser");
                boolean r = f.delete(); // GUARDA SI FUE UN EXITO  O NO EL BORRADO
                if(r == true) // SI LO FUE DEVULEVE UN 1
                    return 1;
                if(r == false) // SI NO DEVULEVE UN 0
                    return 0;
            break;
                
            case 2:
                File f2 = new File(".\\Datos\\Clientes\\Normal\\" + id + ".ser");
                boolean r2 = f2.delete();
                if(r2 == true)
                    return 1;
                if(r2 == false)
                    return 0;
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Clientes\\VIP\\" + id + ".ser");
                boolean r3 = f3.delete();
                if(r3 == true)
                    return 1;
                if(r3 == false)
                    return 0;
            break;
        }

        return 0;
    }
    
    // iGUAL QUE EL ANTERIOR METODO BUS PERO COMPARA EL NOMBRE EN VEZ DE LA ID PARA ENCONTRAR AL USUARIO
    // ES STATIC PARA PODER USARLO SIN GASTAR MEMORIA EN LA BUSQUEDA A LA HORA DEL LOGIN
     public static Usuario busqueda(String nombre) throws Exception {
        
         
                File f = new File(".\\Datos\\Clientes\\Admin\\");

                String archivos[] = f.list();

                for (String archivo : archivos) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Admin\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    if (user.getNombre().equals(nombre) ) 
                        return user;
                }
            
                File f2 = new File(".\\Datos\\Clientes\\Normal\\");

                String archivos2[] = f2.list();

                for (String archivo : archivos2) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\Normal\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    if (user.getNombre().equals(nombre) ) 
                        return user;
                }
            
                File f3 = new File(".\\Datos\\Clientes\\VIP\\");

                String archivos3[] = f3.list();

                for (String archivo : archivos3) 
                {
                    Usuario user;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Clientes\\VIP\\" + archivo))) 
                    {
                        user = (Usuario) in.readObject();
                    }
                    if (user.getNombre().equals(nombre)) 
                        return user;
                }
         
        
        return null;
    }
     
    /**
     * MAIN PRUEBA
     */
    public void main() throws IOException, Exception
     {
         RegistroClientes r = new RegistroClientes();
       Usuario admin = new Usuario("Admin",123456789,1234,43,55987645,"admin@videoclub.com",1);
        Usuario normal = new Usuario("Laura",134756789,9876,23,52387645,"Laura@videoclub.com",2);
        Usuario vip = new Usuario("Carlos",123287789,8172,65,55985645,"Carlos@videoclub.com",3);
       r.insert(admin);
       r.insert(normal);
       r.insert(vip);
       
       int i = r.delete(123287789, 3);
       Usuario user2 = r.bus(123287789,3);
       if(user2 == null)
       {
           System.out.println("NO HAY");
       }
       else{
           System.out.println(user2.toString());
       }
       
       Usuario user = r.bus(123456789,1);
       System.out.println(user.toString());
       Usuario user1 = r.bus(134756789,2);
       System.out.println(user1.toString());
     }
}
