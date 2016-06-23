/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieDAO {
    
    public List<Serie> rechercherTout(){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT s FROM Serie s").getResultList();
        
    }
    
    public Serie rechercheParId(Long idSerieCheerchee){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Serie.class, idSerieCheerchee);
    }

    public void ajouter(Serie serieAAjouter) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(serieAAjouter);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Serie serie){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(serie);
        
        em.getTransaction().commit();
        
    }
    
    public void supprimer(Long idSerie){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        Query q = em.createQuery("DELETE FROM Serie s WHERE s.id=:id");
        
        q.setParameter("id", idSerie);
        
        q.executeUpdate();
        
        em.getTransaction().commit();
      
    }
            
    
    
}
