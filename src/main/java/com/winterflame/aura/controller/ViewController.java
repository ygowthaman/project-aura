package com.winterflame.aura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    /**
     * Forward all GET requests to React's index.html except:
     * - /api/** endpoints (handled by @RestController with /api prefix)
     * - Static resources (handled by Spring Boot automatically)
     *
     * This catches all other routes and forwards to React's SPA for client-side routing
     */
    @RequestMapping(value = "/**/{path:[^.]*}")
    public String forward() {
        return "forward:/index.html";
    }
}
