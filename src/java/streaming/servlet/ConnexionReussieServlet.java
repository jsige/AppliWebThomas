/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
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
@WebServlet(name = "ConnexionReussieServlet", urlPatterns = {"/connexion_reusssie"})
public class ConnexionReussieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String testMsg = req.getParameter("msg");
        req.setAttribute("msg_yoyo", testMsg);
        req.getRequestDispatcher("connexion_reussie.jsp").forward(req, resp); //fonctionne mais n'affiche pas le message "Bravo..."

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       
//       
//        //resp.sendRedirect("connexion_reusssie");
//        
//        
//        //req.getRequestDispatcher("films_liste").forward(req, resp);
//    }
}
