/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.modelo.CDI;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena y julio
 */
@Named(value = "crudProyectos")
@RequestScoped
public class CRUDproyectos {
    private Proyecto p;
    private List<Proyecto>proyectos;
    
    @Inject
    private CDI cdi;
    
    public CRUDproyectos() {
        //Create proyecto
        p=new Proyecto();
      
    }

    public Proyecto getP() {
        return p;
    }

    public void setP(Proyecto p) {
        this.p = p;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


   

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    
    /*public String editar(Long id)  {  
        //Update actividad
        
        FacesMessage fm = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        proyectos=new ArrayList<>();
        proyectos=ctrl.getProyectos();
        
         try{
             
             for(Proyecto p1: proyectos){
                 if(p1.getId()==id){
                    p1.setFecha(p.getFecha());
                    p1.setNombre(p.getNombre());
                    p1.setListaActividades(p.getListaActividades());
                    p1.setRequisitos(p.getRequisitos());
                    
                     return "proyectos.xhtml";
                 }
             }
          
         }catch(RuntimeException e){
            fm = new FacesMessage("Ha habido un problema al eliminar el proyecto. ");
            ctx.addMessage("", fm);
         }
         
         
        return null;  
    
        
    }*/
    
    public String eliminar(Long id){  
         //Delete proyecto
       
        FacesMessage fm = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
   
        proyectos=new ArrayList<>();
        proyectos=ctrl.getProyectos();
         try{
             
             for(Proyecto p: proyectos){
                 if(p.getId()==id){
                     proyectos.remove(p);
                     return "proyectos.xhtml";
                 }
             }
          
         }catch(RuntimeException e){
            fm = new FacesMessage("Ha habido un problema al eliminar el proyecto . ");
            ctx.addMessage("", fm);
         }
         
         
        return null;  
    }
    
}
