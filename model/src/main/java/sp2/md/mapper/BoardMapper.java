package sp2.md.mapper;

import org.springframework.stereotype.Repository;
import sp2.md.domain.Board;
import sp2.md.domain.BoardVo;

import java.util.List;

@Repository
public interface BoardMapper {
    List<Board> list(BoardVo boardVo);

    Board select(int seq);

    int selectCount();

    void insert(Board board);

    void insert2(Board board);

    boolean update(Board board);

    boolean delete(int seq);

    List<Board> searchName(String sName);


}