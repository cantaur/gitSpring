package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.multipart.MultipartFile;
import sp2.md.service.FileUploadService;
import sp2.md.service.FileUploadServiceImpl;

import java.sql.Date;

@Log4j
@Data
@NoArgsConstructor //파라미터가 없는 생성자
@AllArgsConstructor //파라미터가 있는 생성자
public class BoardFile {

    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
    private String fname;
    private String ofname;
    private long fsize;
    private MultipartFile uploadFile;

    public BoardFile(String fname, String ofname, long fsize){
        this.fname=fname;

        this.ofname=getOfname(file);
        this.fsize=fsize;


    }

    public MultipartFile getUploadFile(){
        return uploadFile();
    }
    public setUploadFile(MultipartFile uploadFile){
        this.uploadFile=uploadFile;
    }

}
