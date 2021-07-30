package sp2.md.service;

import org.springframework.web.multipart.MultipartFile;
import sp2.md.domain.Board;
import sp2.md.domain.BoardListResult;
import sp2.md.domain.Search;

import java.util.List;

public interface BoardService {
    BoardListResult getBoardListResult(int cp, int ps);
    List<Board> selectBoard(Search search);
    List<Board> selectAll(Board board);
    Board getBoard(int seq);
    int getBoardListCnt(Search search);
    List<Board> searchName(String sName);
    List<Board> searchSubject(String subj);
    List<Board> searchContent(String content);


    void insertS(Board board);
    void insert2S(Board board);
    boolean updateS(Board board);
    boolean deleteS(int seq);

    String saveStore(MultipartFile file, Board board);
    boolean writeFile(MultipartFile file, String saveFileName);

}
