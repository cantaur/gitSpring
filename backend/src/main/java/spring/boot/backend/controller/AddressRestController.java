package spring.boot.backend.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.backend.domain.Address;
import spring.boot.backend.service.AddressRestService;

import java.util.List;


@Log
@RestController
@RequestMapping("rest_addr")
@CrossOrigin(origins = "*", maxAge = 3600) //for react. 모든 url에서 호출한다는 뜻
public class AddressRestController {//CRUDs
    @Autowired
    private AddressRestService service;


    //(1)Create (insert)
    @PostMapping("create")
    public void create(@RequestBody Address address){
        log.info("#AddressRestController create() address: "+address);
        service.insertS(address);
    }

    //원래는 form을 만들어서 post 방식으로 값을 받아와야 하지만 크롬의 기본 플러그인인 Talend API Tester를 이용해서 확인한다
    //http://127.0.0.1:8000/rest_addr/create (1)
    //{"seq": -1, "name": "황무", "addr": "서울", "rdate":-1}

    //(2) Read(select)
    @GetMapping("read")
    public List<Address> read(){
        List<Address> list = service.listS();
        return list;
    }//http://127.0.0.1:8080/rest_addr/read

    @GetMapping("read/{seq}")
    public Address read(@PathVariable int seq){
        Address address = service.selectBySeqS(seq);
        return address;
    }//http://127.0.0.1:8080/rest_addr/read/31
//
    @GetMapping(value = "read", params = {"name"})
    public List<Address> read(@RequestParam String name){
        List<Address> list = service.selectByNameS(name);
        return list;
    }//http://127.0.0.1:8080/rest_addr/read?name=?

    @DeleteMapping("delete/{seq}")
    public void delete(@PathVariable int seq){
        service.deleteS(seq);
    }
    //http://127.0.0.1:8000/rest_addr/delete/5 (Talend API Tester 로 확인)


}
