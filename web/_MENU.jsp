<%-- 
    Document   : _TITRE
    Created on : 17 juin 2016, 10:54:34
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href="films_liste">Films</a>
<a href="series_liste">Séries</a>



<c:choose>
    <c:when test="${cookie.role.getValue()=='ADMINISTRATEUR'}">
        <a href="ajouter_film">Ajouter un Film</a>
        <a href="ajouter_serie">Ajouter une Série</a>
        <a href="deconnexion_site">DECONNEXION</a>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${cookie.login!=null}">
        <a href="deconnexion_site">DECONNEXION</a>
    </c:when>
    <c:otherwise>
        <a href="connexion_site">CONNEXION</a>
        <a href="inscription_site">INSCRIPTION</a>
    </c:otherwise>
</c:choose>




<%--        

c:choose>*
    <:when test="${cookie.login==null}">
            <a href="connexion_site">CONNEXION</a>
            <a href="inscription_site">INSCRIPTION</a>
    /c:when>
    c:otherwise>
            <a href="connexion_site">DECONNEXION</a>
            
    /c:otherwise>
/c:choose>
   
--%> 

<a href="change_style?style=bleu">Style Bleu</a>
<a href="change_style?style=vert">Style Vert</a>
    
    