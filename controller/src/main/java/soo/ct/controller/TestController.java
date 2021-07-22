package soo.ct.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import soo.ct.domain.Human;
import soo.ct.domain.HumanList;
import soo.ct.domain.ToDoDTO;

import java.util.ArrayList;

@Log4j
@Controller
@RequestMapping("/test/*")
public class TestController {
    @RequestMapping("")
    public void m01() {
        log.info("#m01() - default URL");
    }
    @RequestMapping("/base1")
    public void m02() {
        log.info("#m02() - Get방식 & Post방식&...");
    }
    @RequestMapping(value="/base2", method= RequestMethod.GET)
    public void m03() {
        log.info("#m03()");
    }
    @RequestMapping(value="/base3", method= {RequestMethod.GET, RequestMethod.POST})
    public void m04() {
        log.info("#m04() - Get방식 & Post방식");
    }
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String form() {
        return "test/form";
    }

    @RequestMapping("/param1")
    public void m05(Human dto) {
        log.info("#m05() dto: " + dto) ;
    }
    @RequestMapping("/param2")
    public void m06(@RequestParam("name") String na, @RequestParam("age") int ag) {
        log.info("#m06() name: " + na + ", age: " + ag) ;
    }
    @RequestMapping("/param3")
    public void m07(@RequestParam ArrayList<String> names) {
        log.info("#m07() names: " + names) ;
    }
    @RequestMapping("/param4")
    public void m08(@RequestParam("ns") ArrayList<String> names) {
        log.info("#m08() names: " + names) ;
    }
    @RequestMapping("/param5")
    public void m09(@RequestParam String[] names) {
        log.info("#m09() names: " + names) ;
        for(String name: names) log.info("name: " + name);
    }

    @RequestMapping("/param6")
    public void m10(HumanList hlist) {
        log.info("#m10() hlist: " + hlist) ;
    }
    @RequestMapping("/param7")
    public void m11(Human dto, @RequestParam int page) {
        log.info("#m11() dto: " + dto + ", page: " + page) ;
    }
    @RequestMapping("/param8")
    public void m12(ToDoDTO dto) {
        log.info("#m12() dto: " + dto) ;
        log.info("#m12() cdate: " + dto.getCdate()) ;
    }

    @GetMapping("/json1")
    public ResponseEntity<String> m13() {
        String msg = "{\"name\":\"홍길동\", \"age\":20}"; //JSON
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");

        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }

    //https://www.w3schools.com/tags/ref_httpmessages.asp


    @GetMapping("/json2")
    public @ResponseBody
    Human m14() { //*****
        Human man = new Human("최동현", 26);
        return man;
    }
}


