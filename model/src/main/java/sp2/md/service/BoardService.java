<<<<<<< HEAD
package sp2.md.service;

import sp2.md.domain.Board;
import sp2.md.domain.BoardListResult;

import java.util.List;

public interface BoardService {
    BoardListResult getBoardListResult(int cp, int ps);
    Board getBoard(int seq);
    Board searchName(String sName);

    void insertS(Board board);
    boolean updateS(Board board);
    boolean deleteS(int seq);
}
=======
package sp2.md.service;

import sp2.md.domain.Board;
import sp2.md.domain.BoardFile;
import sp2.md.domain.BoardListResult;

import java.util.List;

public interface BoardService {
    BoardListResult getBoardListResult(int cp, int ps);
    Board getBoard(int seq);
    Board searchName(String sName);

    void insertS(BoardFile boardFile);
    boolean updateS(Board board);
    boolean deleteS(int seq);
}
>>>>>>> 916c4f7880011f5e978dc9ee974f738de568f7c1
