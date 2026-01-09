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

import com.winterflame.aura.entity.Panorama;
import com.winterflame.aura.service.PanoramaService;

@RestController
@RequestMapping("/api/panorama")
public class PanoramaRestController {

    private final PanoramaService panoramaService;

    @Autowired
    public PanoramaRestController(PanoramaService panoramaService) {
        this.panoramaService = panoramaService;
    }

    @PostMapping
    public int addPanorama(@RequestBody Panorama panorama) {
        return panoramaService.addPanorama(panorama);
    }

    @PutMapping
    public int updateUser(@RequestBody Panorama panorama) {
        return panoramaService.modifyPanorama(panorama);
    }

    @DeleteMapping("/{panoramaId}")
    public void deleteUser(@PathVariable int panoramaId) {
        panoramaService.deletePanorama(panoramaId);
    }

    @GetMapping("/{panoramaId}")
    public Panorama getUserById(@PathVariable int panoramaId) {
        return panoramaService.getPanorama(panoramaId);
    }

    @GetMapping
    public List<Panorama> getAllUsers() {
        return panoramaService.getAllPanorama();
    }
}
