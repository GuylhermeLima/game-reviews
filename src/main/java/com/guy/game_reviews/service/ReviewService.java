package com.guy.game_reviews.service;

import com.guy.game_reviews.repository.ReviewRepository;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.guy.game_reviews.exeption.ResourceNotFoundException;
import com.guy.game_reviews.model.Review;

@Service
public class ReviewService {
    
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Review create(Review review){
        return reviewRepository.save(review);
    }

    public  List<Review> listALL(){
        return reviewRepository.findAll();
    }

    public  List<Review> listByGame(Long gameId){
        return reviewRepository.findByGameId(gameId);
    }

    public double getAverageNote(Long gameId){
        List<Review> reviews = listByGame(gameId); 
        OptionalDouble avg = reviews.stream().mapToDouble(Review::getNote).average();
        return avg.orElse(0.0);
    }

    public Review update(Long id, Review updated){
        Review existing = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review de ID: " + id + " não encrontado."));

        existing.setTitle(updated.getTitle());
        existing.setComment(updated.getComment());
        existing.setNote(updated.getNote());
        return reviewRepository.save(existing);
    }

    public void delete(Long id){
        if (!reviewRepository.existsById(id)) throw new ResourceNotFoundException("Review Não encontrada");
        reviewRepository.deleteById(id);
    }

}
