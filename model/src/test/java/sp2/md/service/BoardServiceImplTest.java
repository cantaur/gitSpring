package sp2.md.service;

import junit.framework.TestCase;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sp2.md.domain.Board;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml")
public class BoardServiceImplTest extends TestCase {
    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void searchName(){

        String sName="전";
        log.info("#MapperTests Mapper: "+boardService);
        log.info("#MapperTests testList(): "+boardService.searchName(sName));

    }

//    @Test
//    public void testListS() {
//        log.info("#MapperTests Mapper: "+boardService);
//        log.info("#MapperTests testList(): "+boardService.listS());
//    }

//    @Test
//    public void testInsertS() {
//        Board board = new Board(-1, "이가은", "attackmood@gmail.com", "안녕", "하세요", null);
//        boardService.insertS(board);
//        log.info("수행 성공");
//    }
//
//    @Test
//    public void testDeleteS() {
//        int seq=1;
//        boardService.deleteS(seq);
//        log.info("수행 성공");
//    }

//        @Test
//        public void testSelectS(){
//            int seq=1;
//            log.info("#MapperTests Mapper: "+boardService);
//            log.info("#MapperTests testList(): "+boardService.selectS(seq));
//            boardService.selectS(seq);
//            log.info("수행성공");
//        }



}