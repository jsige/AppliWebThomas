/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreDAO {
    public List <Genre> rechercherTout(){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT g FROM Genre g ORDER BY g.nom").getResultList();
        
    }
    
    public Genre rechercherParId(Long idDuGenre){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Genre.class, idDuGenre);
        
    }
    
    public void ajouter(Genre genre){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(genre);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Genre genre){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(genre);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(Genre genre){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Genre g WHERE g.id=:idgenre").setParameter("idgenre", genre).executeUpdate();
        
        em.getTransaction().commit();
    }
    
}
