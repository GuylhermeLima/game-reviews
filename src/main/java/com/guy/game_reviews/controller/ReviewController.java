package com.guy.game_reviews.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guy.game_reviews.dto.ReviewCreateDTO;
import com.guy.game_reviews.dto.ReviewDTO;
import com.guy.game_reviews.model.Review;
import com.guy.game_reviews.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/game/{gameId}")
    public ResponseEntity<ReviewDTO> create(@PathVariable Long gameId, @RequestBody ReviewCreateDTO dto){
        Review review = reviewService.create(gameId, dto);
        return ResponseEntity.status(201).body(new ReviewDTO(review));
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> listAll(){
        List<ReviewDTO> list = reviewService.listALL().stream().map(ReviewDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<ReviewDTO>> listByGame(@PathVariable Long gameId){
        List<ReviewDTO> list = reviewService.listByGame(gameId).stream().map(ReviewDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> update(@PathVariable Long id, @RequestBody ReviewDTO dto){
        Review review = new Review();
        review.setTitle(dto.getTitle());
        review.setComment(dto.getComment());
        review.setNote(dto.getNote());
        
        Review updated = reviewService.update(id, review);
        return ResponseEntity.ok(new ReviewDTO(updated));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/game/{gameId}/media")
    public ResponseEntity<Double> getAverage(@PathVariable Long gameId){
        double avg = reviewService.getAverageNote(gameId);
        return ResponseEntity.ok(avg);
    }
    
}
