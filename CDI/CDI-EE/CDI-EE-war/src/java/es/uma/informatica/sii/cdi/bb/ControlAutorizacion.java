/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {
    private Usuario usuario;
    private List<Informe> informes;
    private List<Actividad> actividades;
    private List<Proyecto> proyectos;
    private Informe informe;
    
    @EJB
    private CDI cdi;
    
     /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }

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
    
    public boolean getRol_gestor(){
        if(usuario instanceof PDI){
            PDI u = (PDI) usuario;
            return u.isRol_gestor();
        }
        return false;
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
    
    // Estos metodos han sido trasladados desde el antiguo EditarPerfil.java
    // Al trasladar estos metodos aqui espero poder mejorar la pagina web correspondiente
    
    public String guardarCambios(){
        try {
            cdi.modificarUsuario(usuario);
            setUsuario(cdi.refrescarUsuario(usuario));
            return home();
        } catch (CDIException ex) {
            FacesMessage fm = new FacesMessage("Fallo en modificacion");
            FacesContext.getCurrentInstance().addMessage("modPerfil:user", fm);
            return null;
        }
        /*
        Usuario u=ctrl.getUsuario();
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        u.setNombre(nombre);
        u.setTelefono(telefono);
        */        
    }
    
    public String eliminarUser(){
        try{
            cdi.eliminarUsuario(usuario);
            return logout();
        } catch (CDIException ex) {
            FacesMessage fm = new FacesMessage("Fallo en eliminacion");
            FacesContext.getCurrentInstance().addMessage("modPerfil:user", fm);
            return null;
        }
    }
    
    public String solicitaGestor(){
        try{
            cdi.solicitaCode(usuario);
            setUsuario(cdi.refrescarUsuario(usuario));
            return null;
        } catch (CDIException ex) {
            FacesMessage fm = new FacesMessage("Fallo en solicitud");
            FacesContext.getCurrentInstance().addMessage("modPerfil:user", fm);
            return null;
        }
    }
    
}
