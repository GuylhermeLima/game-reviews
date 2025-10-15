package com.guy.game_reviews.dto;

import com.guy.game_reviews.model.Game;
import com.guy.game_reviews.model.Review;
import com.guy.game_reviews.model.Usuario;

public class ReviewDTO {
    
    private long id;
    private Usuario user;
    private Game game;
    private String title;
    private String comment;
    private double note;

    public ReviewDTO(){
        
    }

    public ReviewDTO(Review review){
        setId(review.getId());
        setUser(review.getUser());
        setGame(review.getGame());
        setTitle(review.getTitle());
        setComment(review.getComment());
        setNote(review.getNote());
    }

    public ReviewDTO(Usuario user, Game game, String title, String comment, float note){
        setUser(user);
        setGame(game);
        setTitle(title);
        setComment(comment);
        setNote(note);
    }

    //Getters

    public long getId(){
        return id;
    }
    public Usuario getUser(){
        return user;
    }
    public Game getGame(){
        return game;
    }
    public String getTitle(){
        return title;
    }
    public String getComment(){
        return comment;
    }
    public double getNote(){
        return note;
    }  
    
    //Setters

    public void setId(Long id){
        this.id = id;
    }
    public void setUser(Usuario user){
        this.user = user;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public void setNote(double note){
        this.note = note;
    }

}
