package at.ac.fhcampuswien.fhmdb.models;

import java.util.*;
import com.google.gson.Gson;
import java.io.*;
import org.springframework.boot.SpringApplication;


public class Movie {

    private final UUID id;
    private final String title;
    private final String description;

    private final List<Genre>genre;


    private final String imgUrl;
    private final int releaseYear;
    private final int lengthInMinutes;
    private double rating;
    private List<String> directors;
    private List<String> mainCast;
    private List<String> writers;

    //Constructor eingefügt

    public Movie() {

        this.id = UUID.randomUUID();
        this.title = "";
        this.genre = new ArrayList<>();
        this.releaseYear = 0;
        this.description = "";
        this.imgUrl = "";
        this.lengthInMinutes = 0;
        this.directors = new ArrayList<>();
        this.writers = new ArrayList<>();
        this.mainCast = new ArrayList<>();
        this.rating = 0;

    }

    public Movie(String title, List<Genre>genre, int releaseYear, String description, String imgUrl, int length, List<String> directors, List<String> writers, List<String> mainCast, double rating)  throws IllegalArgumentException {
        this.id = UUID.randomUUID();
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.description = description;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = length;
        this.directors = directors;
        this.writers = writers;
        this.mainCast = mainCast;
        setRating(rating);
    }



    private void setRating(double rating) throws IllegalArgumentException {

        if(rating >=0 && rating <= 10) {

            this.rating = rating;
        }else{
            throw new IllegalArgumentException(("Rating must bei between 0 and 10"));
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Movie other)) {
            return false;
        }
        return this.title.equals(other.title) && this.description.equals(other.description) && this.genre.equals(other.genre);
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genre;
    }

    public UUID getId(){
        return id;
    }

    public int getReleaseYear(){return releaseYear;}

    public static List<Movie> initializeMovies(){


        return new ArrayList<>();
    }
}
