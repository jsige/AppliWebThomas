/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;


import java.util.List;
import streaming.entity.Pays;
import streaming.dao.PaysDAO;

/**
 *
 * @author admin
 */
public class PaysService {
    public List <Pays> listerLesPays(){
        
        PaysDAO dao = new PaysDAO();
        
        return dao.listerPaysParNom();
        
    }

    public Pays obtenirPaysParId(Long paysId) {
        PaysDAO dao = new PaysDAO();
        
        return dao.listerPaysParNom(paysId);
    }
}
