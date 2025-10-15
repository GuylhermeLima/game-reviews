package com.guy.game_reviews.dto;

import com.guy.game_reviews.model.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCreateDTO {

    @NotBlank
    private String usuario;
    @NotBlank
    private String nome;
    @Email
    private String email;
    @Size(min = 6)
    private String senha;

    public UsuarioCreateDTO(){
        
    }

    public UsuarioCreateDTO(Usuario usuario){
        setEmail(usuario.getEmail());
        setNome(usuario.getNome());
        setUsuario(usuario.getUsuario());
        setSenha(usuario.getSenha());
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
