package com.project.pium.controller;

import com.project.pium.oauth.NaverLoginBO;
import com.project.pium.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@RestController
public class SignController {

    @Autowired
    private final SignService signService;








}
