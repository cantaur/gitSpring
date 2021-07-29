package soo.md.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ajax")
public class AjaxIndexController {

    @RequestMapping(value = "test01.do")
    public String test01() {
        return "ajax/test01";
    }

    @RequestMapping(value = "test02.do")
    public String test02() {
        return "ajax/test02";
    }

    @RequestMapping(value = "test03.do")
    public String test03() {
        return "ajax/test03";
    }

    @RequestMapping(value = "test04.do")
    public String test04() {
        return "ajax/test04";
    }
}
