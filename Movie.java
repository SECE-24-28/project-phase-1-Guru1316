public class Movie {
    String movieId;
    String movieName;
    int movieYear;
    String movieGenre;
    Production production;
    Actors actors;

    Movie(String id, String name, int year, String genre, Production production, Actors actors) {
        this.movieId = id;
        this.movieName = name;
        this.movieYear = year;
        this.movieGenre = genre;
        this.production = production;
        this.actors = actors;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Actors getActors() {
        return actors;
    }

    public void setActors(Actors actors) {
        this.actors = actors;
    }
}
