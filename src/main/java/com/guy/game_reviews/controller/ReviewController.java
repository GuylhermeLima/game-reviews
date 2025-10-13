package com.guy.game_reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guy.game_reviews.model.Review;
import com.guy.game_reviews.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review createReview(@RequestBody Review review) {  
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> listReviews() {
        return reviewRepository.findAll();
    }
    
    
}
