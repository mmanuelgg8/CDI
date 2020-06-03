/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Informe;
import es.uma.informatica.sii.cdi.modelo.InformeException;
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
public class AdministrarInformes implements AdministrarInformesLocal {
    @PersistenceContext(unitName ="CDIPU")
    EntityManager em;
    
    @Override
    public void crearInformes(){
        Informe i= new Informe();
        em.persist(i);
    }
    @Override 
    public void modificarInformes(Long id,Date fecha,boolean reportado,String comentario){
        Informe i= em.find(Informe.class, id);
         if( i == null)
            try {
                throw new InformeException();
         } catch (InformeException ex) {
             Logger.getLogger(AdministrarInformes.class.getName()).log(Level.SEVERE, null, ex);
         }else{
             if(fecha!=null){
                i.setFecha(fecha);
            }
            if(comentario!=null){
                i.setComentarios(comentario);
            }
            i.setReportado(reportado);
            em.refresh(i);
         }
         

       
         
        
    }
    @Override
    public void eliminarInformes(Long id){
        Informe i= em.find(Informe.class, id);
         if( i == null)
            try {
                throw new InformeException();
         } catch (InformeException ex) {
             Logger.getLogger(AdministrarInformes.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        em.remove(i);
        
    }

    @Override
    public void mostrarInformes() {
         List<Informe>lista = em.createNamedQuery("mostrarInforme").getResultList();
        
        for(Informe i : lista){
            if(i.getId()!=null){
                println(i.toString());
            }
        }
        
    }

    
}
