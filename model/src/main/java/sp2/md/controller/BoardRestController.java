package sp2.md.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp2.md.domain.Search;
import sp2.md.service.BoardService;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    public ResponseEntity<Map<String, Object>> list(Search search, @RequestParam(required = false, defaultValue = "1") int page, String category, String searchStr) throws UnsupportedEncodingException {

        Map<String,Object> result = new HashMap<String, Object>();
        if(category == ""){
            category = null;
        } else {
            category = URLDecoder.decode(category, "UTF-8");
        }
        if(searchStr == ""){
            searchStr = null;
        } else {
            searchStr = URLDecoder.decode(searchStr, "UTF-8");

        }

        search.pageInfo(page, searchStr, category);

        int listCnt = boardService.getBoardListCnt(search);




        // 게시글 화면 출력

        result.put("list", boardService.selectBoard(search));
        result.put("listCnt",listCnt);

        return ResponseEntity.ok(result);
    }//http://127.0.0.1:8080/rest_addr/read.json


}