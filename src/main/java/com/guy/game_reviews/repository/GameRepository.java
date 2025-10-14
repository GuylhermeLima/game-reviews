package com.guy.game_reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guy.game_reviews.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByTitleContainingIgnoreCase(String title);

}
