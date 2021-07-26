package sp2.md.mapper;

import junit.framework.TestCase;
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
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testList() {
        log.info("#MapperTests Mapper: " + boardMapper);
        log.info("#MapperTests testList(): " + boardMapper.list());
    }

//    @Test
//    public void testInsert() {
//        Board board = new Board(-1, "이가은", "attackmood@gmail.com", "안녕", "하세요", null);
//        boardMapper.insert(board);
//        log.info("수행 성공");
//    }
//
//    @Test
//    public void testDelete() {
//        int seq=1;
//        boardMapper.delete(seq);
//        log.info("수행 성공");
//    }


//    @Test
//    public void testSelect(){
//        int seq=1;
//        log.info("#MapperTests Mapper: "+boardMapper);
//        log.info("#MapperTests testList(): "+boardMapper.select(seq));
//        boardMapper.select(seq);
//        log.info("수행성공");
//    }

}