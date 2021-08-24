package spring.boot.backend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.boot.backend.filesetting.Path;

import java.io.File;

@Controller
@RequestMapping("rest_board")
public class Board4RestController {
    @GetMapping("/list.do")
    public String list() {
        return "rest_board/list";
    }
    @GetMapping("/write.do")
    public String write(){
        return "rest_board/write";
    }

    @GetMapping("/content.do")
    public String content(int seq){
        return "rest_board/content";
    }

    @GetMapping("download.do")
    public ModelAndView download(String fname){
        //넘어오는 파일이름으로 파일 객체를 생성해야함
        //페이지를 보고 있는 순간에 파일이 삭제되었지만 새로고침이 되지 않은 경우, 파일이 존재하지 않으므로, 파일 존재여부를 체크해야함
        File file = new File(Path.FILE_STORE, fname);
        if(file.exists()){
            return new ModelAndView("fileDownloadView", "downloadFile", file); //fileDownloadView: 스프링컨테이너에서 생성된 파일 객체
        }else{
            return new ModelAndView("redirect:list.do");
        }

    }

    @GetMapping("/update.do")
    public String update(int seq){

        return "rest_board/update";
    }

}
