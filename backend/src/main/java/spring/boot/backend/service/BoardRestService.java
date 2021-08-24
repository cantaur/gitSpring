package spring.boot.backend.service;

import org.springframework.web.multipart.MultipartFile;
import spring.boot.backend.domain.Board;
import spring.boot.backend.domain.BoardListResult;
import spring.boot.backend.domain.RestVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface BoardRestService {

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



    void doDownloadFile(HttpServletResponse response, File file) throws IOException;
}
