package soo.md.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("ajax03")
@ResponseBody
public class AjaxT03Controller {
    private AddressAjaxService service;

    @GetMapping("search01")
    public Address search01(long seq, HttpServletResponse response) {
        Address address = service.selectBySeqS(seq);
        return address;

    }


    @PostMapping("search02")
    public List<Address> search02(String name, HttpServletResponse response) {
        List<Address> list = service.selectByNameS(name);
        return list;


    }
}