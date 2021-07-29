package soo.md.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Log4j
@AllArgsConstructor
@RequestMapping("ajax04")
@RestController
public class AjaxT04Controller {
    //태생부터 다르다
    private AddressAjaxService service;

    @GetMapping(value = "search01", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Address search01(long seq, HttpServletResponse response) {
        Address address = service.selectBySeqS(seq);
        return address;

    }


    @PostMapping(value = "search02", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Address> search02(String name, HttpServletResponse response) {
        List<Address> list = service.selectByNameS(name);
        return list;


    }
}