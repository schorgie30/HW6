
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Movies"%>
<% Movies movie = (Movies) request.getAttribute("movies"); %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
        <title>Update a New Movie</title>
    </head>
    <body>
        <h1>Update A Movie Record</h1>
        
        <form name="updateForm" action="updateMovie" method="get">
            
            <table class="update">
                <tr>
                    <td class = "right">Movie ID:</td>
                    <td><input type="text" name="movieID" value="<%= movie.getMovieID() %>" /></td>
                </tr>
                
                <tr>
                    <td class = "right">Movie Title:</td>
                    <td><input type="text" name="movieTitle" value="<%= movie.getMovieTitle() %>" /></td>
                </tr>
                
                <tr>
                    <td class = "right">Genre:</td>
                    <td><input type="text" name="movieGenre" value="<%= movie.getMovieGenre() %>" /></td>
                </tr>
                
                <tr>
                    <td class = "right">Year:</td>
                    <td><input type="number" name="movieYear" value="<%= movie.getMovieYear() %>" /></td>
                </tr>
                
                <tr>
                    <td class = "right">Director:</td>
                    <td><input type="text" name="movieDirector" value="<%= movie.getMovieDirector() %>" /></td>
                </tr>
                
                <input type="submit" name="submit" value="Update" />
                </table>
            
        </form>
    </body>
</html>
