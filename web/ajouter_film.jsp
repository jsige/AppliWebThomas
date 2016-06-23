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
        <title>Ajouter un film à la base</title>
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
            <form method="post">
                <h3>Titre : <input name="titre"></h3>
                <br />
                <h3>Année de production : <input name="anneeProd"></h3>
                <br />
                <h3>Genre : </h3>
                <select name="genre">
                    <c:forEach items="${genres}" var="genre">
                        <option value="${genre.id}">${genre.nom}</option>
                    </c:forEach>
                </select>
                <br />
                <h3>Pays :
                    <select name="pays">
                        <c:forEach items="${pays}" var="p">
                            <option value="${p.id}">${p.nom}</option>
                        </c:forEach>
                    </select>
                </h3>
                
<!--                <h3>Préom du Producteur : <input name="producteur_prenom"></h3>
                <h3>Nom du Producteur : <input name="producteur_nom"></h3>-->

                <h3>Synopsis : <textarea name="synopsis"></textarea></h3>
                <br />
                
                <br />
                <br />

                <input type="submit" value="Créer" />

            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
    </body>
</html>
