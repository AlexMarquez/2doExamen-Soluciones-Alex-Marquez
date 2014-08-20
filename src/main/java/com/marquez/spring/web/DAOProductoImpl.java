/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marquez.spring.web;

import com.marquez.spring.web.*;
import static com.campitos.spring.web.DAO.close;
import static com.campitos.spring.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author T-10A
 */
public class DAOProductoImpl extends DAO {
    
 public void agregarProducto(Producto producto) {
    begin();
    getSession().save(producto);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Producto> buscarTodosProductos() {
        begin();
        Query q = getSession().createQuery("from Producto");
      //  Criteria c=getSession().createCriteria(Producto.class);
        ArrayList<Producto> productos = (ArrayList<Producto>)q.list();
        commit();
        close();
         
return productos; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarProducto(Producto p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un cliente por medio de su Id
         * @param id Este parametro es el Id del cliente que se quiere buscar
         * @return El tipo de retorno es el cliente buscado
         */
  public Producto buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Producto where id = :id");
        q.setInteger("id",id);
        Producto p = (Producto)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  }
