package com.guy.game_reviews.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ElementCollection
    private List<String> genre;
    @ElementCollection
    private List<String> plataform;
    private String urlImage;
    private LocalDate releaseDate;
    private double note;
    private long numReviews;

    public Game(){

    }

    public Game(String title, List<String> genre, List<String> plataform, String urlImage, LocalDate releaseDate, float note){
        setTitle(title);
        setGenre(genre);
        setPlataform(plataform);
        setUrlImage(urlImage);
        setReleaseDate(releaseDate);
        setNote(note);
    }
    


    // Getters

    public long getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public List<String> getGenre(){
        return genre;
    }
    public List<String> getPlataform(){
        return plataform;
    }
    public String getUrlImage(){
        return urlImage;
    }
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    public double getNote(){
        return note;
    }
    public long getNumReviews(){
        return numReviews;
    }

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(List<String> genre){
        this.genre = genre;
    }
    public void setPlataform(List<String> plataform){
        this.plataform = plataform;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }
    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setNote(double note){
        this.note = note;
    }
    public void setNumReviews(long numReviews){
        this.numReviews = numReviews;
    }

}
