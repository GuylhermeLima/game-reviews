package com.guy.game_reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guy.game_reviews.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}
