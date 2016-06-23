/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

/**
 *
 * @author admin
 */
public class EmailService {
    
    public void envoyerEmail(String emailUtil, String objet, String corps){
        
        System.out.println("@ : " + emailUtil);
        System.out.println("Objet : " + objet);
        System.out.println("Corps : " + corps);
    }
}
