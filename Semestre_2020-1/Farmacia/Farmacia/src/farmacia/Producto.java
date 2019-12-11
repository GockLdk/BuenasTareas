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
// CLASE PRODUCTO CON LO CORRESPONDIENTE A ELLA
public class Producto{
    
    private int clave;
    private String des;
    private int exis;
    private double precio;
    
    public Producto(int clave, String des, int exis, double precio)
    {
        this.clave = clave;
        this.des = des;
        this.exis = exis;
        this.precio = precio;
    }
    
    public void setClave(int clave)
    {
        this.clave = clave;
    }
    
    public int getClave()
    {
        return this.clave;
    }
    
    public void setDescrip(String des)
    {
        this.des = des;
    }
    
    public String getDescrip()
    {
        return this.des;
    }
    
    public void setExis(int exis)
    {
        this.exis = exis;
    }
    
    public int getExis()
    {
        return this.exis;
    }
    
    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    
    public double getPrecio()
    {
        return this.precio;
    }
    
    public void aumentarExis(int aum)
    {
        this.exis += aum;
    }
    
    public void reducirExis(int red)
    {
        this.exis -= red;
    }
    
     @Override
    public String toString() {
        return "Clave: " + this.clave
                + "\nDescripcion: " + this.des
                + "\nExistencia: " + this.exis
                + "\nPrecio Unitario: " + this.precio;
    }
    
}
