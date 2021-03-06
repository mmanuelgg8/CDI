/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena,julio y nico
 */
@Named(value = "mostrarProyectos")
@SessionScoped
public class mostrarProyectos implements Serializable{
    private List<Proyecto> proyectos;
    private List<Actividad>actividades;
    @Inject
    private ControlAutorizacion ctrl;

    //Datos para crearProyecto()
    private String nombre;
    private String requisitos;
    
    
    public mostrarProyectos() {
        proyectos= new ArrayList<>();
        actividades=new ArrayList<>();
        ONG ong = new ONG("Málaga","www.ong-malaga.es","ong-malaga","malaga@ong.es",777777771,"mlgong","mlgong");
        Actividad a1 = new Actividad("Actividad1","conocimientos sobre vacunas",(new Date(2020,06,03)),true,1,"Marbella","actividad de mañana","vacunar a los niños en centros escolares",ong);
        Actividad a2 = new Actividad("Actividad2"," no hace falta ningún conocimiento para realizar la actividad",(new Date(2020,02,06)),true,0,"Madrid","actividad de tarde","ayudar a los necesitados ",ong);
        actividades.add(a1);
        actividades.add(a2);
        Proyecto p1 = new Proyecto("Proyecto1","conocimientos básicos de cuidados intensivos",new Date(2020,06,05),true);
        p1.setListaActividades(actividades);
        proyectos.add(p1); 
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public String eliminar(String name){
        Proyecto target = null;
        for(Proyecto p: proyectos){
            if(p.getNombre().equals(name)){
                target = p;
            }
        }
        if(target!=null) proyectos.remove(target);
        return "proyectos.xhtml";
    }
    
    public String crear(){
        Proyecto target = new Proyecto(nombre, requisitos, new Date(2020,06,20) ,true);
        proyectos.add(target);
        return "proyectos.xhtml";
    }
    
    
    
    public void modificar(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or be translated to other class
    }
    
    public String anadir(){
        return "crearProyectos.xhtml";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
    
    
   
    public String lista_proyectos(){  
        
         return ctrl.proyectos();
        
        
    
    }
}
