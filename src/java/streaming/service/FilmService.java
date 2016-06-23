/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {
    
    public List<Film> lister(){
        
        FilmDAO dao = new FilmDAO();
        
        return dao.rechercherTout();
        
    }
    
    public Film rechercherDetailsFilm(Long idDuFilm){
        
        FilmDAO dao = new FilmDAO();
        
        return dao.rechercherParId(idDuFilm);
        
    }
    
    public void ajouterFilm(Film filmAA){
        
        FilmDAO dao = new FilmDAO();
        
        dao.ajouter(filmAA);
    }

    public void supprimerFilm(Long filmId) {
        
        FilmDAO dao = new FilmDAO();
        
        dao.supprimer(filmId);
    }
    
}
