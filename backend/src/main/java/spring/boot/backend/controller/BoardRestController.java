package spring.boot.backend.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.backend.domain.Board;
import spring.boot.backend.domain.RestVo;
import spring.boot.backend.filesetting.Path;
import spring.boot.backend.service.BoardRestService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import spring.boot.backend.filesetting.Path;

@Log
@RestController
@RequestMapping("rest_board")

public class BoardRestController {
    @Autowired
    private BoardRestService boardService;


    @GetMapping(value = "getBoardlist", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> list(RestVo restVo, @RequestParam int page, String category, String searchStr) throws UnsupportedEncodingException {

        Map<String,Object> result = new HashMap<String, Object>();
        if(category == "") category = null;
        else category = URLDecoder.decode(category, "UTF-8");

        if(searchStr == "") searchStr = null;
        else searchStr = URLDecoder.decode(searchStr, "UTF-8");

        restVo.pageInfo(page, searchStr, category);
        int listCnt = boardService.getBoardListCnt(restVo);

        // 게시글 화면 출력

        result.put("list", boardService.selectBoard(restVo));
        result.put("listCnt",listCnt);

        return ResponseEntity.ok(result);
    }

    @GetMapping("content/{seq}")
    public Board content(@PathVariable int seq){
        Board board = boardService.getBoard(seq);
        return board;
    }

    @ResponseBody
    @RequestMapping("insert")
    public void write(
            @RequestParam("file") MultipartFile file,
            @RequestParam("writer") String writer,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("content") String content
    ){
        String ofileName = file.getOriginalFilename();
        log.info("#file"+ofileName);
        if(ofileName != null) ofileName=ofileName.trim();
        if(ofileName.length()!=0){
            Board board = new Board(-1, writer, email, subject, content, null, null, null, -1);
            String url = boardService.saveStore(file, board);
            log.info("url: "+url);
        }
    }


    @DeleteMapping("delete/{seq}")
    public void delete(@PathVariable int seq){
        boardService.deleteS(seq);
    }

    @ResponseBody
    @GetMapping("download/{fname}")
    public void doDownloadFile(@PathVariable("fname") String fname, HttpServletResponse response) throws IOException {

        log.info("파일 다운로드 프로세스");
        log.info("다운로드할 파이리명"+fname);
        File file = new File(Path.FILE_STORE, fname);
        log.info("피요오오옹"+file);

        response.setContentType("application/octer-stream");
        response.setContentLength((int)file.length()); //파일 객체의 길이
        String value = "attachment; filename="+java.net.URLEncoder.encode(file.getName(), "utf-8") + ";"; //브라우저에 넘겨주는 헤더 정보
        response.setHeader("Content-Disposition", value); //http 프로토콜에 정의된 데이터 전달 공간==header
        response.setHeader("Content-Transfer-Encoding", "binary;");

        OutputStream os = response.getOutputStream();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, os);
            os.flush();
        }catch(IOException ie) {
            log.info("#FileDownloadView ie: " + ie);
        }finally {
            if(fis != null) fis.close();
            if(os != null) os.close();
        }
    }



}