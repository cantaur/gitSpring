package soo.md.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest")
public class RestTestController {

    @Autowired
    private AddressAjaxService service;



    @GetMapping(value="getText", produces = "text/plain;charset=utf-8")
    public String getText(){
        //일반 컨트롤러라면 기본적으로 return값은 jsp를 가리킨다.
        //RestController는 json data를 리턴한다
        return "안녕";
    }

    @GetMapping(value = "getAddress", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Address getAddress(){
        return  new Address(1,"이가은","서울시",new Date(2021-1900,7-1,30));
    }


    @GetMapping(value = "getList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Address> getList(){
        return service.listS();
    }


    @GetMapping("getMap")
    public Map<String, Address> getMap(){
        Map<String, Address> map= new HashMap<String, Address>();
        map.put("first", new Address(1,"김현순","서울시",new Date(2021-1900,7-1,30)));
        map.put("second", new Address(2,"똥이","서울시",new Date(2021-1900,7-1,30)));
        return map;
    }

    @GetMapping("check")
    public ResponseEntity<Address> check(@RequestParam("height") double h, @RequestParam("weight")double w){
        Address a = new Address(3,""+h, ""+w, new Date(2021-1900,7-1,30));
        ResponseEntity<Address> result = null;
        //클라이언트에게 상태코드를 같이 넘겨줄 수 있는 로직
        //Http 요청이 실패하면 오류와 상태에 관한 정보가 전달된다
        if(h<150){
            result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(a); //옳지 않게된 요청
        }else{
            result=ResponseEntity.status(HttpStatus.OK).body(a); //옳게된 요청
        }
        return result;
    }

    @GetMapping("product/{category}/{pid}")
    public String[] getPath(@PathVariable String category, @PathVariable int pid){
        String strs[]={"카테고리: "+category+", 상품아이디: "+pid};
        return strs;
    }


}
