package spring.boot.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring.boot.backend.domain.Board;
import spring.boot.backend.domain.BoardVo;
import spring.boot.backend.domain.RestVo;

import java.util.List;

@Mapper
@Repository
public interface BoardRestMapper {
    List<Board> list(BoardVo boardVo);


    List<Board> selectBoard(RestVo search);


    Board select(int seq);

    int getBoardListCnt(RestVo search);

    int selectCount();

    void insert(Board board);

    void insert2(Board board);

    boolean update(Board board);

    boolean delete(int seq);

    List<Board> searchName(String sName);

    List<Board> searchSubject(String subj);

    List<Board> searchContent(String content);


}