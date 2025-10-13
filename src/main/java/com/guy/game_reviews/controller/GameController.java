package com.guy.game_reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guy.game_reviews.model.Game;
import com.guy.game_reviews.repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @PostMapping
    public Game createGame(@RequestBody Game game){
        return gameRepository.save(game);
    }

    @GetMapping
    public List<Game> listGames(){
        return gameRepository.findAll();
    
    }
    

}
