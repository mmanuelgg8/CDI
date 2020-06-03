/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author elena y julio
 */
@Named(value = "crudActividades")
@RequestScoped
public class CRUDactividades {
    
    
    private Actividad a;
    private List<Actividad>actividades;
    public CRUDactividades() {
        //Create actividad
        a=new Actividad();
      
    }


    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    
    public String editar(Long id)  {  
        //Update actividad
        
        FacesMessage fm = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        actividades=new ArrayList<>();
        actividades=ctrl.getActividades();
        
         try{
             
             for(Actividad a1: actividades){
                 if(a1.getId()==id){
                    a1.setFecha(a.getFecha());
                    a1.setHorario(a.getHorario());
                    a1.setInformacion(a.getInformacion());
                    a1.setNombre(a.getNombre());
                    a1.setRequisitos(a.getRequisitos());
                    a1.setTipo(a.getTipo());
                    a1.setZona(a.getZona());
                     return "actividades.xhtml";
                 }
             }
          
         }catch(RuntimeException e){
            fm = new FacesMessage("Ha habido un problema al eliminar la actividad. ");
            ctx.addMessage("", fm);
         }
         
         
        return null;  
    
        
    }
    
    public String eliminar(Long id){  
         //Delete actividad
       
        FacesMessage fm = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
   
        actividades=new ArrayList<>();
        actividades=ctrl.getActividades();
         try{
             
             for(Actividad a: actividades){
                 if(a.getId()==id){
                     actividades.remove(a);
                     return "actividades.xhtml";
                 }
             }
          
         }catch(RuntimeException e){
            fm = new FacesMessage("Ha habido un problema al eliminar la actividad. ");
            ctx.addMessage("", fm);
         }
         
         
        return null;  
    }
        
}