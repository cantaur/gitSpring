package sp2.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class BoardListResult {
    private int cp;
    private int ps; //페이지 사이즈
    private int totalCount; //전체 글의 갯수
    private List<Board> list;
    private int totalPageCount; //총 페이지 갯수, 얘는 계산해야돼
    private Board board;

    public BoardListResult(int cp, int ps, int totalCount, List<Board> list){
        this.cp = cp;
        this.ps = ps;
        this.totalCount = totalCount;
        this.list = list;
        //this.board = board;
        this.totalPageCount = calTotalPageCount();
    }

    private int calTotalPageCount(){ //총 페이지갯수 구하는 로직
        int tpc = totalCount/ps;

        if(totalCount%ps !=0){ //만약 페이지수가 딱 나눠떨어지지 않으면(나머지가 있다면) 페이지 수를 1 더해줘야 한다
            tpc++;
        }
        return tpc;
    }


}
