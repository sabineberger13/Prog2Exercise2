package at.ac.fhcampuswien.fhmdb.models;

import java.util.*;
import com.google.gson.Gson;
import java.io.*;

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

    public Movie(String title, List<Genre> genre, int releaseYear, String description, String imgUrl, int length, List<String> directors, List<String> writers, List<String> mainCast, double rating)  throws IllegalArgumentException {
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

    /*public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure." ,
                Arrays.asList(Genre.DRAMA, Genre.THRILLER, Genre.HORROR)));

        movies.add(new Movie(
                "A Star is born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                Arrays.asList(Genre.DRAMA, Genre.MUSICAL, Genre.ROMANCE)));

        movies.add(new Movie(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                Arrays.asList(Genre.DRAMA,Genre.ADVENTURE)));

        movies.add(new Movie(
                "The Dark Knight",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA)));

        movies.add(new Movie(
                "Pulp Fiction",
                "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                Arrays.asList(Genre.CRIME, Genre.DRAMA)));

        movies.add(new Movie(
                "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
                Arrays.asList(Genre.ACTION, Genre.ADVENTURE)));

        movies.add(new Movie(
                "The Matrix",
                "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
                Arrays.asList(Genre.ACTION, Genre.ADVENTURE)));
        movies.add(new Movie(
                "Life Is Beautiful",
                "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp." ,
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE)));
        movies.add(new Movie(
                "The Usual Suspects",
                "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.",
                Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY)));
        movies.add(new Movie(
                "Puss in Boots",
                "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.",
                Arrays.asList(Genre.COMEDY, Genre.FAMILY, Genre.ANIMATION)));
        movies.add(new Movie(
                "Avatar",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION)));
        movies.add(new Movie(
                "The Wolf of Wall Street",
                "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE, Genre.BIOGRAPHY)));

        return movies;
    }*/
}
