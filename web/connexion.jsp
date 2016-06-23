<%-- 
    Document   : connexion
    Created on : 21 juin 2016, 12:56:17
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion au Site</title>
    </head>
    <body>
        <a href="films_liste">
            <div class="titre">
                <c:import url="_TITRE.jsp" />
            </div>
        </a>
        <!--        <div class="menu">
                    <c:import url="_MENU.jsp" />
                </div>-->
        <div class="contenu">

            <form method="post">
                <h2>
                    Login : <input name="login">  
                </h2>    
                <br />
                <h2 >
                    Mot de passe : <input type="password" name="pwd">
                </h2>
                <br />
                <input type="submit" value="Connexion" />
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>

    </body>
</html>
