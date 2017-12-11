package dpHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;
import java.sql.PreparedStatement;

public class ReadRecord {
    private Connection conn;
    private ResultSet results;
    
    private Movies movie = new Movies();
    private int movieID;
    
    
    Properties props = new Properties(); //MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
    
    public ReadRecord(int movieID) {
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       
       this.movieID = movieID;
       
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() throws SQLException {
    //set up a string to hold our query
    String query = "SELECT * FROM movies WHERE movieID = ?";
    
    //create a preparedStatement using our query string
    PreparedStatement ps = conn.prepareStatement(query);
    
    //fill in the preparedStatment
    ps.setInt(1, movieID);
    
    //execute the query
    this.results = ps.executeQuery();
    
        try {
            this.results.next();
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            movie.setMovieID(this.results.getInt("movieID"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            movie.setMovieTitle(this.results.getString("movieTitle"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            movie.setMovieGenre(this.results.getString("movieGenre"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            movie.setMovieYear(this.results.getInt("movieYear"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            movie.setMovieDirector(this.results.getString("movieDirector"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public Movies getMovie() {
        return this.movie;
    }
}
