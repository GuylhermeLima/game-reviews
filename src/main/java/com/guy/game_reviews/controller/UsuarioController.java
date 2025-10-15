package com.guy.game_reviews.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guy.game_reviews.dto.UsuarioCreateDTO;
import com.guy.game_reviews.dto.UsuarioDTO;
import com.guy.game_reviews.model.Usuario;
import com.guy.game_reviews.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioCreateDTO> create(@RequestBody UsuarioCreateDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setUsuario(dto.getUsuario());
        usuario.setSenha(dto.getSenha());

        Usuario created = usuarioService.create(usuario);
        return ResponseEntity.status(201).body(new UsuarioCreateDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listAll(){
        List<UsuarioDTO> list = usuarioService.listAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id){
        Usuario usuario = usuarioService.getById(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UsuarioDTO>> searchByUsuario(@RequestParam String usuario){
        List<UsuarioDTO> result = usuarioService.findByUsuario(usuario).stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
