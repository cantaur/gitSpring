package com.project.pium.controller;

import com.project.pium.domain.MemberPrincipalVO;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {


    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }



    @GetMapping("/")
    public String loadExceptionPage(ModelMap model) throws Exception{
        log.info("인덱스냐고");
        

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MemberPrincipalVO userPrincipalVO = (MemberPrincipalVO) auth.getPrincipal();

        model.addAttribute("name",userPrincipalVO.getUsername());
        model.addAttribute("auth",userPrincipalVO.getAuthorities());

        return "index";
    }

    @GetMapping("/access-denied")
    public String loadAccessdeniedPage() throws Exception{
        return "index";
    }
}
