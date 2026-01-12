package com.winterflame.aura.service;

import java.util.List;

import com.winterflame.aura.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterflame.aura.entity.Rating;

import jakarta.transaction.Transactional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    public int addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Transactional
    public int modifyRating(Rating rating) {
        return ratingRepository.update(rating);
    }

    @Transactional
    public void deleteRating(int rankId) {
        ratingRepository.delete(rankId);
    }

    public Rating getRating(int rankId) {
        return ratingRepository.getById(rankId);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.getAll();
    }
}
