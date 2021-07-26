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


        <c:forEach items="${list}" var="board">
            <tr>
                <td align='center'>${board.seq}</td>
                <td>${board.writer}</td>
                <td>${board.email}</td>
                <td align='center'>
                    <a href='select.do?seq=${board.seq}'>${board.subject}
                    </a></td>
                <td align='center'>${board.rdate}</td>
            </tr>
        </c:forEach>
    </table>
    <hr width='600' size='2' color='gray' noshade>
    <span style="color: gray; font-size: small;">
        (총페이지수 : 3)
        <a href="list.do?cp=1">
            <strong>1</strong>
        </a>&nbsp;

        <a href="list.do?cp=2">
            2
        </a>&nbsp;

        <a href="list.do?cp=3">
            3
        </a>&nbsp;

        ( TOTAL : 9 )
        페이지 싸이즈 :
        <select id="psId" name="ps" onchange="f(this)">
            <option value="3" selected>3</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select>

        <script language="javascript">
            function f(select){
                //var el = document.getElementById("psId");
                var ps = select.value;
                //alert("ps : " + ps);
                location.href="list.do?ps="+ps;
            }
        </script>

    </span>
    <hr width='600' size='2' color='gray' noshade>
</body>
