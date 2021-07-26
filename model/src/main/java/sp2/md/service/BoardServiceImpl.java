package sp2.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp2.md.domain.Board;
import sp2.md.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> listS() {
        return boardMapper.list();
    }

    @Override
    public void insertS(Board board) {
        boardMapper.insert(board);
    }

    @Override
    public boolean deleteS(int seq) {
        return boardMapper.delete(seq);
    }

    @Override
    public Board selectS(int seq) {
        boardMapper.select(seq);
        return boardMapper.select(seq);
    }

    @Override
    public boolean updateS(Board board) {

        return boardMapper.update(board);
    }
}
