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
        td{
            text-align: left;
        }
        a { text-decoration:none }
    </style>
</head>
<div style="text-align: center;">
    <span style="color: gray; font-size: medium; ">
        <hr width='600' size='2' color='gray' noshade>
        <h3>Simple Board with Spring(ajax)</h3>
    </span>

    <a href='write.do'>write</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='list.do'>list</a>
    <hr width='600' size='2' color='gray' noshade>
    <table border='2' width='600' align='center' noshade>

<%--        <c:forEach items="${select}" var="board">--%>
        <tr>
            <td width='20%' align='center'>No</td>
            <td id="seq"></td>
        </tr>
        <tr>
            <td width='20%' align='center'>Writer</td>
            <td id="writer"></td>
        </tr>
        <tr>
            <td width='20%' align='center'>E-mail</td>
            <td id="email"></td>
        </tr>
        <tr>
            <td width='20%' align='center'>Subject</td>
            <td id="subject"></td>
        </tr>
        <tr>
            <td width='20%' align='center'>Contents</td>
            <td id="content"></td>
        </tr>

        <tr>
            <td width='20%' align='center'>File</td>
            <td id="file"><a href="download.do?fname=" download></a></td>
        </tr>

    </table>


    <a href='update.do?seq=' id="modify">modify</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:void(0)" data-seq="" id="delete">delete</a>

<%--    </c:forEach>--%>
    <hr width='600' size='2' color='gray' noshade>
</div>
<script>
    var seq = location.href.split('seq=')[1];
    console.log(seq)
    viewContent(seq)
    function viewContent(seq) {
        $.ajax({
            url: "../rest_board/content/" + seq + ".json", //서비스 주소
            success: function (res) {
                console.log(res)
                $('#seq').text(res['seq']);
                $('#writer').text(res['writer']);
                $('#email').text(res['email']);
                $('#subject').text(res['subject']);
                $('#content').text(res['content']);

                $('#file a').text(res['fname']);
                $('#file a').attr("href","download.do?fname=" + res['fname']);

                $('#modify').attr("href","update.do?seq=" + res['seq']);
                $('#delete').attr("data-seq",+ res['seq']);
            }
        })
    }

    function deleteContent(seq){
        var seq = seq;
        $.ajax({
            type: 'DELETE',
            url: "../rest_board/delete/"+seq,

            success: function(e){
                alert("게시글이 삭제되었습니다.");
                location.href = "../rest_board/list.do"
            }
        })
    }
    $(document).on('click', '#delete', function(){
        deleteContent($(this).attr('data-seq'))
    })
</script>

</html>
