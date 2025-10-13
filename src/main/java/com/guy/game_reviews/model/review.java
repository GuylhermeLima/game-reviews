package com.guy.game_reviews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    private String title;
    private String comment;
    private float note;

    public Review(){

    }

    public Review(User user, Game game, String title, String comment, float note){
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
    public User getUser(){
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
    public float getNote(){
        return note;
    }

    //Setters

    public void setUser(User user){
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
    public void setNote(float note){
        this.note = note;
    }
}
