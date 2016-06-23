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
import streaming.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurDAO {

    public Utilisateur connexionSite(String login, String pass) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
//        Object result = em.createQuery("SELECT ut FROM Utilisateur ut WHERE ut.login = '" + login +"' AND ut.mdp = '"+ pass + "'").getSingleResult();
//        
//        System.out.println("---------------------------> Résultat requête : " + result);
//        return (Utilisateur) result;
    
        // Méthode Thomas :
        Query q1 = em.createQuery("SELECT ut FROM Utilisateur ut WHERE ut.login=:login AND ut.mdp=:pass AND ut.etatUtil=:etatU");
        q1.setParameter("login", login);
        q1.setParameter("pass", pass);
        q1.setParameter("etatU", Utilisateur.EtatUtil.VALIDE);
        return (Utilisateur) q1.getSingleResult();
        
    }

    public List <Utilisateur> rechercherParLogin(String login) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login")
                .setParameter("login", login).getResultList();
        
        
        
    }

    public List<Utilisateur> rechercherParEmail(String email) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:mail").setParameter("mail", email).getResultList();
    }
    
    public void ajouter(Utilisateur util){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(util);
        
        em.getTransaction().commit();
        
    }
}
