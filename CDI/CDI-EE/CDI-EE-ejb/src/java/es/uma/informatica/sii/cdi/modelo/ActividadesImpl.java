/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Proyecto;
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
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author elena y julio
 */
@Stateless
public class ActividadesImpl implements Actividades {
    @PersistenceContext(unitName ="CDIPU")
    EntityManager em;

   @Override
    public void crearActividades(String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion,ONG ong, PDI pdi){
        Actividad a = new Actividad(nombre, requisitos, fecha, estado, tipo, zona, horario, informacion, ong);
        a.setEs_gestionada(pdi);
        em.persist(a);
        List<Actividad> gestionada = ong.getGestiona();
        gestionada.add(a);
        ong.setGestiona(gestionada);
        em.merge(ong);
    }
    @Override 
    public void modificarActividades(String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion){
        Actividad a = null;
        try{
            Query query = em.createNamedQuery("findActividadByName");
            query.setParameter("aname", nombre);
            a = (Actividad) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        if( a == null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(ActividadesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            a.setNombre(nombre);
            a.setRequisitos(requisitos);
            a.setFecha(fecha);
            a.setEstado(estado);
            a.setTipo(tipo);
            a.setZona(zona);
            a.setHorario(horario);
            a.setInformacion(informacion); 
            em.merge(a);
        }
        
    }
    
    @Override
    public void eliminarActividades(String nombre){
        Actividad a = null;
        try{
            Query query = em.createNamedQuery("findActividadByName");
            query.setParameter("aname", nombre);
            a = (Actividad) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        
        if( a == null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(ProyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        em.remove(a);
        
    }

    @Override
    public List<Actividad> mostrarActividades() {
        return em.createNamedQuery("mostrarActividades").getResultList();
        
    }

    @Override
    public Actividad devuelveActividad(String nombre) {
        Actividad a = null;
        try{
            Query query = em.createNamedQuery("findActividadByName");
            query.setParameter("aname", nombre);
            a = (Actividad) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        return a;
    }
    
    @Override
    public List<ONG> mostrarONGs() {
        return em.createNamedQuery("mostrarONGs").getResultList();
    }
    
}
