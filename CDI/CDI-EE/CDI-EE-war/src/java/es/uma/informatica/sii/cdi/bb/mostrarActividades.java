/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
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
@Named(value = "mostrarActividades")
@RequestScoped

public class mostrarActividades {


    private List<Actividad> actividades;

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    
     
    //Para el tipo de actividad consideramos que el tipo=0 corresponde con actividad de voluntariado
    //y tipo=1 corresponde con actividd aprendizaje-servicio
    public mostrarActividades() {
        actividades= new ArrayList<>();
        
        Actividad a1 = new Actividad("Actividad1","conocimientos sobre vacunas",(new Date(03/06/2020)),true,1,"Marbella","actividad de mañana","vacunar a los niños en centros escolares");
        Actividad a2 = new Actividad("Actividad2"," no hace falta ningún conocimiento para realizar la actividad",(new Date(06/02/2020)),true,0,"Madrid","actividad de tarde","ayudar a los necesitados ");
        actividades.add(a1);
        actividades.add(a2);
        
       
    }

    public String lista_actividades(){  //
        
         return ctrl.actividades();
        
        
        
    }  
    
}
