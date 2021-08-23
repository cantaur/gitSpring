package spring.boot.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.boot.backend.domain.MybatisDTO;
import spring.boot.backend.service.MybaticService;


@Controller
@AllArgsConstructor
public class MybatisController {

    MybaticService service;

    @GetMapping("mybatis.do")
    public ModelAndView mybatis(){
        ModelAndView mv = new ModelAndView("mybatis");
        MybatisDTO dto = service.selectAll();
        //list<MybatisDTO> list = service.selectAll();
        mv.addObject("dto",dto);
        return mv;
    }
}
