package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Ratings;
import com.example.shoppingweb.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    public Ratings addRating(Ratings rating) {
        if (rating.getProduct() == null || rating.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product ID is required.");
        }
        if (rating.getMember() == null || rating.getMember().getId() == null) {
            throw new IllegalArgumentException("Member ID is required.");
        }
        if (rating.getOrder() == null || rating.getOrder().getId() == null) {
            throw new IllegalArgumentException("Order ID is required.");
        }
        if (rating.getRatingScore() == null || rating.getRatingScore() < 1 || rating.getRatingScore() > 5) {
            throw new IllegalArgumentException("Rating score must be between 1 and 5.");
        }
        rating.setRatingDate(LocalDateTime.now());
        return ratingRepository.save(rating);
    }
    public Ratings updateRating(Integer id, Ratings updatedRating) {
        Ratings existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rating not found with ID: " + id));

        if (updatedRating.getRatingScore() != null) {
            if (updatedRating.getRatingScore() < 1 || updatedRating.getRatingScore() > 5) {
                throw new IllegalArgumentException("Rating score must be between 1 and 5.");
            }
            existingRating.setRatingScore(updatedRating.getRatingScore());
        }

        if (updatedRating.getRatingComment() != null) {
            existingRating.setRatingComment(updatedRating.getRatingComment());
        }
        existingRating.setRatingDate(LocalDateTime.now());
        return ratingRepository.save(existingRating);
    }
    public void deleteRating(Integer id) {

        Ratings rating = ratingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rating not found with ID: " + id));
        ratingRepository.delete(rating);
    }
}
