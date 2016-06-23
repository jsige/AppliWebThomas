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
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailsSerieServlet", urlPatterns = {"/details_serie"})
public class DetailsSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         // Recup id film passé en parametre dans l'URL
         
        /*String idFilm = req.getParameter("id_film");
        
         System.out.println("ID FILM : " + req.getParameter("id_film"));
         */
         
        Long idSerie = Long.parseLong(req.getParameter("serie_id"));
                
             
         // Recup Liste DB
         
        Serie serieDetailServlet = new SerieService().rechercherDetailsSerie(idSerie);
       
         // Set un attibut du film
         
         req.setAttribute("serie", serieDetailServlet);
         
         // Forward vers JSP
         req.getRequestDispatcher("details_serie.jsp").forward(req, resp);
         
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
