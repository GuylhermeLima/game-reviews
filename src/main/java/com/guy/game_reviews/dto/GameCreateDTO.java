package com.guy.game_reviews.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;


public class GameCreateDTO {

    @NotBlank
    private String title;
    private List<String> genre;
    private List<String> plataform;
    private String urlImage;
    private LocalDate releaseDate;
    private float note;
    private long numReviews;


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
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    public float getNote(){
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
    public void setNote(float note){
        this.note = note;
    }
    public void setNumReviews(long numReviews){
        this.numReviews = numReviews;
    }

}
