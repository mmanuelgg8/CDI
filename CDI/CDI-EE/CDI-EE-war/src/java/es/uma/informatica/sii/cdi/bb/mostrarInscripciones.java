/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */
@Named(value = "mostrarInscripciones")
@RequestScoped
public class mostrarInscripciones {
    @EJB
    private CDI cdi;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    private List<Inscripcion> inscripciones;
    
    public mostrarInscripciones(){
        
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    public List<Inscripcion> mostrarInscripciones() {
        return cdi.mostrarInscripciones(ctrl.getUsuario()); 
    }
    
    public String inscribir(Actividad a, Usuario u){
        try {
            cdi.inscribirUsuario(a,u);
            ctrl.setUsuario(cdi.refrescarUsuario(u));
        } catch (CDIException ex) {
            Logger.getLogger(mostrarInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "actividades.xhtml";
    }

    public boolean noInscritoEn(String a){
        //System.out.println("Nombre es " + a);
        return !cdi.estaInscrito(a, ctrl.getUsuario());
    }
    
    public String lista_inscripciones(){  //
        
         return ctrl.inscripciones();   
    } 
    
    public void eliminarInscripcion(Inscripcion i){
        cdi.eliminarInscripcion(i);
    }
}
