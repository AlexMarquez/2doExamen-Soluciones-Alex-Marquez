/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T107
 */
@Controller
@RequestMapping("/")
public class ControladorCalificacion {
    
 /*
    Creamos el metodo para insertar el alumno
  */   
    
    @RequestMapping(value="/calificacion/{parcial}/{final}/{total}/{id}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable float parcial, @PathVariable float 
            cfinal,@PathVariable float total, @PathVariable int id ){
        String mensajito="nada";
        try{
           DAOCalificacionImpl d= new DAOCalificacionImpl();
            d.agregarCalificacion(new Calificacion(parcial, cfinal, total,new Alumno(id) ));
           mensajito= "Calificacion guardado con exito";
        }catch(Exception  e){
            mensajito="Lo siento pero lo existe ese id de usuario";
        }
        return mensajito;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value="/calificacion", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOAlumnoImpl d=new DAOAlumnoImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosAlumnos());
    }
}









