package model;

public class Movies {
    private int movieID;
    private String movieTitle;
    private String movieGenre;
    private int movieYear;
    private String movieDirector;

    public Movies() {
        this.movieID = 0;
        this.movieTitle = "";
        this.movieGenre = "";
        this.movieYear = 0;
        this.movieDirector = "";
    }
    
     public Movies(int movieID, String movieTitle, String movieGenre, int movieYear, String movieDirector) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieDirector = movieDirector;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    @Override
    public String toString() {
        return "Movies{" + "movieID=" + movieID + ", movieTitle=" + movieTitle + ", movieGenre=" + movieGenre + ", movieYear=" + movieYear + ", movieDirector=" + movieDirector + '}';
    }
    
    
     
     
    
    
}
