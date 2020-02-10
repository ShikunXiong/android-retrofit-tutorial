package edu.uci.swe264p.retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {



    @SerializedName("results")
    private List<Movie> movies;

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieList(List<Movie> movieList){
        this.movies = movieList;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }



}
