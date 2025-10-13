package com.guy.game_reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guy.game_reviews.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
