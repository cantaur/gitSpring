package soo.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

import java.util.List;

@Controller
@RequestMapping("auto")
public class AutoController {

    @GetMapping("auto.do")
    public  String showView(){
        return "auto/autocomplete";
    }

    @Autowired
    private AddressAjaxService service;

    @PostMapping(value = "autoData", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody List<Address> getAddressList(String writer){
        List<Address> list = service.selectByNameS(writer);
        return list;
    }

}
