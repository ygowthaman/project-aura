package com.winterflame.aura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winterflame.aura.entity.Panorama;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PanoramaRepository implements PanoramaDAO {

    private final EntityManager entityManager;

    @Autowired
    public PanoramaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int save(Panorama panorama) {
        entityManager.persist(panorama);
        return panorama.getId();
    }

    @Override
    @Transactional
    public int update(Panorama panorama) {
        entityManager.merge(panorama);
        return panorama.getId();
    }

    @Override
    @Transactional
    public void delete(int panoramaId) {
        Panorama panorama = entityManager.find(Panorama.class, panoramaId);
        entityManager.remove(panorama);
    }

    @Override
    public Panorama getById(int panoramaId) {
        return entityManager.find(Panorama.class, panoramaId);
    }

    @Override
    public List<Panorama> getAll() {
        return entityManager.createQuery("FROM Panorama", Panorama.class).getResultList();
    }
}
