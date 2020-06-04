/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Informe;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author elena y julio
 */
@Stateless
@LocalBean
public class InformesImpl implements InformesLocal {
    @PersistenceContext(unitName ="CDIPU")
    EntityManager em;

   @Override
    public void crearInformes(Date fecha, boolean repor, String comentarios){
        Informe i = new Informe(fecha,repor,comentarios);
        em.persist(i);
    }
    @Override 
    public void modificarInformes(Long id,Date fecha, boolean repor, String comentarios){
        Informe i = null;
        try{
            Query query = em.createNamedQuery("findInformedById");
            query.setParameter("informeId",id );
            i = (Informe) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        if( i== null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(InformesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            i.setComentarios(comentarios);
            i.setFecha(fecha);
            i.setReportado(repor);
            em.merge(i);
        }
        
    }
    
    @Override
    public void eliminarInformes(Long id){
        Informe i = null;
        try{
            Query query = em.createNamedQuery("findInformeById");
            query.setParameter("iformeId", id);
            i = (Informe) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        
        if( i == null){
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(InformesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        em.remove(i);
        
    }

    @Override
    public List<Informe> mostrarInformes() {
        return em.createNamedQuery("mostrarInformes").getResultList();
        
    }

    @Override
    public Informe devuelveInformes(Long id) {
        Informe i = null;
        try{
            Query query = em.createNamedQuery("findInformeById");
            query.setParameter("informeId", id);
            i = (Informe) query.getSingleResult();
        } catch (NoResultException e){
            
        }
        return i;
    }

   
    
   
    

}
