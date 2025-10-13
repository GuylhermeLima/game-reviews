package com.guy.game_reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guy.game_reviews.model.Usuario;
import com.guy.game_reviews.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository userRepository;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario user) {  
        return userRepository.save(user);
    }

    @GetMapping
    public List<Usuario> listUsuario() {
        return userRepository.findAll();
    }
    
}
