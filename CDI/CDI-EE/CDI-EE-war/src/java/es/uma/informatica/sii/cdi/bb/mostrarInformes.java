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
@Named(value = "mostrarInformes")
@RequestScoped
public class mostrarInformes {
    
    private List<Informe> informes;
    
    @Inject
    private ControlAutorizacion ctrl;

    public mostrarInformes() {
        informes= new ArrayList<>();
        
        Informe  i1 = new Informe(new Date(2020,06,07),false, "no ha cumplido su tarea");
        Informe  i2 = new Informe(new Date(2020,04,03),true,"el voluntario ha realizado las actividades correctamente");
        informes.add(i1);
        informes.add(i2);
        
       
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
 
    public void anadir(){
        //TO BE MADE WITH THE BBDD IMPLEMENTATION
    }
    
    public void eliminar(){
        //TO BE MADE WITH THE BBDD IMPLEMENTATION
    }

    public String lista_informes(){  //
        
         return ctrl.informes();
        
        
        
    }  
    
}
