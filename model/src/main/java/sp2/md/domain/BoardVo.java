package sp2.md.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
    //클라이언트에게 받는 정보
    private int cp; //페이지 번호
    private int ps; //페이지 사이즈
    {
        cp=1;
        ps=5;
        //초기화
    }


    //마바티스에게 넘겨주는 정보
    public int getStartRow(){
        return (cp-1)*ps;
    }
    public int getEndRow(){
        return cp*ps;
    }
}
