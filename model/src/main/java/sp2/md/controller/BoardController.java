package sp2.md.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sp2.md.domain.Address;
import sp2.md.domain.Board;
import sp2.md.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list.do")
    public ModelAndView list(){
        List<Board> list = boardService.listS();
        ModelAndView modelAndView = new ModelAndView("board/list", "list", list);

        return modelAndView;
    }
    @GetMapping("/write.do")
    public String write(){ //string일 때는 jsp의 페이지 이름을 찾게 되어있다

        return "board/write";
    }

    @PostMapping("/write.do")
    public String write(Board board){
        boardService.insertS(board);
        return "redirect:list.do";
    }

    @GetMapping("/select.do")
    public ModelAndView select(int seq){
        Board select = boardService.selectS(seq);
        ModelAndView modelAndView = new ModelAndView("board/content", "select", select);
        return modelAndView;
    }

    @GetMapping("/del.do")
    public ModelAndView delete(int seq){
        boolean flag = false;
        flag = boardService.deleteS(seq);
        ModelAndView modelAndView = new ModelAndView("board/delete", "flag", flag);
        return modelAndView;
    }

    @GetMapping("/update.do")
    public ModelAndView update(int seq){
        Board select = boardService.selectS(seq);
        ModelAndView modelAndView = new ModelAndView("board/update", "select", select);
        return modelAndView;
    }

    @PostMapping("/update.do")
    public ModelAndView update(Board board){
        boolean flag = false;
        flag = boardService.updateS(board);

        ModelAndView modelAndView = new ModelAndView("board/modify", "flag", flag);
        return modelAndView;
    }


}
