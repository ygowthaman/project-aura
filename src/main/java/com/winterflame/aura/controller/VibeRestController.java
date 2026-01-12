package com.winterflame.aura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winterflame.aura.dto.VibeRequestDTO;
import com.winterflame.aura.entity.Vibe;
import com.winterflame.aura.service.VibeService;

@RestController
@RequestMapping("/api/vibe")
public class VibeRestController {

    private final VibeService vibeService;

    @Autowired
    public VibeRestController(VibeService vibeService) {
        this.vibeService = vibeService;
    }

    @GetMapping()
    public List<Vibe> getVibes() {
        return vibeService.getVibes();
    }

    @PostMapping()
    public int createVibe(@RequestBody VibeRequestDTO vibe) {
        return vibeService.saveVibe(vibe);
    }
}
