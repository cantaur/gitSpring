package com.project.pium.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring security controller
 */

@Log
@Controller
public class SecurityController {

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping(value = "/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    @GetMapping(value = "/private")
    public String privatePage() {
        return "private";
    }

    @GetMapping(value = "/public")
    public String publicPage() {
        return "public";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }




}
