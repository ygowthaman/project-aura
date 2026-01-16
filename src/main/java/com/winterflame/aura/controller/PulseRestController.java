package com.winterflame.aura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winterflame.aura.entity.Pulse;
import com.winterflame.aura.service.PulseService;

@RestController
@RequestMapping(name = "/api/pulse")
public class PulseRestController {

    private PulseService pulseService;

    @Autowired
    public PulseRestController(PulseService pulseService) {
        this.pulseService = pulseService;
    }

    @GetMapping(name="/year/{year}")
    public List<Pulse> getPulseByYearAndUser(@PathVariable int year, @RequestParam int userId) {
        return pulseService.getPulseByYearAndUser(year, userId);
    }

    @GetMapping(name="/year/{year}/month/{month}")
    public List<Pulse> getPulseByYearMonthUser(@PathVariable int year, @PathVariable int month, @RequestParam int userId) {
        return pulseService.getPulseByYearMonthUser(year, month, userId);
    }
}
