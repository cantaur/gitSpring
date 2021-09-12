package com.project.pium.security;

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
        log.info("#index");
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        log.info("#login");
        return "login";
    }

    @GetMapping(value = "/private")
    public String privatePage() {
        //login form으로 이동
        log.info("#private");
        return "private";
    }

    @GetMapping(value = "/public")
    public String publicPage() {
        log.info("#public");
        return "public";
    }
}
