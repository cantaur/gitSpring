package spring.boot.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rest_addr")
public class Address4RestController {

    @GetMapping("/write.do")
    public String write() {
        return "rest_addr/write";
    }

}
