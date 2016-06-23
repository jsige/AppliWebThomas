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
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailsFilmServlet", urlPatterns = {"/details_film"})
public class DetailsFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         // Recup id film passé en parametre dans l'URL
         
        /*String idFilm = req.getParameter("id_film");
        
         System.out.println("ID FILM : " + req.getParameter("id_film"));
         */
         
        Long idFilm = Long.parseLong(req.getParameter("id_film"));
                
             
         // Recup Liste DB
         
        Film filmDetailServlet = new FilmService().rechercherDetailsFilm(idFilm);
       
         // Set un attibut du film
         
         req.setAttribute("film", filmDetailServlet);
         
         // Forward vers JSP
         req.getRequestDispatcher("details_film.jsp").forward(req, resp);
         
//         // Recup Liste DB
//        
//        List<Film> filmsTrouves = new FilmService().lister();
//        
//        // Init attributs pour la JSP
//        
//        req.setAttribute("films", filmsTrouves);
//        
//        // Forward vers JSP
//        req.getRequestDispatcher("films_liste.jsp").forward(req, resp);
    }

    

}
