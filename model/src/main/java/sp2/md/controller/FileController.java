package sp2.md.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sp2.md.filesetting.Path;
import sp2.md.service.FileUploadService;

import java.io.File;
import java.util.ArrayList;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("file")
public class FileController {

    private FileUploadService fileUploadService;


    @GetMapping("form.do")
    public String fileUploadForm(){
        return "file/form"; //jsp를 찾아간다
    }


    @PostMapping("upload.do")
    public String upload(String name, MultipartFile file){
//        log.info("#name"+name);
//        log.info("#file"+file);
        String ofileName = file.getOriginalFilename(); //파일이 중복될 경우에 씀
        log.info("#file"+ofileName);
        if(ofileName != null) ofileName=ofileName.trim();
        if(ofileName.length()!=0){
            String url = fileUploadService.saveStore(file);
            log.info("url: "+url);
        }

        return "redirect:list.do"; //저장소의 파일리스트를 보여주는 액션(*.do)
    }

    @GetMapping("list.do")
    public ModelAndView fileList(){
        File fStore = new File(Path.FILE_STORE);
        if(!fStore.exists()) fStore.mkdirs();
        File files[]=fStore.listFiles();
        return new ModelAndView("file/list", "files",files);
    }

    @GetMapping("del.do")
    public String del(@RequestParam String fname){
        File file = new File(Path.FILE_STORE, fname); //(부모, 자식), 삭제하려는 대상 파일
        if(file.exists()) file.delete();
        return "redirect:list.do";
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

    @GetMapping("form_mt.do")
    public String multiUploadForm(){
        return "file/form_mt";
    }

    @PostMapping("upload_mt.do")
    public String uploadMulti(ArrayList<MultipartFile> files){

        log.info("#file"+files);
        for(MultipartFile file:files){
            String ofileName = file.getOriginalFilename();
            log.info("#file"+ofileName);
            if(ofileName != null) ofileName=ofileName.trim();
            if(ofileName.length()!=0){
                String url = fileUploadService.saveStore(file);
                log.info("url: "+url);
            }
        }
        return "redirect:list.do";
    }
}
