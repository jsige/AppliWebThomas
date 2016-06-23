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
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.entity.Pays;
import streaming.entity.Serie;
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.PaysService;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutSerie", urlPatterns = {"/ajouter_serie"})
public class AjoutSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List <Genre> GenresTrouves = new GenreService().lister();
        
        // Init attributs pour la JSP
        
        req.setAttribute("genres", GenresTrouves);
        
        List <Pays> ListeDesPays = new PaysService().listerLesPays();
        
        req.setAttribute("pays", ListeDesPays);
        
        // Forward vers JSP
        req.getRequestDispatcher("ajouter_serie.jsp").forward(req, resp);
    }

    
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String titre = req.getParameter("titre");
        //Integer anneeProd = Integer.parseInt(req.getParameter("anneeProd"));
        String synopsis = req.getParameter("synopsis");
        
        Long genreId = Long.parseLong(req.getParameter("genre"));
        Genre genre = new GenreService().obtenirGenreParId(genreId);
        //String pays = req.getParameter("pays");
        
        Long paysId = Long.parseLong(req.getParameter("pays"));
        Pays pays = new PaysService().obtenirPaysParId(paysId);
        //String prodprnm = req.getParameter("producteur_prenom");
        //String prodnom = req.getParameter("producteur_nom");
        
        //System.out.println("Film : '" + titre + "' produit en " + anneeProd + " de genre " + genre.toString() + " dans le pays " + paysId);
        
        Serie serieAAjouter = new Serie();
        
        serieAAjouter.setTitre(titre);
        //serieAAjouter.setAnnee(anneeProd);
        serieAAjouter.setSynopsis(synopsis);
        serieAAjouter.setGenre(genre);
        genre.getSeries().add(serieAAjouter);
        
        //serieAAjouter.setPays((List<Pays>) pays);
        //pays.getFilmsProduits().add(serieAAjouter);
        
        new SerieService().ajouterSerie(serieAAjouter);
        
        //req.getRequestDispatcher("films_liste").forward(req, resp);
        
        resp.sendRedirect("series_liste");
    }

  
    
}
