/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
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

    
    public mostrarInscripciones() {
        inscripciones= new ArrayList<>();
        
        Inscripcion  i1 = new Inscripcion(new Date(2020,06,07),false);
        Inscripcion  i2 = new Inscripcion(new Date(2020,04,03),true);
        inscripciones.add(i1);
        inscripciones.add(i2);
        
       
    }

    public String lista_inscripciones(){  //
        
         return ctrl.inscripciones();
        
        
        
    } 
    
}
