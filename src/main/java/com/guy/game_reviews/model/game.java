package com.guy.game_reviews.model;

import java.util.Date;
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
    private Date releaseDate;

    public Game(){

    }

    public Game(String title, List<String> genre, List<String> plataform, String urlImage, Date releaseDate){
        setTitle(title);
        setGenre(genre);
        setPlataform(plataform);
        setUrlImage(urlImage);
        setReleaseDate(releaseDate);
    }
    


    // Getters

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
    public Date getReleaseDate(){
        return releaseDate;
    }

    //Setters

    public void setId(long id) {
        this.id = id;
    }
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
    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }

}
