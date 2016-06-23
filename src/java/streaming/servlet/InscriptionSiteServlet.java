/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Utilisateur;
import streaming.service.UtilisateurService;

/**
 *
 * @author admin
 */
@WebServlet(name = "InscriptionSiteServlet", urlPatterns = {"/inscription_site"})
public class InscriptionSiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String login = req.getParameter("login");
        String mdp = req.getParameter("pwd");
        String mdpControl = req.getParameter("pwdCtrl");
        String prenom = req.getParameter("prenom");
        String mail = req.getParameter("email");
	
	if(!mdp.equals(mdpControl)){
            this.doGet(req, resp);
        }
        else{
            
            Utilisateur util = new Utilisateur();
            
            util.setLogin(login);
            util.setEmail(mail);
            util.setMdp(mdp);
            util.setPrenom(prenom);
            util.setRoleUtil(Utilisateur.RoleUtil.UTILISATEUR);
            
            UtilisateurService utilS = new UtilisateurService();
            
            utilS.inscriptionUtilisateur(util);
            
            req.getRequestDispatcher("inscription_reussie.jsp").forward(req, resp);
        }
	
    
    }

 

}
