<%-- 
    Document   : form
    Created on : 17 juin 2016, 09:38:19
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire</h1>
        <br />
        <br />
        <form method="post">
            <h3>Titre : <input name="titre"></h3>
            <br />
            <h3>Année de production : <input name="anneeProd"></h3>
            <br />
            <h3>Genre : 
                <select name="genre">
                    <option>Policier</option>
                    <option>Horreur</option>
                    <option>Historique</option>
                    <option selected>Drame</option>
                    <option>Action</option>
                    <option>Navet</option>
                </select>
            </h3>
            
            <br />
            <h3>Pays :
                <select name="pays">
                    <option>Italie</option>
                    <option>Royaune-Uni</option>
                    <option>Etats-Unis</option>
                    <option selected>France</option>
                    <option>Espagne</option>
                    <option>Corée du Sud</option>
                </select>
            </h3>
             
            <br />
            <br />
            
            <input type="submit" value="Envoi" />
            
        </form>
        
    </body>
</html>
