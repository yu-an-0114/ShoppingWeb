package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.Ratings;
import com.example.shoppingweb.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Ratings> addRating(@RequestBody Ratings rating) {
        try {
            Ratings savedRating = ratingService.addRating(rating);
            return ResponseEntity.ok(savedRating);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRating(@PathVariable Integer id, @RequestBody Ratings updatedRating) {
        try {
            Ratings rating = ratingService.updateRating(id, updatedRating);
            return ResponseEntity.ok(rating);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable Integer id) {
        try {
            ratingService.deleteRating(id);
            return ResponseEntity.ok("Rating deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
