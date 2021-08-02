package soo.md.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import soo.md.service.DragdropService;

import java.util.List;
import java.util.Map;

@Log4j
@Controller
@RequestMapping("file")
public class DragdropController {



    @GetMapping("form_dd.do")
    public  String form(){
        return "drag_drop/form";
    }


    @Autowired
    private DragdropService service;
    @PostMapping("fileUpload.do")
    public String fileUpload(MultipartHttpServletRequest request){//MultipartFiles 와 다른 방식
        //파일 업로드 서비스 메소드 호출

        service.setMultipartRequest(request);

        Map<String, List<Object>> map = service.getUpdateFileName();
        log.info("DragdropController map"+map);
        String appendData = request.getParameter("temp");
        log.info("appendData");

        return "redirect:list.do";

    }
}
