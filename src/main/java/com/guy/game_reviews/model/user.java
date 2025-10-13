package com.guy.game_reviews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user;
    private String email;
    private String password;

    // Getters
    public long getId(){
        return id;
    }
    public String getUser(){
        return user;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    //Setters
    public void setUser

}
