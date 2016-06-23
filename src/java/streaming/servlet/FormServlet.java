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

/**
 *
 * @author admin
 */
@WebServlet(name = "FormServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        // Recup Données
       
        String titre = req.getParameter("titre");
        long anneeProd = Long.parseLong(req.getParameter("anneeProd"));
        String genre = req.getParameter("genre");
        String pays = req.getParameter("pays");
        
        System.out.println("Film : '" + titre + "' produit en " + anneeProd + " de genre " + genre + " dans le pays " + pays);
        
    }

    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        // Renvoyer vers la JSP "form.jsp"
        
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

  

}
