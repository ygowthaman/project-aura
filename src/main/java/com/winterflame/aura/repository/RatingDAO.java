package com.winterflame.aura.repository;

import java.util.List;

import com.winterflame.aura.entity.Rating;

public interface RatingDAO {

    int save(Rating rating);

    int update(Rating rating);

    void delete(int ratingId);

    Rating getById(int ratingId);

    List<Rating> getAll();
}
