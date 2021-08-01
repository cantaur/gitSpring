package sp2.md.service;

import org.springframework.web.multipart.MultipartFile;
import sp2.md.domain.Board;
import sp2.md.domain.BoardListResult;
import sp2.md.domain.RestVo;

import java.util.List;

public interface BoardService {

    List<Board> selectBoard(RestVo restVo);
    int getBoardListCnt(RestVo restVo);


    BoardListResult getBoardListResult(int cp, int ps);
    Board getBoard(int seq);
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
