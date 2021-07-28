package sp2.md.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sp2.md.domain.Board;
import sp2.md.domain.BoardFile;
import sp2.md.domain.BoardListResult;
import sp2.md.domain.BoardVo;
import sp2.md.mapper.BoardMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    //Setter Injection : @Autowired, @Resource... 등등등을 쓰지 않고 객체주입 하는 방법
    //생성자를 통해서 객체 주입, Spring 4.3 이상 AutoInjection( with @AllArgsConstructor)
    private BoardMapper boardMapper;

    @Override
    public BoardListResult getBoardListResult(int cp, int ps) {
        int totalCount = boardMapper.selectCount();

        BoardVo boardVo = new BoardVo(cp,ps);
        List<Board> list = boardMapper.list(boardVo);

        return new BoardListResult(cp, ps, totalCount, list);

    }

    @Override
    public Board getBoard(int seq) {
        Board board = boardMapper.select(seq);
        return board;
    }

    @Override
    public Board searchName(String sName) {
        Board board = boardMapper.searchName(sName);
        return board;
    }


    @Override
    public void insertS(BoardFile boardFile) {
        boardMapper.insert(boardFile);
    }

    @Override
    public boolean deleteS(int seq) {
        return boardMapper.delete(seq);
    }



    @Override
    public boolean updateS(Board board) {

        return boardMapper.update(board);
    }
}
