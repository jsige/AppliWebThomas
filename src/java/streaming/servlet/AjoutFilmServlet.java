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
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.PaysService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutFilm", urlPatterns = {"/ajouter_film"})
public class AjoutFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List <Genre> GenresTrouves = new GenreService().lister();
        
        // Init attributs pour la JSP
        
        req.setAttribute("genres", GenresTrouves);
        
        List <Pays> ListeDesPays = new PaysService().listerLesPays();
        
        req.setAttribute("pays", ListeDesPays);
        
        // Forward vers JSP
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);
    }

    
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String titre = req.getParameter("titre");
        Integer anneeProd = Integer.parseInt(req.getParameter("anneeProd"));
        String synopsis = req.getParameter("synopsis");
        
        Long genreId = Long.parseLong(req.getParameter("genre"));
        Genre genre = new GenreService().obtenirGenreParId(genreId);
        //String pays = req.getParameter("pays");
        
        Long paysId = Long.parseLong(req.getParameter("pays"));
        Pays pays = new PaysService().obtenirPaysParId(paysId);
        //String prodprnm = req.getParameter("producteur_prenom");
        //String prodnom = req.getParameter("producteur_nom");
        
        //System.out.println("Film : '" + titre + "' produit en " + anneeProd + " de genre " + genre.toString() + " dans le pays " + paysId);
        
        Film filmAAjouter = new Film();
        
        filmAAjouter.setTitre(titre);
        filmAAjouter.setAnnee(anneeProd);
        filmAAjouter.setSynopsis(synopsis);
        filmAAjouter.setGenre(genre);
        genre.getFilms().add(filmAAjouter);
        
        filmAAjouter.setPays((List<Pays>) pays);
        pays.getFilmsProduits().add(filmAAjouter);
        
        new FilmService().ajouterFilm(filmAAjouter);
        
        //req.getRequestDispatcher("films_liste").forward(req, resp);
        
        resp.sendRedirect("films_liste");
    }

  
    
}
