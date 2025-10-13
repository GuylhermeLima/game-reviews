package com.guy.game_reviews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){

    }

    public Usuario(String usuario, String nome, String email, String senha){
        setUsuario(usuario);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    // Getters
    public long getId(){
        return id;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }

    //Setters
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    

}
