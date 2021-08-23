package spring.boot.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.boot.backend.domain.Address;
import spring.boot.backend.service.AddressService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/address/*")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/list.do")
    public ModelAndView list(){
        List<Address> list = addressService.list();

        ModelAndView modelAndView = new ModelAndView("address/list", "list", list);
        return modelAndView;
    }

    @GetMapping("/write.do")
    public String write(){ //string일 때는 jsp의 페이지 이름을 찾게 되어있다
        return "address/write";
    }

    @PostMapping("/write.do")
    public String write(Address address){
        addressService.insert(address);
        return "redirect:list.do";
    }

    @GetMapping("/del.do")
    public String delete(int seq){
        addressService.delete(seq);
        return "redirect:list.do";
    }
}
