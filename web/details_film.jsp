<%-- 
    Document   : _TEMPLATE
    Created on : 17 juin 2016, 10:50:28
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails d'un film de la base</title>
        <c:import url="_STYLESHEET.jsp" />
        
        
    </head>
    <body>
        <a href="films_liste">
            <div class="titre">
                <c:import url="_TITRE.jsp" />
            </div>
        </a>
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        <div class="contenu">
            <H1>Titre : ${film.titre}</H1>
            
            <h2>Genre : ${film.genre.nom}</h2>
            
            <h3> Synopsis :</h3> <h4>${film.synopsis}</h4>
            
            <h3>Année : ${film.annee}</h3>
            
            <h3>Pays : 
                <c:forEach items="${film.pays}" var="pays">
                           ${pays.nom}, 
                </c:forEach>
            </h3>
            <h3>Acteurs : 
                <c:forEach items="${film.acteurs}" var="acteur">
                           ${acteur.prenom} ${acteur.nom}, 
                </c:forEach>
            </h3>
            <h3>Réalisateurs : 
                <c:forEach items="${film.realisateurs}" var="realisateur">
                           ${realisateur.prenom} ${realisateur.nom}, 
                </c:forEach>
            </h3>
            <h3>Liens : </h3>
                <h4>
                <c:forEach items="${film.liens}" var="lien">
                    ${lien.langue}, ${lien.qualite} : <a href = "${lien.url}">Lien</a><br /> 
                </c:forEach>
                </h4>
            
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
    </body>
</html>
