/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author mmanu
 */
public class CDI {
    public static void main(String[] args){
        
        Alumno al1 = new Alumno();
        Alumno al2 = new Alumno();
        
        al1.id=6L;
        al2.id=7L;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CDIPU");
        EntityManager em = emf.createEntityManager();
        // 3-Persists the book to the database
        
        EntityTransaction tx = em.getTransaction();
       
        tx.begin();
        em.persist(al1);
        em.persist(al2);
        tx.commit();
       
        em.close();
        emf.close();
        
        
    }
}
