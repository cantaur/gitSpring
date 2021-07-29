package sp2.md.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sp2.md.domain.Address;
import sp2.md.domain.Board;
import sp2.md.domain.BoardListResult;
import sp2.md.service.BoardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor //AutoInjection 하기 위해
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list.do")
    public ModelAndView list(HttpServletRequest request, HttpSession session){ //getParameter 메소드와 session에 저장되어 있는 값을 사용하기 위해
        String cpStr = request.getParameter("cp"); //클라이언트로부터 받음
        String psStr = request.getParameter("ps"); //클라이언트로부터 받음

        //(1) cp, 현재 페이지수 구하기
        int cp = 1;
        if(cpStr == null) { //case1) 클라이언트로부터 들어온 값이 없을 때
            Object cpObj = session.getAttribute("cp"); //case1) 기존 session scope에 저장된 값이 있는지 검색
            if(cpObj != null) {
                cp = (Integer)cpObj; //case1) session의 cp값을 저장
            }
        }else { //case2) 클라이언트로부터 들어온 값이 있을 때
            cpStr = cpStr.trim();
            cp = Integer.parseInt(cpStr);
        }
        session.setAttribute("cp", cp); //새로운 cp를 저장하여 session scope에 셋팅

        //(2) page size, 1page에 보여질 게시물 수 구하기
        int ps = 3;
        if(psStr == null) { //case1) 클라이언트로부터 들어온 값이 없을 때
            Object psObj = session.getAttribute("ps"); //case1) 기존 session scope에 저장된 값이 있는지 검색
            if(psObj != null) {
                ps = (Integer)psObj; //case1) session에 저장되어있던 값을 ps에 저장
            }
        }else { //case2) 클라이언트로부터 들어온 값이 있을 때
            psStr = psStr.trim();
            int psParam = Integer.parseInt(psStr); // case2) 그 값을 저장하고, session에서 저장된 값이 있는지 검색
            Object psObj = session.getAttribute("ps");

            if(psObj != null) { //case2) session에 저장된 값이 있다면, 클라이언트로부터 넘어온 값과 서로 비교함
                int psSession = (Integer)psObj;
                if(psSession != psParam) { //case2) 비교했는데 둘이 값이 다르다면(==page size가 바뀌게 되면) 기존 ps의 의미가 사라지므로 맨 첫번째 페이지로 보내버림
                    cp = 1;
                    session.setAttribute("cp", cp); 
                }
            }else { //case2) session에 저장된 값이 없다면 디폴트값과 비교해서 다르면 1페이지로 보내버림
                if(ps != psParam) {
                    cp = 1;
                    session.setAttribute("cp", cp);
                }
            }
            ps = psParam; //case2) 클라이언트로부터 받아온 값을 ps에 저장
        }
        session.setAttribute("ps", ps); //새로운 ps를 저장하여 session scope에 셋팅

        //(3) ModelAndView

        BoardListResult listResult = boardService.getBoardListResult(cp, ps);
        ModelAndView modelAndView = new ModelAndView("board/list", "listResult", listResult);
        if(listResult.getList().size() == 0) { //현재 페이지의 글 갯수가 0일 때
            if(cp>1)
                return new ModelAndView("redirect:list.do?cp="+(cp-1)); //한 페이지 앞으로 이동해라
            else 
                return new ModelAndView("board/list", "listResult", null); //하필 마지막 페이지가 1페이지인 경우엔 null을 반환해라
        }else {
            return modelAndView;
        }
    }

    @PostMapping("/list.do")
    public ModelAndView searchName(HttpServletRequest request, HttpSession session){
        String sName = request.getParameter("keyword");
        String nameCate = request.getParameter("category");

        System.out.println("넘어왔는가??"+sName);
        System.out.println("카테고리"+nameCate);

        Board search = boardService.searchName(sName);
        ModelAndView modelAndView = new ModelAndView("board/list", "search", search);
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

    @GetMapping("/content.do")
    public ModelAndView content(int seq){
        Board select = boardService.getBoard(seq);
        ModelAndView modelAndView = new ModelAndView("board/content", "select", select);
        return modelAndView;
    }

    @GetMapping("/update.do")
    public ModelAndView update(int seq){
        Board select = boardService.getBoard(seq);
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

    @GetMapping("/del.do")
    public ModelAndView delete(int seq){
        boolean flag = false;
        flag = boardService.deleteS(seq);
        ModelAndView modelAndView = new ModelAndView("board/delete", "flag", flag);
        return modelAndView;
    }

}