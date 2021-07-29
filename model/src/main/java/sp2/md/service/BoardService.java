package sp2.md.service;

import org.springframework.web.multipart.MultipartFile;
import sp2.md.domain.Board;
import sp2.md.domain.BoardListResult;

import java.util.List;

public interface BoardService {
    BoardListResult getBoardListResult(int cp, int ps);
    Board getBoard(int seq);
    Board searchName(String sName);

    void insertS(Board board);
    void insert2S(Board board);
    boolean updateS(Board board);
    boolean deleteS(int seq);

    String saveStore(MultipartFile file, Board board);
    boolean writeFile(MultipartFile file, String saveFileName);

}
