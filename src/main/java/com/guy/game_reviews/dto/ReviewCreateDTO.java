package com.guy.game_reviews.dto;

import com.guy.game_reviews.model.Game;
import com.guy.game_reviews.model.Review;
import com.guy.game_reviews.model.Usuario;

public class ReviewCreateDTO {
    
    private long id;
    private Long usuarioId;
    private String title;
    private String comment;
    private double note;

    public ReviewCreateDTO(){
        
    }

    public ReviewCreateDTO(Review review){
        setId(review.getId());
        setUsuarioId(review.getUser().getId());
        setTitle(review.getTitle());
        setComment(review.getComment());
        setNote(review.getNote());
    }

    public ReviewCreateDTO(Usuario user, Game game, String title, String comment, float note){
        setTitle(title);
        setComment(comment);
        setNote(note);
    }

    //Getters

    public long getId(){
        return id;
    }
    public Long getUsuarioId(){
        return usuarioId;
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
    public void setUsuarioId(Long usuarioId){
        this.usuarioId = usuarioId;
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
