/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.Inscripcion;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.modelo.Actividades;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.Proyectos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */
@Named(value = "mostrarActividades")
@RequestScoped
public class mostrarActividades implements Serializable{
    private Actividad a;
    
    @Inject
    private ControlAutorizacion ctrl;

    @EJB
    private Actividades act;
    
    @EJB
    private Proyectos pros;
    
    private List<Actividad> filtro;
    private List<String> nombresFiltro;
    private String nameONG;
    private String namePRO;
    
    //Para el tipo de actividad consideramos que el tipo=0 corresponde con actividad de voluntariado
    //y tipo=1 corresponde con actividd aprendizaje-servicio
    public mostrarActividades() {
        a = new Actividad();
    }

    public String getNamePRO() {
        return namePRO;
    }

    public void setNamePRO(String namePRO) {
        this.namePRO = namePRO;
    }

    public String getNameONG() {
        return nameONG;
    }

    public void setNameONG(String nameONG) {
        this.nameONG = nameONG;
    }
    
    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public List<Actividad> mostrarActividades(){
        return act.mostrarActividades(ctrl.getUsuario());
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
        ONG ong = act.devuelveONG(nameONG);
        Proyecto pro = pros.devuelveProyecto(namePRO);
        act.crearActividades(a.getNombre(), a.getRequisitos(), new Date(), true, 0, a.getZona(), a.getHorario(), a.getInformacion(), ong, admin, pro);
        return "actividades.xhtml";
    }
    
    public void modificar(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or be translated to other class)
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
