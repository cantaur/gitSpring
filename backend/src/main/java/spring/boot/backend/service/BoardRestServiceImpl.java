package spring.boot.backend.service;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.backend.domain.Board;
import spring.boot.backend.domain.BoardListResult;
import spring.boot.backend.domain.BoardVo;
import spring.boot.backend.domain.RestVo;
import spring.boot.backend.filesetting.Path;
import spring.boot.backend.mapper.BoardRestMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Log
@Service
@AllArgsConstructor
public class BoardRestServiceImpl implements BoardRestService {
    //Setter Injection : @Autowired, @Resource... 등등등을 쓰지 않고 객체주입 하는 방법
    //생성자를 통해서 객체 주입, Spring 4.3 이상 AutoInjection( with @AllArgsConstructor)
    private BoardRestMapper boardMapper;

    @Override
    public List<Board> selectBoard(RestVo restVo) {
        return boardMapper.selectBoard(restVo);
    }
    @Override
    public int getBoardListCnt(RestVo restVo) {
        return boardMapper.getBoardListCnt(restVo);
    }





    @Override
    public BoardListResult getBoardListResult(int cp, int ps) {
        int totalCount = boardMapper.selectCount();
        BoardVo boardVo = new BoardVo(cp,ps);
        List<Board> list = boardMapper.list(boardVo);
        return new BoardListResult(cp, ps, totalCount, list);

    }
    @Override
    public Board getBoard(int seq) {
        Board board = boardMapper.select(seq);
        return board;
    }

    @Override
    public List<Board> searchName(String sName) {
        return boardMapper.searchName(sName);
    }
    @Override
    public List<Board> searchSubject(String subj) {
        return boardMapper.searchSubject(subj);
    }
    @Override
    public List<Board> searchContent(String content) {
        return boardMapper.searchContent(content);
    }


    @Override
    public void insertS(Board board) {
        boardMapper.insert(board);
    }

    @Override
    public void insert2S(Board board) {
    }
    @Override
    public boolean updateS(Board board) {
        return boardMapper.update(board);
    }
    @Override
    public boolean deleteS(int seq) {
        return boardMapper.delete(seq);
    }




    @Override
    public String saveStore(MultipartFile file, Board board) {
        String writer = board.getWriter();
        String email = board.getEmail();
        String subject = board.getSubject();
        String content = board.getContent();


        String ofname = file.getOriginalFilename(); //파일의 원래 이름 저장
        int idx = ofname.lastIndexOf("."); //뒤에서부터 맨 처음으로 dot(.)이 나오는 인덱스 찾음
        String ofheader = ofname.substring(0,idx); //파일이름만 추출
        String ext = ofname.substring(idx); //확장자 추출
        long ms = System.currentTimeMillis(); //현재 시스템 시간 받아오기

        //업로드될 파일이름 생성
        StringBuilder sb = new StringBuilder();
        sb.append(ofheader);
        sb.append("_");
        sb.append(ms);
        sb.append(ext);
        String saveFileName = sb.toString();

        long fsize = file.getSize(); //파일 size 구함
        log.info("#ofname: "+ofname);
        log.info("#saveFileName: "+saveFileName);
        log.info("#fsize: "+fsize);

        boolean flag = writeFile(file, saveFileName);
        if(flag){
            log.info("#업로드 성공");
            board = new Board(-1,writer,email,subject,content,null,saveFileName,ofname,fsize);
            boardMapper.insert2(board);
            return ofname;

        }else{
            log.info("#업로드 실패");
        }

        return Path.FILE_STORE + saveFileName;

    }

    @Override
    public boolean writeFile(MultipartFile file, String saveFileName) {
        File rootDir = new File(Path.FILE_STORE); //저장이 되는 root 디렉토리
        if(!rootDir.exists()){ //temp 디렉토리가 존재하지 않을 때 디렉토리 생성
            rootDir.mkdirs();
        }
        FileOutputStream fos = null;
        try {
            byte data[]=file.getBytes(); //파일을 byte단위로 쪼개는 메소드
            fos = new FileOutputStream(Path.FILE_STORE+saveFileName);
            fos.write(data);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        }finally {
            try {
                if(fos !=null) fos.close();
            }catch (IOException ie){}
        }

    }



}