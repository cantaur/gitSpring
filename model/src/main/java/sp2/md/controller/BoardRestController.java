package sp2.md.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp2.md.domain.Search;
import sp2.md.service.BoardService;

import java.util.HashMap;
import java.util.Map;

@Log4j
@RestController
@RequestMapping("rest_board")
@AllArgsConstructor
public class BoardRestController {
    private BoardService boardService;




    @RequestMapping(value = "getBoardlist.do", produces = "application/json")
//    @GetMapping(value = "getBoardlist", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> list(Search search, @RequestParam(required = false, defaultValue = "1") int page, String category, String searchStr)  {

        Map<String,Object> result = new HashMap<String, Object>();
        log.info(searchStr + "aaaa");
        log.info(category + "aaaa");
        log.info(search + "zzzz");

        int listCnt = boardService.getBoardListCnt(search);

        //전체 게시글 갯수를 얻어와 listCnt에 저장
        search.pageInfo(page, listCnt, searchStr, category);


        // 게시글 화면 출력
        log.info(search + "aaaa");
        log.info(boardService.selectBoard(search) + "eeee");

        result.put("list", boardService.selectBoard(search));
        result.put("listCnt",listCnt);

        return ResponseEntity.ok(result);
    }//http://127.0.0.1:8080/rest_addr/read.json


}