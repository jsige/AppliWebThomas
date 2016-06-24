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
        <title>La liste des films de la base</title>
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
           <h1>Liste des Films</h1>
           <table>
               <tbody>
                   <tr>
                        <th>Titre</th>
                        <th>Année</th>
                        <th>Genre</th>		
                        <th>Pays</th>
                    </tr>
                    <c:forEach items="${films}" var="film">
                        <tr>
                            <td>
                                <a href="details_film?id_film=${film.id}">${film.titre}</a>    
                            </td>
                            <td>
                             ${film.annee}    
                            </td>
                            <td>
                             ${film.genre.nom}    
                            </td>
                            <td>
                                <c:forEach items="${film.pays}" var="pays">
                                    ${pays.nom}
                                </c:forEach>
                                    
                            </td>
                            <td>
                                    <%-- <c:if test="${cookie.role.getValue()=='ADMINISTRATEUR'}">
                                        <a href="supprimer_film?id_film=${film.id}">Supprimer ce film</a>
                                    </c:if>                      Version cookies                    --%>
                                    <c:if test="${utilconnecte.roleUtil=='ADMINISTRATEUR'}">
                                        <a href="supprimer_film?id_film=${film.id}">Supprimer ce film</a>
                                    </c:if>
                                    
                            </td>   
                                
                        </tr>
                     </c:forEach>    
               </tbody>
           </table> 
            <br />
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
    </body>
</html>
