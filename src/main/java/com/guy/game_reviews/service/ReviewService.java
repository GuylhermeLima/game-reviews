package com.guy.game_reviews.service;

import com.guy.game_reviews.repository.GameRepository;
import com.guy.game_reviews.repository.ReviewRepository;
import com.guy.game_reviews.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.guy.game_reviews.dto.ReviewCreateDTO;
import com.guy.game_reviews.exeption.ResourceNotFoundException;
import com.guy.game_reviews.model.Game;
import com.guy.game_reviews.model.Review;
import com.guy.game_reviews.model.Usuario;

@Service
public class ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;
    private final UsuarioRepository usuarioRepository;

    public ReviewService(ReviewRepository reviewRepository, GameRepository gameRepository, UsuarioRepository usuarioRepository){
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Review create(Review review){
        return reviewRepository.save(review);
    }

    @Transactional
    public Review create(Long gameId, ReviewCreateDTO dto){
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game não encontrado."));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado."));

        Review review = new Review();
        review.setGame(game);
        review.setUser(usuario);
        review.setTitle(dto.getTitle());
        review.setComment(dto.getComment());
        review.setNote(dto.getNote());

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
