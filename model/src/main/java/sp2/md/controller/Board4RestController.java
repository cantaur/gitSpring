package sp2.md.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rest_board")
public class Board4RestController {
    @GetMapping("/list.do")
    public String write() {
        return "rest_board/list";
    }

}
