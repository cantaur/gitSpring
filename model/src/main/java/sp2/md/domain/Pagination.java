package sp2.md.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor //파라미터가 없는 생성자
@AllArgsConstructor //파라미터가 있는 생성자
public class Pagination {

    private int listSize = 2; //한 페이지당 보여질 글목록의 개수
    private int page; // 현재목록의 페이지 번호
    private int listCnt; // 전체 개시물의 개수
    private int pageCnt; // 전체 페이지 범위의 개수
    private int startList; // 게시판 시작번호
    private String searchStr; // 검색어
    private String category; // 검색조건


    // 첫번째 파라미터변수 page 는 현재 페이지 번호,
    // 두번째 인자 range 는 현재 페이지 범위의 시작 페이지 번호,
    // 세번째 인자 listCnt는 게시물의 총 개수
    public void pageInfo(int page, int listCnt, String searchStr, String category) {
        this.page = page;
        this.listCnt = listCnt;
        this.searchStr = searchStr;
        this.category = category;

        // 전체 페이지 갯수
        this.pageCnt = (int) Math.ceil((double) listCnt / listSize);

        // 게시판 시작번호
        this.startList = (page - 1) * listSize;
//        this.startList = page;



    }
}
