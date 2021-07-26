package sp2.md.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sp2.md.domain.Address;
import sp2.md.service.AddressService;

import java.util.List;

@Controller
@RequestMapping("/address/*")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list.do")
    public ModelAndView list(){
        List<Address> list = addressService.list();
//        ModelAndView mv= new ModelAndView();
//        mv.setViewName("address/list");
//        mv.addObject("list", list);

        ModelAndView modelAndView = new ModelAndView("address/list", "list", list);
        //파라미터 3개짜리의 ModelAndView 객체를 생성하면 코드를 더 간단하게 줄일 수 있다
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

    @GetMapping("del.do")
    public String delete(int seq){
    addressService.delete(seq);
    return "redirect:list.do";
    }
}
