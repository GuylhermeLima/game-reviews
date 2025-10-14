package com.guy.game_reviews.service;

import com.guy.game_reviews.repository.GameRepository;

import java.util.List;

import com.guy.game_reviews.exeption.ResourceNotFoundException;
import com.guy.game_reviews.model.Game;

public class GameService {
    
    private final GameRepository gameRepository;
    
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game create(Game game){
        return gameRepository.save(game);
    }

    public List<Game> listAll(){
        return gameRepository.findAll();
    }

    public Game getById(long id){
        return gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game não encontrado"));
    }

    public List<Game> getByTitle(String title){
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }

    public Game update(Long id, Game updated){
        Game existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setGenre(updated.getGenre());
        existing.setPlataform(updated.getPlataform());
        existing.setUrlImage(updated.getUrlImage());
        existing.setReleaseDate(updated.getReleaseDate());
        return gameRepository.save(existing);
    }

    public void delete(Long id){
        if (!gameRepository.existsById(id)) throw new ResourceNotFoundException("Game de ID: " + id + " Não encontrado.");
    }

}
