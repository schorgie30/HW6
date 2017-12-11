
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Movie</title>
    </head>
    <body>
        <h1>Add A New Movie</h1>
        
        <form name="addForm" action="addMovie" method="post">
            
            <label>Movie Title:</label>
            <input type="text" name="movieTitle" value="" />
            <br>
            <label>Genre:</label>
            <input type="text" name="movieGenre" value="" />
            <br>
            <label>Year:</label>
            <input type="number" name="movieYear" value="" />
            <br>
            <label>Director:</label>
            <input type="text" name="movieDirector" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
            
        </form>
    </body>
</html>
