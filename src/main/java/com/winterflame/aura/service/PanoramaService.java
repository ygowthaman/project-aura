package com.winterflame.aura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterflame.aura.entity.Panorama;
import com.winterflame.aura.repository.PanoramaRepository;

import jakarta.transaction.Transactional;

@Service
public class PanoramaService {

    private final PanoramaRepository panoramaRepository;

    @Autowired
    public PanoramaService(PanoramaRepository panoramaRepository) {
        this.panoramaRepository = panoramaRepository;
    }

    @Transactional
    public int addPanorama(Panorama panorama) {
        return panoramaRepository.save(panorama);
    }

    @Transactional
    public int modifyPanorama(Panorama panorama) {
        return panoramaRepository.update(panorama);
    }

    @Transactional
    public void deletePanorama(int panoramaId) {
        panoramaRepository.delete(panoramaId);
    }

    public Panorama getPanorama(int panoramaId) {
        return panoramaRepository.getById(panoramaId);
    }

    public List<Panorama> getAllPanorama() {
        return panoramaRepository.getAll();
    }
}
