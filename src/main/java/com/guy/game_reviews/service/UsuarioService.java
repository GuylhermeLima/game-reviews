package com.guy.game_reviews.service;

import java.util.List;

import com.guy.game_reviews.exeption.ResourceNotFoundException;
import com.guy.game_reviews.model.Usuario;
import com.guy.game_reviews.repository.UsuarioRepository;

public class UsuarioService {
 
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario de ID: " + id + " não encontrado."));
    }

    public Usuario findByUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario).orElseThrow(() -> new ResourceNotFoundException("Usuário " + usuario + " não encontrado"));
    }

    public void delete(Long id){
        if(!usuarioRepository.existsById(id)) throw new ResourceNotFoundException("Usuário não encontrado.");
        usuarioRepository.deleteById(id);
    }

}
