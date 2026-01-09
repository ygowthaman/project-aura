package com.winterflame.aura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winterflame.aura.entity.Vibe;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class VibeRepository implements VibeDAO {

    private final EntityManager entityManager;

    @Autowired
    public VibeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int save(Vibe vibe) {
        entityManager.persist(vibe);
        return vibe.getId();
    }

    @Override
    @Transactional
    public int update(Vibe vibe) {
        entityManager.merge(vibe);
        return vibe.getId();
    }

    @Override
    @Transactional
    public void delete(int vibeId) {
        Vibe vibe = entityManager.find(Vibe.class, vibeId);
        entityManager.remove(vibe);
    }

    @Override
    public Vibe getById(int vibeId) {
        return entityManager.find(Vibe.class, vibeId);
    }

    @Override
    public List<Vibe> getAll() {
        return entityManager.createQuery("FROM Vibe", Vibe.class).getResultList();
    }
}
