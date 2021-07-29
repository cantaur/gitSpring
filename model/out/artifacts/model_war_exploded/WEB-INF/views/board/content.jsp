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
        td{
            text-align: left;
        }
        a { text-decoration:none }
    </style>

<div style="text-align: center;">
    <span style="color: gray; font-size: medium; ">
        <hr width='600' size='2' color='gray' noshade>
        <h3>Simple Board with Spring</h3>
    </span>

    <a href='write.do'>write</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='list.do'>list</a>
    <hr width='600' size='2' color='gray' noshade>
    <table border='2' width='600' align='center' noshade>

<%--        <c:forEach items="${select}" var="board">--%>
        <tr>
            <td width='20%' align='center'>No</td>
            <td>${select.seq}</td>
        </tr>
        <tr>
            <td width='20%' align='center'>Writer</td>
            <td>${select.writer}</td>
        </tr>
        <tr>
            <td width='20%' align='center'>E-mail</td>
            <td>${select.email}</td>
        </tr>
        <tr>
            <td width='20%' align='center'>Subject</td>
            <td>${select.subject}</td>
        </tr>
        <tr>
            <td width='20%' align='center'>Contents</td>
            <td>${select.content}</td>
        </tr>

    </table>

    <hr width='600' size='2' color='gray' noshade>
    <a href='update.do?seq=${select.seq}'>modify</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='del.do?seq=${select.seq}'>delete</a>

<%--    </c:forEach>--%>
    <hr width='600' size='2' color='gray' noshade>
</div>
</head>
</html>
