/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.modelo.ActividadException;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author elena y julio
 */
@Stateless
public class AdministrarActividades implements AdministrarActividadesLocal {
    @PersistenceContext(unitName ="CDIPU")
    EntityManager em;

   @Override
    public void crearActividades(){
        Actividad a= new Actividad();
        em.persist(a);
    }
    @Override 
    public void modificarActividades(Long id,String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion){
        Actividad a= em.find(Actividad.class, id);
         if( a == null)
            try {
                throw new ActividadException();
         } catch (ActividadException ex) {
             Logger.getLogger(AdministrarActividades.class.getName()).log(Level.SEVERE, null, ex);
         }else{
             if(nombre!=null){
                 a.setNombre(nombre);
             }
             if(requisitos!=null){
                 a.setRequisitos(requisitos);
             }
             if(fecha!=null){
                 a.setFecha(fecha);
             }
             a.setEstado(estado);
             a.setTipo(tipo);
             if(zona!=null){
                 a.setZona(zona);
             }
             if(horario!=null){
                 a.setHorario(horario);
             }
             if(informacion!=null){
                 a.setInformacion(informacion);
             }
             
         }
         em.refresh(a);
        
    }
    @Override
    public void eliminarActividades(Long id){
        Actividad a= em.find(Actividad.class, id);
         if( a == null)
            try {
                throw new ActividadException();
         } catch (ActividadException ex) {
             Logger.getLogger(AdministrarActividades.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        em.remove(a);
        
    }

    @Override
    public void mostrarActividades() {
        List<Actividad>lista = em.createNamedQuery("mostrarActividad").getResultList();
        
        for(Actividad a : lista){
            if(a.getId()!=null){
                println(a.toString());
            }
        }
        
    }
}

