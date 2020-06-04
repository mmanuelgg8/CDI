/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import es.uma.informatica.sii.cdi.modelo.Proyectos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */
@Named(value = "mostrarProyectos")
@SessionScoped
public class mostrarProyectos implements Serializable{
    private Proyecto p;
    @Inject
    private ControlAutorizacion ctrl;
    @EJB
    private Proyectos projects;
    @EJB
    private CDI cdi;

    public Proyecto getP() {
        return p;
    }

    public void setP(Proyecto p) {
        this.p = p;
    }
    
    public mostrarProyectos() {
        p = new Proyecto();
    }

    public List<Proyecto> mostrarProyectos(){
        return projects.mostrarProyectos();
    }
    
    public String eliminar(String name){
        try {
            projects.eliminarProyectos(name);
            PDI creator = (PDI) ctrl.getUsuario();
            List<Proyecto> creados = creator.getCrea();
            creados.remove(new Proyecto(name, "", new Date(), true));
            creator.setCrea(creados);
            cdi.modificarUsuario(creator);
        } catch (CDIException ex) {
            Logger.getLogger(mostrarProyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "proyectos.xhtml";
    }
    
    public String anadirProyecto(){
        try {
            projects.crearProyectos(p.getNombre(), p.getRequisitos(), new Date(), p.isEstado(), ctrl.getUsuario());
            PDI creator = (PDI) ctrl.getUsuario();
            List<Proyecto> creados = creator.getCrea();
            creados.add(projects.devuelveProyecto(p.getNombre()));
            creator.setCrea(creados);
            cdi.modificarUsuario(creator);
        } catch (CDIException ex) {
            Logger.getLogger(mostrarProyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "proyectos.xhtml";
    }
  
    public void modificar(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or be translated to other class
    }
    
    public String anadir(){
        return "crearProyectos.xhtml";
    }
    
   
    public String lista_proyectos(){  
        
         return ctrl.proyectos();
        
        
    
    }
}
