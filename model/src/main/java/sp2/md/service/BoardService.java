package sp2.md.service;

import sp2.md.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> listS();
    void insertS(Board board);
    boolean deleteS(int seq);
    Board selectS(int seq);
    boolean updateS(Board board);

}
