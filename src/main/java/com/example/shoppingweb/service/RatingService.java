package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Ratings;
import com.example.shoppingweb.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

}
