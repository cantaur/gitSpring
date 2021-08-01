<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Spring Board</title>
    <script type="text/javascript" language="javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
        a { text-decoration:none }
        #pageLinkWrap {
            display:flex;
            width: 100%;
            flex-shrink:1;
            flex-wrap:wrap;
            justify-content:center
        }
        #pageLinkWrap span {
            display:inline-block;
            background-color:#fff;
            border:1px solid #ccc;
            border-radius:4px;
            padding:2px 4px;
            color:#555;
            margin:2px;
            cursor:pointer;
            user-select:none;
        }
        #pageLinkWrap span:hover{
            background-color:#f2f2f2;
        }
        #pageLinkWrap span.crt{
            background-color:#333 !important;
            color:#fff;
            border-color:#333;
            cursor:default;
        }
    </style>
</head>
<body style="text-align:center">
<span style="color: gray; font-size: medium; ">
        <hr width='600' size='2' color='gray' noshade>
        <h3>
            Simple Board with Spring(ajax)
        </h3>
    </span>
<a href='write.do'>write</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='../'>index</a>
<hr width='600' size='2' color='gray' noshade>
<TABLE border='2' width='600' align='center' noshade>
    <TR size='2' align='center' noshade bgcolor='AliceBlue' id="boradHead">
        <th bgcolor='AliceBlue'>NO</th>
        <th color='gray'>WRITER</th>
        <th color='gray'>E-MAIL</th>
        <th color='gray'>SUBJECT</th>
        <th color='gray'>DATE</th>
    </tr>

</table>


<hr width='600' size='2' color='gray' noshade>
<div style="display:flex; justify-content:center; width:100%">
    <div style="color: gray; font-size: small; display:flex; justify-content:space-between; align-items:center; width:600px">
        <div style="flex-shrink:0">총 페이지 수 : <span id="pageCnt"></span></div>
        <div id="pageLinkWrap">

        </div>
        <div style="flex-shrink:0">TOTAL : <span id="listCnt"></span></div>
    </div>
</div>

<hr width='600' size='2' color='gray' noshade>

<select name="category" id="category">
    <option value="subject" selected>제목</option>
    <option value="writer">글쓴이</option>
    <option value="content">내용</option>
</select>
<input type="text" name="keyword" id="searchStr" size="40"/>
<button type="button" id="searchBtn">검색</button>

<input type="hidden" id="searchStrDummy">
<input type="hidden" id="categoryDummy" value="subject">



<script language="javascript">

    $(function(){
        getPage(1, '', '')
    })


    $(document).on('click', '#pageLinkWrap .link', function(){
        getPage(Number($(this).text()), $('#searchStrDummy').val(), $('#categoryDummy').val())
    })

    $(document).on('change', '#category', function(){
        $('#categoryDummy').val($('#category option:selected').val())
    })

    $(document).on('click', '#searchBtn', function(){
        $('#searchStrDummy').val($('#searchStr').val())
        searchEvent();
    })
    $(document).on('keyup', '#searchStr', function(e){
        if(e.keyCode == 13){
            $('#searchBtn').trigger('click')
        }
    })

    function searchEvent(){
        var searchStr = $('#searchStrDummy').val();
        var category = $('#categoryDummy').val();
        getPage(1, searchStr, category)
    }


    function getPage(page, searchStr, category) {
        $.ajax({
            url : "../rest_board/getBoardlist.do", //서비스 주소
            data : { //서비스 처리에 필요한 인자값
                page : page,
                searchStr: searchStr,
                category: category,
            },
            success : function(res) {
                history.replaceState({}, null, location.pathname);
                $('.boardRow').remove();
                $('#pageLinkWrap span').remove();

                var html = "";
                var list = res['list'];
                var listCnt = Number(res['listCnt'])
                var pageCnt = Math.round(listCnt/10)
                var pageSize = 5;

                $('#listCnt').text(listCnt);

                if(pageCnt == 0){
                    $('#pageCnt').text('1');
                    $('#pageLinkWrap').append('<span class="crt">1</span>')
                }else {
                    $('#pageCnt').text(pageCnt)
                }

                if(list.length == 0){
                    html+='<tr class="boardRow"><td align="center" colspan="5">검색결과가 없습니다.</td></tr>'
                    $('#pageLinkWrap span').remove();
                    $('#pageCnt').text('0');
                } else {
                    for(var board of list){
                        html+="<tr class='boardRow'>" // 컨텐츠 1열마다 boardRow 클래스 지정
                        html+="<td align='center'>"+board.seq+"</td>"
                        html+="<td>"+board.writer+"</td>"
                        html+="<td>"+board.email+"</td>"
                        html+="<td><a href='content.do?seq="+board.seq+"'>"+board.subject+"</a></td>"
                        html+="<td>"+board.rdate+"</td>"
                        html+="</tr>"
                    }
                }

                $('#boradHead').after(html)

                if(page != 1) {
                    $('#pageLinkWrap').append('<span class="link">'+(page-1)+'</span>')
                }
                for(i=0; i<pageSize; i++){
                    var classNm ='';
                    i==0?classNm=' class="crt"':classNm=' class="link"';
                    if(page+i <= pageCnt) {
                        $('#pageLinkWrap').append('<span'+classNm+'>'+(page+i)+'</span>')
                    }

                }
            }
        })
    }
</script>







</body>
</html>