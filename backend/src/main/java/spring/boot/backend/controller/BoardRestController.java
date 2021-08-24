package spring.boot.backend.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.backend.domain.Board;
import spring.boot.backend.domain.RestVo;
import spring.boot.backend.service.BoardRestService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

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
}