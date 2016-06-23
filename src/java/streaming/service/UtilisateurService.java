/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.UtilisateurDAO;
import streaming.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurService {

    public Utilisateur connexionSite(String login, String pass) {
       UtilisateurDAO dao = new UtilisateurDAO();
        
        return dao.connexionSite(login,pass);
    }
    
   public void inscriptionUtilisateur(Utilisateur util){
       
       UtilisateurDAO dao = new UtilisateurDAO();
       
        // VALIDATION

        // Throw exception si login existe
       
       List <Utilisateur> listeUtilAvecCeLogin = dao.rechercherParLogin(util.getLogin());
       
       if (listeUtilAvecCeLogin.size() > 0){
            throw new RuntimeException("Ce login existe déjà");
       }
       
       List <Utilisateur> listeUtilAvecCetEmail = dao.rechercherParEmail(util.getEmail());
       
       if (listeUtilAvecCetEmail.size() > 0){
            throw new RuntimeException("Cet email existe déjà");
       }
       
       // Passe l'utilisateur à l'état NON VALIDE
       
       util.setEtatUtil(Utilisateur.EtatUtil.NONVALIDE);
       
       // Persite
       
       dao.ajouter(util);
       
       
       // Envoyer un email
       
       EmailService ms = new EmailService();
       
       ms.envoyerEmail(util.getEmail(),"Objet","Message");
       
       
   }
       
       
       
       
   
}
