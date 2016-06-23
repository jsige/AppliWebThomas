/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Genre;
import streaming.service.GenreService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerGenres", urlPatterns = {"/ListerGenres"})
public class ListerGenresServlet extends HttpServlet {

    // inutile, code copié dans AjoutFilmServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        // Recup Liste DB
        
        List <Genre> GenresTrouves = new GenreService().lister();
        
        // Init attributs pour la JSP
        
        req.setAttribute("genres", GenresTrouves);
        
        // Forward vers JSP
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);
    }
    
}
