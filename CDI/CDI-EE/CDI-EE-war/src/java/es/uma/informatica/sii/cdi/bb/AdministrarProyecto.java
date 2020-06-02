/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.modelo.ProyectoException;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elena y julio
 */
@Stateless
public class AdministrarProyecto implements AdministrarProyectoLocal {
    @PersistenceContext(unitName ="CDIPry")
    EntityManager em;

    @Override
    public void crearProyectos(){
        Proyecto p= new Proyecto();
        em.persist(p);
    }
    @Override 
    public void modificarProyectos(Long id,String nombre,String requisitos,Date fecha,boolean estado){
        Proyecto p= em.find(Proyecto.class, id);
         if( p == null)
            try {
                throw new ProyectoException();
         } catch (ProyectoException ex) {
             Logger.getLogger(AdministrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
         }else{
               if(nombre!=null){
                 p.setNombre(nombre);
             }
             if(requisitos!=null){
                 p.setRequisitos(requisitos);
             }
             if(fecha!=null){
                 p.setFecha(fecha);
             }
             p.setEstado(estado);
         }
         em.refresh(p);
        
    }
    @Override
    public void eliminarProyectos(Long id){
         Proyecto p= em.find(Proyecto.class, id);
        
        if( p == null)
            try {
                throw new ProyectoException();
         } catch (ProyectoException ex) {
             Logger.getLogger(AdministrarProyecto.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        em.remove(p);
        
    }
    

    @Override
    public void mostrarProyectos() {
        List<Proyecto>lista = em.createNamedQuery("mostrarProyectos").getResultList();
        
        for(Proyecto p : lista){
            if(p.getId()!=null){
                println(p.toString());
            }
        }
        
    }
}
