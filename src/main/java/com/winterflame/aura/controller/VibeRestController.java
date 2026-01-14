package com.winterflame.aura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winterflame.aura.dto.VibeRequestDTO;
import com.winterflame.aura.entity.Vibe;
import com.winterflame.aura.service.VibeService;

@RestController
@RequestMapping("/api/vibes")
public class VibeRestController {

    private final VibeService vibeService;

    @Autowired
    public VibeRestController(VibeService vibeService) {
        this.vibeService = vibeService;
    }

    @GetMapping()
    public List<Vibe> getVibes(@RequestParam int userId) {
        return vibeService.getVibes(userId);
    }

    @GetMapping("/month")
    public List<Vibe> getVibesByMonth(@RequestParam int userId, @RequestParam int month, @RequestParam int year) {
        return vibeService.getVibesForMonthByUser(year, month, userId);
    }

    @GetMapping("/year")
    public List<Vibe> getVibesByYear(@RequestParam int userId, @RequestParam int year) {
        return vibeService.getVibesForYearByUser(year, userId);
    }

    @PostMapping()
    public int createVibe(@RequestBody VibeRequestDTO vibe) {
        return vibeService.saveVibe(vibe);
    }
}
