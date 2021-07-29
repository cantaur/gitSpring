<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Spring Board</title>
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
            Simple Board with Spring
        </h3>
    </span>
    <a href='write.do'>write</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='../'>index</a>
    <hr width='600' size='2' color='gray' noshade>
    <TABLE border='2' width='600' align='center' noshade>
        <TR size='2' align='center' noshade bgcolor='AliceBlue'>
            <th bgcolor='AliceBlue'>NO</th>
            <th color='gray'>WRITER</th>
            <th color='gray'>E-MAIL</th>
            <th color='gray'>SUBJECT</th>
            <th color='gray'>DATE</th>
        </tr>


        <c:forEach items="${listResult.list}" var="board">
            <tr>
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

        <form name="search" method="post" action="list.do">
          <select name="category">
            <option value="subject">제목</option>
            <option value="writer">글쓴이</option>
            <option value="content">내용</option>
          </select>
          <input type="text" name="keyword" size="40" required="required"/>
          <button>검색</button>
        </form>

    <script language="javascript">
        function f(select){
            var ps = select.value;
            location.href="list.do?ps="+ps;
        }
    </script>
</body>
</html>