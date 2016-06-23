/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "HomePageServlet", urlPatterns = {"/home"})
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Sortie vers Console
        System.out.println("**** passe par ici ****");
        
        // Créer un attribut à envoyer à la JSP (html)
        
        req.setAttribute("titre", "Bonjour tout le monde");
        
        req.setAttribute("dateJour", new Date());
        
        
        
        // Renvoi à JSP home.jsp
        
        req.getRequestDispatcher("home.jsp").forward(req, resp); 
        
        
    }
    
    
     
    
}
