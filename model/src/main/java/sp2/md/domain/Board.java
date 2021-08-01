package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor //파라미터가 없는 생성자
@AllArgsConstructor //파라미터가 있는 생성자
public class Board {
    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private String rdate;
    private String fname;
    private String ofname;
    private long fsize;




}
