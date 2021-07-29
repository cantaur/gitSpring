<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Spring Board</title>
    <style>
        /*table, th, td {*/
        /*    border: 1px solid black;*/
        /*    border-collapse: collapse;*/
        /*}*/
        /*th, td {*/
        /*    padding: 5px;*/
        /*}*/
        a { text-decoration:none }
    </style>

    <script language="javascript">
        function check()
        {
            for(var i=0; i<document.input.elements.length; i++)
            {
                if(document.input.elements[i].value == "")
                {
                    alert("모든 값을 입력 하셔야 합니다. ");
                    return false;
                }
            }
            document.input.submit();
        }
    </script>
</head>

<body onload="input.writer.focus()">
<span style="color: gray; font-size: medium; ">
    <div style="text-align: center;">
        <hr width="600" size="2" color="gray" noshade>
        <h3>
            Simple Board with Spring
        </h3>

        <span style="color: gray; font-size: small; ">
            <a href='list.do'>list</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href='../'>index</a>
        </span>
        <hr width="600" size='2' color="gray" noshade>
    </div>


    <form name="input" method="post" action="write.do" enctype="multipart/form-data">
        <table border="0" width="600" align="center" cellpadding="3" cellspacing="1" bordercolor="gray">
            <tr>
                <td width="30%" align="center">WRITER</td>
                <td><input type="text" name="writer" size="67"></td>
            </tr>
            <tr>
                <td align="center">EMAIL</td>
                <td><input type="text" name="email" size="67"></td>
            </tr>
            <tr>
                <td align="center">SUBJECT</td>
                <td><input type="text" name="subject" size="67"></td>
            </tr>
            <tr>
                <td align="center">CONTENT</td>
                <td><textarea  name="content" rows="15" cols="70"></textarea></td>
            </tr>
            <tr>
                <td align="center">파일<br/>업로드</td>
                <td><input type="file" name="file" rows="15" cols="60"></input></td>
            </tr>



            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="전송" onclick="check()">
                    <input type="reset" value="다시입력" onclick="input.writer.focus()">
                </td>
            </tr>
        </table>
        <hr width="600" size="2" color="gray" noshade>
    </form>
</span>
</body>
</html>