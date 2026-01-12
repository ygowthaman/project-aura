package com.winterflame.aura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winterflame.aura.entity.Rating;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class RatingRepository implements RatingDAO {

    private final EntityManager entityManager;

    @Autowired
    public RatingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int save(Rating rating) {
        entityManager.persist(rating);
        return rating.getId();
    }

    @Override
    @Transactional
    public int update(Rating rating) {
        entityManager.merge(rating);
        return rating.getId();
    }

    @Override
    @Transactional
    public void delete(int ratingId) {
        Rating rating = entityManager.find(Rating.class, ratingId);
        entityManager.remove(rating);
    }

    @Override
    public Rating getById(int ratingId) {
        return entityManager.find(Rating.class, ratingId);
    }

    @Override
    public List<Rating> getAll() {
        return entityManager.createQuery("FROM Rating ", Rating.class).getResultList();
    }
}
