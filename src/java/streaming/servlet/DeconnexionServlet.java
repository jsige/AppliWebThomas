package streaming.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/deconnexion_site"})
public class DeconnexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Cookie c;
        
        // Suppression des cookies
        
        c = new Cookie("login", "");
        c.setMaxAge(0);
        resp.addCookie(c);
        
        c = new Cookie("pass", "");
        c.setMaxAge(0);
        resp.addCookie(c);
        
        c = new Cookie("prenom", "");
        c.setMaxAge(0);
        resp.addCookie(c);
        
        c = new Cookie("role", "");
        c.setMaxAge(0);
        resp.addCookie(c);
        
        resp.sendRedirect("films_liste");
        
    }

}
