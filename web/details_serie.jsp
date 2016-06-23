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
        <title>Détails d'une série de la base</title>
        <c:import url="_STYLESHEET.jsp" /> -->
        <!--        <link rel="stylesheet" href="css/styles_liste_serie.css" /> -->

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
            <h1>Titre de la série : ${serie.titre}</h1>
            <h2>Genre : ${serie.genre.nom}</h2>
            <h2>Synopsis :</h2>
            <h4>${serie.synopsis}</h4>


            <ul id="onglets">
                <c:forEach items="${serie.saisons}" var="saison">

                    <li><h2>Saison : ${saison.numSaison}</h2></li>
                </c:forEach>    
            </ul>                          
            <c:forEach items="${serie.saisons}" var="saison">    
                <c:forEach items="${saison.episodes}" var="episode">

                    <h3>Episode ${episode.numEpisode} : ${episode.titre}</h3>

                    <h4>Liens :</h4>
                    <c:forEach items="${episode.liens}" var="lien">
                        <a href="${lien.url}">Regarder en ${lien.langue} - ${lien.qualite}</a><br />
                    </c:forEach>



                </c:forEach>

            </c:forEach>



        </div>
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
    </body>
</html>
