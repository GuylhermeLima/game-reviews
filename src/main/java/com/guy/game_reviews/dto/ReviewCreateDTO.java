package com.guy.game_reviews.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReviewCreateDTO {

    @NotBlank
    private UsuarioCreateDTO user;
    @NotBlank
    private GameCreateDTO game;
    private String title;
    private String comment;
    @Size(min = 0, max = 10)
    private float note;

    //Getters

    public UsuarioCreateDTO getUser(){
        return user;
    }
    public GameCreateDTO getGame(){
        return game;
    }
    public String getTitle(){
        return title;
    }
    public String getComment(){
        return comment;
    }
    public float getNote(){
        return note;
    }

    //Setters

    public void setUser(UsuarioCreateDTO user){
        this.user = user;
    }
    public void setGame(GameCreateDTO game){
        this.game = game;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public void setNote(float note){
        this.note = note;
    }
}
