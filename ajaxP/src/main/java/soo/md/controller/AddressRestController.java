package soo.md.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

import java.util.List;

@Log4j
@RestController
@RequestMapping("rest_addr")
public class AddressRestController {//CRUD
    @Autowired
    private AddressAjaxService service;


    //(1)Create (insert)
    @PostMapping("create")
    public void create(@RequestBody Address address){
        log.info("#AddressRestController create() address: "+address);
        service.insertS(address);
    }

    //원래는 form을 만들어서 post 방식으로 값을 받아와야 하지만 크롬의 기본 플러그인인 Talend API Tester를 이용해서 확인한다
    //http://127.0.0.1:8000/rest_addr/create (1)
    //http://127.0.0.1:8000/rest_addr/create.json (2)
    //http://127.0.0.1:8000/rest_addr/create.xml
    //{"seq": -1, "name": "황무", "addr": "서울", "rdate":-1}

    //(2) Read(select)
    @GetMapping("read")
    public List<Address> read(){
        List<Address> list = service.listS();
        return list;
    }//http://127.0.0.1:8080/rest_addr/read.json

    @GetMapping("read/{seq}")
    public Address read(@PathVariable int seq){
        Address address = service.selectBySeqS(seq);
        return address;
    }//http://127.0.0.1:8080/rest_addr/read/31.json 또는 http://127.0.0.1:8080/rest_addr/read/31.xml
//
    @GetMapping(value = "read", params = {"name"})
    public List<Address> read(@RequestParam String name){
        List<Address> list = service.selectByNameS(name);
        return list;
    }//http://127.0.0.1:8080/rest_addr/read.json?name=?

    @DeleteMapping("delete/{seq}")
    public void delete(@PathVariable int seq){
        service.deleteS(seq);
    }
    //http://127.0.0.1:8000/rest_addr/delete/5 (Talend API Tester 로 확인)


}
