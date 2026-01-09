package com.winterflame.aura.repository;

import java.util.List;

import com.winterflame.aura.entity.Panorama;

public interface PanoramaDAO {

    public int save(Panorama panorama);

    public int update(Panorama panorama);

    public void delete(int panoramaId);

    public Panorama getById(int panoramaId);

    public List<Panorama> getAll();
}
