package dpHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;

public class UpdateQuery {
    private Connection conn;
    
    public UpdateQuery() {
       Properties props = new Properties(); //MWC
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void doUpdate (Movies movie) {
        try {
            String query = "UPDATE movies SET movieTitle = ?, movieGenre = ?, movieYear = ?, movieDirector = ? WHERE movieID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, movie.getMovieTitle());
            ps.setString(2, movie.getMovieGenre());
            ps.setInt(3, movie.getMovieYear());
            ps.setString(4, movie.getMovieDirector());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
