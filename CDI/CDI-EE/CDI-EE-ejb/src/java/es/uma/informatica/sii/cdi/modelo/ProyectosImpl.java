/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author elena y julio
 */
@Stateless
public class ProyectosImpl implements Proyectos {
    @PersistenceContext(unitName ="CDIPU")
    EntityManager em;

    @Override
    public void crearProyectos(String nombre, String requisitos, Date fecha, boolean estado, Usuario user){
        Proyecto p= new Proyecto(nombre, requisitos, fecha, estado);
        p.setEs_creado_por((PDI) user);
        em.persist(p);
    }
    
    
    @Override 
    public void modificarProyectos(String nombre,String requisitos,Date fecha,boolean estado){
        Proyecto p = null;
        try{
            Query query = em.createNamedQuery("findProyectoByName");
            query.setParameter("pname", nombre);
            p = (Proyecto) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        if( p == null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(ProyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            p.setNombre(nombre);
            p.setRequisitos(requisitos);
            p.setFecha(fecha);
            p.setEstado(estado);
            em.merge(p);
        }
        
    }
    @Override
    public void eliminarProyectos(String nombre){
        Proyecto p = null;
        try{
            Query query = em.createNamedQuery("findProyectoByName");
            query.setParameter("pname", nombre);
            p = (Proyecto) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        
        if( p == null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(ProyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        em.remove(p);
        
    }
    

    @Override
    public List<Proyecto> mostrarProyectos() {
        return em.createNamedQuery("mostrarProyectos").getResultList();
    }

    @Override
    public Proyecto devuelveProyecto(String nombre) {
        Proyecto p = null;
        try{
            Query query = em.createNamedQuery("findProyectoByName");
            query.setParameter("pname", nombre);
            p = (Proyecto) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        return p;
    }
}