/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Informe;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
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
@Named(value = "crdInformes")
@RequestScoped
public class CRDinformes {
    private Informe i;
    private List<Informe>informes;
    public CRDinformes() {
       informes=new ArrayList<>();
      
    }

    public Informe getI() {
        return i;
    }

    public void setI(Informe i) {
        this.i = i;
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }

    

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;
    
     public List<Informe> crearInforme(){
        Informe i = new Informe();
        informes.add(i);
        return informes;
    }

      public String eliminar(Long id){  
         //Delete informe
       
        FacesMessage fm = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
   
        informes=new ArrayList<>();
        informes=ctrl.getInformes();
         try{
             
             for(Informe i: informes){
                 if(i.getId()==id){
                     informes.remove(i);
                     return "informes.xhtml";
                 }
             }
          
         }catch(RuntimeException e){
            fm = new FacesMessage("Ha habido un problema al eliminar el informe . ");
            ctx.addMessage("", fm);
         }
         
         
        return null;  
    }
    
    
    
}
