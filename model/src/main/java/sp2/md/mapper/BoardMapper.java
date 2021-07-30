package sp2.md.mapper;

import org.springframework.stereotype.Repository;
import sp2.md.domain.Board;
import sp2.md.domain.BoardVo;
import sp2.md.domain.Search;

import java.util.List;

@Repository
public interface BoardMapper {
    List<Board> list(BoardVo boardVo);

    List<Board> selectAll(Board board);
    List<Board> selectBoard(Search search);


    Board select(int seq);

    int getBoardListCnt(Search search);

    int selectCount();

    void insert(Board board);

    void insert2(Board board);

    boolean update(Board board);

    boolean delete(int seq);

    List<Board> searchName(String sName);

    List<Board> searchSubject(String subj);

    List<Board> searchContent(String content);


}