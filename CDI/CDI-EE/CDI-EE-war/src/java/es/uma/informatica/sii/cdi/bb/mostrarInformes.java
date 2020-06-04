/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.InformesLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena y julio
 */
@Named(value = "mostrarInformes")
@RequestScoped

public class mostrarInformes implements Serializable{
    private Informe i;
    private List<Informe> informes;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    @EJB
    private InformesLocal inf;
    
   
    public mostrarInformes() {
        i = new Informe();
    }

    public Informe getInforme() {
        return i;
    }

    public void setInforme(Informe i) {
        this.i = i;
    }

    public List<Informe> mostrarInformes(){
        return inf.mostrarInformes();
    }
    
   
    public String eliminar(Long id){
        inf.eliminarInformes(id);
        return "informes.xhtml";
    }
    
    public String crear(){
        inf.crearInformes(i.getFecha(),i.isReportado(),i.getComentarios());
        informes.add(i);
        return "informes.xhtml";
    }
    
    public void modificar(Long id,Date fecha, boolean repor, String comentarios){
        
        for(Informe in : informes ){
            if(in.getId()==id){
                in.setFecha(fecha);
                in.setReportado(repor);
                in.setComentarios(comentarios);
            }
        }
        
    }
    
   
    
    public String anadir(){
        return "crearInformes.xhtml";
    }
    
}