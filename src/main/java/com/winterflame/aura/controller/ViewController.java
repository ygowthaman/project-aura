package com.winterflame.aura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    /**
     * Forward all requests to React's index.html except:
     * - static resources (handled by Spring Boot automatically)
     * - API endpoints (if you add them later)
     * 
     * This uses RequestMapping instead of GetMapping to handle all HTTP methods
     * and lets Spring Boot's default resource handling serve static files
     */
    @RequestMapping(value = "/**/{path:[^.]*}")
    public String forward() {
        return "forward:/index.html";
    }
}
