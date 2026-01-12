package com.winterflame.aura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winterflame.aura.entity.Rating;
import com.winterflame.aura.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingRestController {

    private final RatingService ratingService;

    @Autowired
    public RatingRestController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public int addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @PutMapping
    public int updateRating(@RequestBody Rating rating) {
        return ratingService.modifyRating(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable int ratingId) {
        ratingService.deleteRating(ratingId);
    }

    @GetMapping("/{ratingId}")
    public Rating getRatingById(@PathVariable int ratingId) {
        return ratingService.getRating(ratingId);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }
}
