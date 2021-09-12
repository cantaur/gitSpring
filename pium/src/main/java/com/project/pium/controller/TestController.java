package com.project.pium.controller;

import com.project.pium.domain.Member;
import com.project.pium.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@RequestMapping("rest_member")
@AllArgsConstructor
public class TestController {
    private MemberService memberService;

    @GetMapping("read")
    public List<Member> read(){
        List<Member> list = memberService.list();
        log.info("#list"+list);
        return list;
    }


}
