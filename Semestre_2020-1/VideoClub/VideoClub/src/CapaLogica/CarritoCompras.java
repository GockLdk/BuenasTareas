/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.RegistroClientes;
import CapaDatos.RegistroProductos;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author mario
 */
// CARRITO DE COMPRAS QUE HEREDA TODO DE PRODUCTOS YA QUE LOS LLEGA A OCUPAR.
public class CarritoCompras extends RegistroProductos 
{
    public Usuario usuario; // TIENE UN USUARIO QUE ES EL USUARIO QUE ESTA LOGEADO
    public RegistroClientes res; // UN REGISTRO DE CLIENTE PARA ACUTIALIZAR LOS DATOS CUANDO ALQUILA Y DEVULEVE PRODUCTSO
    public ArrayList<Producto> carrito; // lISTA DE PRODUCTSO DEL CARIITO
    
    public CarritoCompras(Usuario user)
    {
        this.usuario = user;
        this.res = new RegistroClientes();
        this.carrito = new ArrayList<>();
    }
    // COMPRAR 
    public void comprarCarrito() throws IOException
    {
       // rECORRE EL CARRITO
        for(Producto pro : this.carrito)
        {
            // lOS AGREGA A LA LISTA DE ALUILAR DEL USUARIO
            Producto produ = new Producto(pro.getCodigo(),pro.getTipo(),pro.getNombre(),pro.getCreacion(),pro.getExistencia());
            this.usuario.alquilados.add(produ);
        }
        // ACTUALIZA LA INFO DEL USUARIO
        this.res.insert(this.usuario);
        // iNSERTA EN LAS CARPTEAS ALQUILER TODOS LOS PRODUCTOS QUE TIENE ALQUILADO EL USUARIO
        for(Producto pro : this.usuario.alquilados)
        {
            this.insertAlquiler(pro);
        }
        this.carrito.clear(); // lIMPIA AL FINAL EL CARRITO
        
    }
    // deVOLVER PRODUCYO
    public Producto devolverProducto(int indice)
    {
        // OBTIENE EL PRODUCTO SEGUN SU INDICE SACADO DE LA LISTA
        Producto pro = this.usuario.alquilados.get(indice);
        this.usuario.alquilados.remove(indice); // LO REMUEVE DE SU LISTA
        return pro; // DEVULEVE EL PRODUCTO
    }
    
    //aGREGAR
    public void agregarCarrito(Producto pro,int num) throws IOException
    {
        // hACE LA DIFERENCIA DE LOS DE STOCK Y LOS QUE SE VAN A  ALQUILAR
        int restante = pro.getExistencia() - num;
        
        
        Producto produ = new Producto(pro.getCodigo(),pro.getTipo(),pro.getNombre(),pro.getCreacion(),num); // CREA NUEVO PRODUCTO CON LOS MISMOS DATOS PERO CON LOS NUMERO QUE SE VAN A ALQUILAR
        
        this.carrito.add(produ); // aGREGA AL CARIITO
        
        // aCTUALIZA LA EXISTENCIA EN STOCK
        pro.setExistencia(restante); 
        this.insert(pro);
       
    }
    // bORRAR
    public Producto borrarCarrito(int indice)
    {
        // rEMUVE EL PRODUCTO DEL CARRITO SEGUN SU INDICE EN LA LISTA
        Producto pro = this.carrito.get(indice);
        this.carrito.remove(indice); // eLIMINA EL PRODUCTO
        return pro; // DEVUELEVE EL PRODCUTO ELIMINADO
    }
    // DEVUELVE EL MODEL PARA LA LISTA DEL CARRITO
    public DefaultListModel actualizarJListCarrito()
    {
        DefaultListModel model = new DefaultListModel();
        for (Producto pro : this.carrito)
        {
            String tipo = "";
            switch(pro.getTipo())
            {
                case 1:
                    tipo = "Pelicula";
                break;
                
                case 2:
                    tipo = "Videojuego";
                break;
                
                case 3:
                    tipo = "Cartelera";
                break;
            }
            String info =  pro.getCodigo() + "       " + pro.getTipo() + "       " + pro.getNombre() + "       " + pro.getExistencia();
            model.addElement(info);
            
        }
        return model;
    }
    // DEVULEVE MODEL PARA LA LISTA DE ALQUILADOS DEL USUARIO
    public DefaultListModel actualizarJListAlquilados()
    {
        DefaultListModel model = new DefaultListModel();
        for (Producto pro : this.usuario.alquilados)
        {
            String tipo = "";
            switch(pro.getTipo())
            {
                case 1:
                    tipo = "Pelicula";
                break;
                
                case 2:
                    tipo = "Videojuego";
                break;
                
                case 3:
                    tipo = "Cartelera";
                break;
            }
            String info =  pro.getCodigo() + "       " + tipo + "       " + pro.getNombre() + "        " + pro.getExistencia();
            
            model.addElement(info);
            
        }
        return model;
    }
    
}
