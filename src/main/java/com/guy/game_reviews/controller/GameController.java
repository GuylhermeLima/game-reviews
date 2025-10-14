package com.guy.game_reviews.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guy.game_reviews.dto.GameDTO;
import com.guy.game_reviews.model.Game;
import com.guy.game_reviews.service.GameService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO dto){
        Game game = new Game();
        game.setTitle(dto.getTitle());
        game.setGenre(dto.getGenre());
        game.setPlataform(dto.getPlataform());
        game.setUrlImage(dto.getUrlImage());
        game.setReleaseDate(dto.getReleaseDate());

        Game created = gameService.create(game);
        return ResponseEntity.status(201).body(new GameDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> listALL(){
        List<GameDTO> list = gameService.listAll().stream().map(GameDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getByID(@PathVariable Long id){
        Game game = gameService.getById(id);
        return ResponseEntity.ok(new GameDTO(game));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GameDTO>> searchByTitle(@RequestParam String title) {
        List<GameDTO> result = gameService.getByTitle(title).stream().map(GameDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> update(@PathVariable Long id, @RequestBody GameDTO dto){
        Game game = new Game();
        game.setTitle(dto.getTitle());
        game.setGenre(dto.getGenre());
        game.setPlataform(dto.getPlataform());
        game.setUrlImage(dto.getUrlImage());
        game.setReleaseDate(dto.getReleaseDate());

        Game updated = gameService.update(id, game);
        return ResponseEntity.ok(new GameDTO(updated));

    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    

}
