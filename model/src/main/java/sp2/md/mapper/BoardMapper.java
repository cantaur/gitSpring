package sp2.md.mapper;

import org.springframework.stereotype.Repository;
import sp2.md.domain.Board;

import java.util.List;

@Repository
public interface BoardMapper {
    List<Board> list();

    void insert(Board board);

    boolean delete(int seq);

    Board select(int seq);

    boolean update(Board board);

//    void update(Board board);
}