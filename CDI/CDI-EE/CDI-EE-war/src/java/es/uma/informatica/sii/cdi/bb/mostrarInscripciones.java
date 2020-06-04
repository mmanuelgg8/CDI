/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.CDI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena y julio 
 */
@Named(value = "mostrarInscripciones")
@RequestScoped
public class mostrarInscripciones {
    @Inject
    private CDI cdi;
    private List<Inscripcion> inscripciones;

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    
    public List<Inscripcion> mostrarInscripciones() {
        return cdi.mostrarInscripciones();
        
       
    }

    public boolean inscritoEn(Actividad a, Usuario u){
        return cdi.estaInscrito(a,u);
    }
    
    public String lista_inscripciones(){  //
        
         return ctrl.inscripciones();
        
        
        
    } 
    
}
