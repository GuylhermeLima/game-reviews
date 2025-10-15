package com.guy.game_reviews.dto;

import com.guy.game_reviews.model.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String usuario;

    public UsuarioDTO(){
        
    }

    public UsuarioDTO(Usuario usuario){
        setId(usuario.getId());
        setNome(usuario.getNome());
        setUsuario(usuario.getUsuario());
    }

    public UsuarioDTO(String nome, String usuario, String email) {
        this.nome = nome;
        this.usuario = usuario;
    }

    // Getters

    public Long getId(){
        return id;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getNome(){
        return nome;
    }

    //Setters

    public void setId(long id){
        this.id = id;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
 

}
