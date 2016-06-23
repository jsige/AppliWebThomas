/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienDAO {
    
    public List <Lien> rechercherTout(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT l FROM Lien l").getResultList();
    }
    
    public Lien rechercherParId(Long idSerie){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Lien.class, idSerie);
    }
    
    public void ajouter(Lien lien){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(lien);
        
        em.getTransaction().commit();
        
    }
    
    public void modifier(Lien lien){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(lien);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(Lien lien){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Lien l WHERE l.id=:id").setParameter("id", lien.getId()).executeUpdate();
        
        em.getTransaction().commit();
        
    }
    
    
}
