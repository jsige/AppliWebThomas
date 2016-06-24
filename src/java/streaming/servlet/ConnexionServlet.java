/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Utilisateur;
import streaming.service.UtilisateurService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion_site"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
         
         String pass = req.getParameter("pwd");
         
         //System.out.println(login + " " + pass);
         
        Utilisateur util =  new UtilisateurService().connexionSite(login,pass); 
        
        //req.setAttribute("utilisateurlogge", util); Version cookies
       //req.getRequestDispatcher("connexion_reusssie").forward(req, resp);
        
       req.getSession().setAttribute("utilconnecte", util);
       
//       resp.addCookie(new Cookie("login", util.getLogin()));
//       resp.addCookie(new Cookie("pass", util.getMdp()));
//       resp.addCookie(new Cookie("prenom", util.getPrenom()));
//       resp.addCookie(new Cookie("role", util.getRoleUtil().toString()));  Version cookies
        
        resp.sendRedirect("connexion_reusssie?msg=Bravo%20"+util.getLogin());     //OK pour envoi vers Requete doGet
        
        
        //req.getRequestDispatcher("films_liste").forward(req, resp);
    }
    
    
   

}
