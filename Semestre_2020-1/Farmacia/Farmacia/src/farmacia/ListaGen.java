/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 * @param <T>
 */
public class ListaGen<T>  {
    public List<T> list = new ArrayList<>();
    
    public void actualizar(List <T> t){
        list = t;
    }
    
    public void agregar(T t){
        list.add(t);
    }
    
    public static  void main(String[] args) {
        new ListaGen<String>().agregar("abc");
    }
}
