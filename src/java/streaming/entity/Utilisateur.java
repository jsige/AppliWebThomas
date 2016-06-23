/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {
    
    public enum RoleUtil {
        UTILISATEUR,
        ADMINISTRATEUR;
    } 
    
    public enum EtatUtil {
        VALIDE,
        NONVALIDE;
    
}
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String login ;
    
    private String mdp;
    
    private String prenom;
    
    private String email;
      
    @Enumerated(EnumType.STRING)
    private RoleUtil roleUtil;

    @Enumerated(EnumType.STRING)
    private EtatUtil etatUtil;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public RoleUtil getRoleUtil() {
        return roleUtil;
    }

    public void setRoleUtil(RoleUtil roleUtil) {
        this.roleUtil = roleUtil;
    }

   

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EtatUtil getEtatUtil() {
        return etatUtil;
    }

    public void setEtatUtil(EtatUtil etatUtil) {
        this.etatUtil = etatUtil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Utilisateurs[ id=" + id + " ]";
    }
    
}
