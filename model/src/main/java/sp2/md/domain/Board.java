package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private String rdate;


}

