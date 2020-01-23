package CapaDatos;


import CapaLogica.Producto;
import CapaLogica.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
// CLASE QUE MANTIENE LA PERSISTENCIA DE DATOS DE LOS PRODUCTOS
// EN RESUMEN LA MISMA LOGICA QUE LA DE REGISTROUSUARIO PERO PARA PRODUCTOS
// SE GUARDAN EN LA CARPETAS PELICULAS, CARTELERAS O VIDEOJUEGOS EN SUS SUBCARPETAS STOCK O ALQUILER
// STOCK = PRODUCTOS DISPONIBLES A ALQUILAR , ALQUILAER = PRODUCTOS ACTUALMENTE ALQUILADOS
// ESTAS CARPETAS ESTAN UBICADAS EN LA CARPETA PRODUCTOS QUE ESTA DENTRO DE DATOS, Y DATOS ESTA UBICADA A LA ALTURA DE LA CARPETA SRC DEL PROYECTO DE NETBEANS
public class RegistroProductos 
{
    // LISTAS SEGUN EL CASO DE LOS PRODUCTOS
    public ArrayList<String> listaPeli;
    public ArrayList<String> listaJuego;
    public ArrayList<String> listaCarte;
    public ArrayList<String> listaPeliAlquiler;
    public ArrayList<String> listaJuegoAlquiler;
    public ArrayList<String> listaCarteAlquiler;
    
    public RegistroProductos()
    {
        this.listaPeli = new ArrayList<>();
        this.listaJuego = new ArrayList<>();
        this.listaCarte = new ArrayList<>();
        this.listaPeliAlquiler = new ArrayList<>();
        this.listaJuegoAlquiler = new ArrayList<>();
        this.listaCarteAlquiler = new ArrayList<>();
        
    }
    // COMO LA LOGICA ES LA MISMA SOLO SE COMENTARA PARA QUE SRIVE
    // DEVUELEV MODEL PARA LA LISTA DE TODOS LOS PRODUCTOS
    public DefaultListModel actualizarJList() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        this.listaPeli.clear();
        this.listaJuego.clear();
        this.listaCarte.clear();
        DefaultListModel model = new DefaultListModel();
         File f = new File(".\\Datos\\Productos\\Peliculas\\Stock\\");

                String archivos[] = f.list();

                for (String archivo : archivos) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Peliculas\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    this.listaPeli.add(pro.getCodigo() + "        Pelicula          " + pro.getNombre() + "        " + pro.getExistencia());    
                }
                
        f = new File(".\\Datos\\Productos\\Videojuegos\\Stock\\");

                String archivos2[] = f.list();

                for (String archivo : archivos2) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Videojuegos\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                   this.listaPeli.add(pro.getCodigo() + "        Videojuego    " + pro.getNombre() + "        " + pro.getExistencia());
                }
                
        f = new File(".\\Datos\\Productos\\Carteleras\\Stock\\");

                String archivos3[] = f.list();

                for (String archivo : archivos3) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Carteleras\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    this.listaPeli.add(pro.getCodigo() + "        Cartelera        " + pro.getNombre() + "        " + pro.getExistencia());
                }
                
        for(String info : this.listaPeli )
            model.addElement(info);
        
        for(String info : this.listaJuego )
            model.addElement(info);
        
        for(String info : this.listaCarte )
            model.addElement(info);
        
        return model;
    }
    
    // dEVUELVE MODEL PARA LA LISTA DE ALQUILER
     public DefaultListModel actualizarJListAlquiler() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        this.listaPeliAlquiler.clear();
        this.listaJuegoAlquiler.clear();
        this.listaCarteAlquiler.clear();
        DefaultListModel model = new DefaultListModel();
         File f = new File(".\\Datos\\Productos\\Peliculas\\Alquiler\\");

                String archivos[] = f.list();

                for (String archivo : archivos) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Peliculas\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    this.listaPeliAlquiler.add(pro.getCodigo() + "        Pelicula          " + pro.getNombre() + "        " + pro.getExistencia());    
                }
                
        f = new File(".\\Datos\\Productos\\Videojuegos\\Alquiler\\");

                String archivos2[] = f.list();

                for (String archivo : archivos2) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Videojuegos\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                   this.listaPeliAlquiler.add(pro.getCodigo() + "        Videojuego    " + pro.getNombre() + "        " + pro.getExistencia());
                }
                
        f = new File(".\\Datos\\Productos\\Carteleras\\Alquiler\\");

                String archivos3[] = f.list();

                for (String archivo : archivos3) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Carteleras\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    this.listaPeliAlquiler.add(pro.getCodigo() + "        Cartelera        " + pro.getNombre() + "        " + pro.getExistencia());
                }
                
        for(String info : this.listaPeliAlquiler )
            model.addElement(info);
        
        for(String info : this.listaJuegoAlquiler )
            model.addElement(info);
        
        for(String info : this.listaCarteAlquiler )
            model.addElement(info);
        
        return model;
    }
    // INSERT PRODUCTO
    public void insert(Producto pro) throws IOException {
        
        
        switch(pro.getTipo())
        {
            case 1:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Peliculas\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Peliculas\\Stock\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Peliculas\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
            
            case 2:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Videojuegos\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Videojuegos\\Stock\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Videojuegos\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
            
            case 3:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Carteleras\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Carteleras\\Stock\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Carteleras\\Stock\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
        }
        
    }
    // INSERT PRODUCTO EN ALQUILER
    public void insertAlquiler(Producto pro) throws IOException {
        
        
        switch(pro.getTipo())
        {
            case 1:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Peliculas\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Peliculas\\Alquiler\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Peliculas\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
            
            case 2:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Videojuegos\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Videojuegos\\Alquiler\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Videojuegos\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
            
            case 3:
                try 
                {
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Carteleras\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
                catch(FileNotFoundException e)
                {
                    File f = new File(".\\Datos\\Productos\\Carteleras\\Alquiler\\");
                    f.mkdir();
            
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(".\\Datos\\Productos\\Carteleras\\Alquiler\\" + pro.getCodigo() + ".ser"));
                    out.writeObject(pro);
                    out.close();
                }
            break;
        }
        
    }
    // BUSCAR EN STOCK
    public Producto bus(int cod,int tipo) throws Exception {
        
         switch(tipo)
         {
            case 1:
                File f = new File(".\\Datos\\Productos\\Peliculas\\Stock\\");

                String archivos[] = f.list();

                for (String archivo : archivos) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Peliculas\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
            
            case 2:
                File f2 = new File(".\\Datos\\Productos\\Videojuegos\\Stock\\");

                String archivos2[] = f2.list();

                for (String archivo : archivos2) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Videojuegos\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Productos\\Carteleras\\Stock\\");

                String archivos3[] = f3.list();

                for (String archivo : archivos3) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Carteleras\\Stock\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
         }
         
        
        return null;
    }
    // BUSCRA EN aLQUILER
     public Producto busAlquiler(int cod,int tipo) throws Exception {
        
         switch(tipo)
         {
            case 1:
                File f = new File(".\\Datos\\Productos\\Peliculas\\Alquiler\\");

                String archivos[] = f.list();

                for (String archivo : archivos) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Peliculas\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
            
            case 2:
                File f2 = new File(".\\Datos\\Productos\\Videojuegos\\Alquiler\\");

                String archivos2[] = f2.list();

                for (String archivo : archivos2) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Videojuegos\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Productos\\Carteleras\\Alquiler\\");

                String archivos3[] = f3.list();

                for (String archivo : archivos3) 
                {
                    Producto pro;
                    try (ObjectInput in = new ObjectInputStream(new FileInputStream(".\\Datos\\Productos\\Carteleras\\Alquiler\\" + archivo))) 
                    {
                        pro = (Producto) in.readObject();
                    }
                    if (pro.getCodigo() == cod) 
                        return pro;
                }
            break;
         }
         
        
        return null;
    }
    // bORRAR EN sTOCK
    public int delete(int cod,int tipo) throws Exception
    {
        switch(tipo)
        {
            case 1:
                File f = new File(".\\Datos\\Productos\\Peliculas\\Stock\\" + cod + ".ser");
                boolean r = f.delete();
                if(r == true)
                    return 1;
                if(r == false)
                    return 0;
            break;
                
            case 2:
                File f2 = new File(".\\Datos\\Productos\\Videojuegos\\Stock\\" + cod + ".ser");
                boolean r2 = f2.delete();
                if(r2 == true)
                    return 1;
                if(r2 == false)
                    return 0;
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Productos\\Carteleras\\Stock\\" + cod + ".ser");
                boolean r3 = f3.delete();
                if(r3 == true)
                    return 1;
                if(r3 == false)
                    return 0;
            break;
        }

        return 0;
    }
    // BORRAR EN ALQUILER
    public int deleteAlquiler(int cod,int tipo) throws Exception
    {
        switch(tipo)
        {
            case 1:
                File f = new File(".\\Datos\\Productos\\Peliculas\\Alquiler\\" + cod + ".ser");
                boolean r = f.delete();
                if(r == true)
                    return 1;
                if(r == false)
                    return 0;
            break;
                
            case 2:
                File f2 = new File(".\\Datos\\Productos\\Videojuegos\\Alquiler\\" + cod + ".ser");
                boolean r2 = f2.delete();
                if(r2 == true)
                    return 1;
                if(r2 == false)
                    return 0;
            break;
            
            case 3:
                File f3 = new File(".\\Datos\\Productos\\Carteleras\\Alquiler\\" + cod + ".ser");
                boolean r3 = f3.delete();
                if(r3 == true)
                    return 1;
                if(r3 == false)
                    return 0;
            break;
        }

        return 0;
    }
    
    public void main() throws IOException
    {
        RegistroProductos res = new RegistroProductos();
        Producto peli = new Producto(123456,1,"Shrek",2001,5);
        Producto juego = new Producto(987654,2,"Halo 5",2015,10);
        Producto carte = new Producto(817263,3,"Star Wars",2019,7);
        
        res.insert(peli);
        res.insert(juego);
        res.insert(carte);
        
        Producto peliA = new Producto(123456,1,"Shrek",2001,1);
        Producto juegoA = new Producto(987654,2,"Halo 5",2015,2);
        Producto carteA = new Producto(817263,3,"Star Wars",2019,3);
        
        res.insertAlquiler(peliA);
        res.insertAlquiler(juegoA);
        res.insertAlquiler(carteA);
        
        
    }
}
