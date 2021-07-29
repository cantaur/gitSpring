<<<<<<< HEAD
package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



}

=======
package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor //파라미터가 없는 생성자
@AllArgsConstructor //파라미터가 있는 생성자
public class Board {
    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
    private String fname;
    private String ofname;
    private long fsize;

}




>>>>>>> 916c4f7880011f5e978dc9ee974f738de568f7c1
