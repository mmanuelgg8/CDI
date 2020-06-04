/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.modelo.Actividades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author saul
 */
@Named(value = "mostrarActividades")
@SessionScoped
public class mostrarActividades implements Serializable{
    private Actividad a;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    @EJB
    private Actividades act;
    
    private List<Actividad> filtro;
    private List<String> nombresFiltro;
    
    //Para el tipo de actividad consideramos que el tipo=0 corresponde con actividad de voluntariado
    //y tipo=1 corresponde con actividd aprendizaje-servicio
    public mostrarActividades() {
        a = new Actividad();
    }

    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public List<Actividad> mostrarActividades(){
        return act.mostrarActividades();
    }
    
    public List<ONG> mostrarONGs(){
        return act.mostrarONGs();
    }

    public String eliminar(String name){
        act.eliminarActividades(name);
        return "actividades.xhtml";
    }
    
    public String crear(){
        PDI admin = (PDI) ctrl.getUsuario();
        act.crearActividades(a.getNombre(), a.getRequisitos(), new Date(), true, 0, a.getZona(), a.getHorario(), a.getInformacion(), a.getONG());
        Actividad activ = act.devuelveActividad(a.getNombre());
        activ.setEs_gestionada(admin);
        return "actividades.xhtml";
    }
    
    public void modificar(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or be translated to other class)
    }
    
    public void inscribir(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or take it and move it SOMEWHERE ELSE?)
    }
    
    public String anadir(){
        return "crearActividades.xhtml";
    }

    public List<Actividad> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Actividad> filtro) {
        this.filtro = filtro;
    }

    public List<String> getNombresFiltro() {
        return nombresFiltro;
    }

    public void setNombresFiltro(List<String> nombresFiltro) {
        this.nombresFiltro = nombresFiltro;
    }
    
}
