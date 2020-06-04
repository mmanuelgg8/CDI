/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elena, Julio y Manuel
 */
@Named(value = "mostrarInformes")
@RequestScoped
public class mostrarInformes {
    private Informe i;

    private List<Informe> informes;
    @Inject
    private CDI cdi;
    @Inject
    private ControlAutorizacion ctrl;

    public Informe getI() {
        return i;
    }

    public void setI(Informe i) {
        this.i = i;
    }
    
    public List<Informe> mostrarInformes(Inscripcion i) {
        return cdi.mostrarInformes(i);
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
 
    public String anadir(){      
        return "crearInformes.xhtml";
    }
    
    public String anadirInforme(){
        cdi.crearInformes(new Date(), i.isReportado(),i.getComentarios());
        return "informes.xhtml";
    }
    
    public void eliminar(Informe i){
        cdi.eliminarInforme(i);
    }

    public String lista_informes(){  //
        
         return ctrl.informes();
        
        
        
    }  
    
}
