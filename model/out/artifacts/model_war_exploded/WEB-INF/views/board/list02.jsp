<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Spring Board</title>
    <script type="text/javascript" language="javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).on("click", "#seachOk", function(){


            var category = $("#category").val();
            var keyword = $("#inputKeyword").val();
            console.log(category)
            console.log(keyword)


            $.ajax({
                url: "../board/search.do",
                type: "POST",
                data: {
                    category:category,
                    keyword:keyword,

                },
                success: function(data){


                    $('.boardRow').remove();
                    // -> 요청에 성공하면 컨텐츠를 전부 지운다 (게시물리스트 + 결과없음 메시지)
                    // -> 컨텐츠 1열마다 boardRow 클래스를 지정하였음, jsp, ajax 동일
                    // -> 제이쿼리의 DOM.remove() 메소드 : DOM을 문서에서 삭제함

                    var html="";
                    if(data.length==0){ // 데이터가 없으면
                        $('#boradHead').after('<tr class="boardRow"><td align="center" colspan="5">검색결과가 없습니다.</td></tr>')
                        // -> #boradHead의 다음요소로 검색결과가 없다는 메시지를 추가한다.
                        // -> 제이쿼리의 DOM.after(tag) 메소드 : DOM의 다음(문서상 바로아래)에 tag를 추가함
                        // -> <td> 태그의 속성 colspan="" : td를 가로열로 병합 (2를 넣으면 2칸차지.. 5면 5칸)


                    }else { // 데이터가 있으면
                        for(let board of data){
                            html+="<tr class='boardRow'>" // 컨텐츠 1열마다 boardRow 클래스 지정
                            html+="<td align='center'>"+board.seq+"</td>"
                            html+="<td>"+board.writer+"</td>"
                            html+="<td>"+board.email+"</td>"
                            html+="<td><a href='content.do?seq="+board.seq+"'>"+board.subject+"</a></td>"
                            html+="<td>"+board.rdate+"</td>"
                            html+="</tr>"
                        }
                        $('#boradHead').after(html);
                        // -> #boradHead의 다음요소로 검색결과를 추가한다.
                    }

                    <%--<td align='center'>--%>
                    <%--    <a href='content.do?seq=${board.seq}'>${board.subject}--%>
                    <%--    </a></td>--%>
                    <%--<td align='center'>${board.rdate}</td>--%>
                }
            });
        });
    </script>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
        a { text-decoration:none }
    </style>
</head>
<body style="text-align:center">
<span style="color: gray; font-size: medium; ">
        <hr width='600' size='2' color='gray' noshade>
        <h3>
            Simple Board with Spring(임시)
        </h3>
    </span>
<a href='write.do'>write</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='..'>index</a>
<hr width='600' size='2' color='gray' noshade>
<TABLE border='2' width='600' align='center' noshade>
    <TR size='2' align='center' noshade bgcolor='AliceBlue' id="boradHead">
        <th bgcolor='AliceBlue'>NO</th>
        <th color='gray'>WRITER</th>
        <th color='gray'>E-MAIL</th>
        <th color='gray'>SUBJECT</th>
        <th color='gray'>DATE</th>
    </tr>


    <c:forEach items="${listResult.list}" var="board">
        <tr class="boardRow"> <!-- 게시판 컨텐츠 1열 -->
            <td align='center'>${board.seq}</td>
            <td>${board.writer}</td>
            <td>${board.email}</td>
            <td align='center'>
                <a href='content.do?seq=${board.seq}'>${board.subject}
                </a></td>
            <td align='center'>${board.rdate}</td>
        </tr>
    </c:forEach>
</table>


<hr width='600' size='2' color='gray' noshade>
<span style="color: gray; font-size: small;">
        (총페이지수 : ${listResult.totalPageCount})
        &nbsp;&nbsp;&nbsp;
        <c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
            <a href="list.do?cp=${i}">
                <c:choose>
                    <c:when test="${i==listResult.cp}">
                        <strong>${i}</strong>
                    </c:when>
                    <c:otherwise>
                        ${i}
                    </c:otherwise>
                </c:choose>
            </a>
        </c:forEach>

        ( TOTAL : ${listResult.totalCount} )
        페이지 싸이즈 :
        <select id="psId" name="ps" onchange="f(this)">
            <c:choose>
                <c:when test="${listResult.ps==3}">
                    <option value="3" selected>3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </c:when>
                <c:when test="${listResult.ps==5}">
                    <option value="3">3</option>
                    <option value="5" selected>5</option>
                    <option value="10">10</option>
                </c:when>
                <c:when test="${listResult.ps==10}">
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10" selected>10</option>
                </c:when>
            </c:choose>
        </select>
    </span>

<hr width='600' size='2' color='gray' noshade>

<%--        <form name="search" method="post" action="search.do">--%>
<select name="category" id="category">
    <option value="subject">제목</option>
    <option value="writer">글쓴이</option>
    <option value="content">내용</option>
</select>
<input type="text" name="keyword" id="inputKeyword" size="40" required="required"/>
<button type="button" id="seachOk">검색</button>
<%--        </form>--%>



<script language="javascript">
    function f(select){
        var ps = select.value;
        location.href="list.do?ps="+ps;
    }
</script>







</body>
</html>