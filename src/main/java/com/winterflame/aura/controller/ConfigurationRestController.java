package com.winterflame.aura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/configuration")
public class ConfigurationRestController {

    @GetMapping("/years")
    public List<Integer> getYears() {
        return List.of(2024, 2025, 2026);
    }
}
