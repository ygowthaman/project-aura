package com.winterflame.aura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DispositionRestController {

    @GetMapping("/disposition")
    public String getAllDisposition() {
        return "All Disposition";
    }
}
