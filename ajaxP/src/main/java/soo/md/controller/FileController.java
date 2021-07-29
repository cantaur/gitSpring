package soo.md.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.filesetting.Path;
import soo.md.service.FileUploadService;

@Log4j
@Controller
@RequestMapping("file")
@AllArgsConstructor
public class FileController {
	private FileUploadService service; //Spring 4.3~ : AutoInjection ( with @AllArgsConstructor )
	
	@GetMapping("form.do")
	public String formFu() {
		return "file/form";
	}
	@PostMapping("upload.do")
	public String upload(@RequestParam String name, @RequestParam MultipartFile file) {
		//log.info("#name: " +name + ", file: " + file);
		
		String ofname = file.getOriginalFilename();
		if(ofname != null) ofname = ofname.trim();
		if(ofname.length() != 0) {
			String url = service.saveStore(file);
			//log.info("#url: " + url);
		}
		
		return "redirect:list.do"; //저장소의 파일리스트를 보여주는 액션 (*.do)
	}
	
	@GetMapping("list.do")
	public ModelAndView fileList() {
		File fStore = new File(Path.FILE_STORE);
		if(!fStore.exists()) fStore.mkdirs();
		File files[] = fStore.listFiles();
		
		return new ModelAndView("file/list", "files", files);
	}
	@GetMapping("del.do")
	public String del(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) file.delete();
		
		return "redirect:list.do"; 
	}
	@GetMapping("download.do")
	public ModelAndView download(String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);
		}else {
			return new ModelAndView("redirect:list.do");
		}
	}
	@GetMapping("form_mt.do")
	public String formFuMt() {
		return "file/form_mt";
	}
	@PostMapping("upload_mt.do")
	public String uploadMt(ArrayList<MultipartFile> files) {
		//미션: (멀티파일업로드) 구현해 보시오 ( 힌트: 어렵게 생각하지마! )
		for(MultipartFile file: files) {
			String ofname = file.getOriginalFilename();
			if(ofname != null) ofname = ofname.trim();
			if(ofname.length() != 0) {
				String url = service.saveStore(file);
			}
		}
		
		return "redirect:list.do"; 
	}
}
