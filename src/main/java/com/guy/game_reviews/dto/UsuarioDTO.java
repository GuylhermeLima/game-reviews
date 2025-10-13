package com.guy.game_reviews.dto;

public class UsuarioDTO {

    private String nome;
    private String usuario;
    private String email;


    public UsuarioDTO(String nome, String usuario, String email) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
    }

    // Getters
    public String getUsuario(){
        return usuario;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }

}
