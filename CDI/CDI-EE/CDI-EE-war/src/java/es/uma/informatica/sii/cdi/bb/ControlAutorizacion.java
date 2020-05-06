/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nicol
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {
    private Usuario usuario;
    private List<Informe> informes;
    private List<Actividad> actividades;
    private List<Proyecto> proyectos;
    private Informe informe;

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
    

    public String getRol(){
        if(usuario instanceof PDI){
            return "PDI";
        }else if(usuario instanceof PAS){
            return "PAS";
        }else if(usuario instanceof Alumno){
            return "ALUMNO";
        }else if(usuario instanceof ONG){
            return "ONG";
        }
        return null;
    }
    
    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
    
    
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    

    public String home() {
        /*
        if(usuario instanceof PDI ){
            PDI aux = (PDI) usuario;
            if(aux.isRol_gestor()){
                return "homeGestor.xhtml";
            }else{
                return "home.xhtml";
            }
        }else{
            return "home.xhtml";
        }
        */
        return "index.xhtml";
    }
 
    public String actividades(){
        return "actividades.xhtml";
    }
    public String proyectos(){
        return "proyectos.xhtml";
    }
    public String informes(){
        return "informes.xhtml";
    }
    public String inscripciones(){
        return "inscripciones.xhtml";
    }
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
