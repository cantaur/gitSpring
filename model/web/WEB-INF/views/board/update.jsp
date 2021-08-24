<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

  <meta charset='utf-8'>
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

<div style="text-align: center;">
  <hr width='600' size='2' color='gray' noshade>
  <span style="color: gray; font-size: medium; ">
        <h3>
            Simple Board with Spring
        </h3>
  </span>
  <span style="color: gray; font-size: small; ">
    <a href='list.do'>list</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='../../../../../../../model/web/WEB-INF/views'>index</a><br/>
  </span>
  <hr width='600' size='2' color='gray' noshade>
</div>

<form name='f' method='post' action='update.do'>
  <table border='0' width='500' align='center' cellpadding='3' cellspacing='1' bordercolor='gray'>


    <input type='hidden' name='seq' value='${select.seq}'>

    <tr>
      <td width='20%' align='center'>WRITER</td>
      <td>
        <input type='text' name='writer' readonly value='${select.writer}' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>EMAIL</td>
      <td><input type='text' name='email' value='${select.email}' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>SUBJECT</td>
      <td><input type='text' name='subject' value='${select.subject}' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>CONTENT</td>
      <td><textarea id='ta' name='content' rows='15' cols='60'>${select.content}</textarea>
      </td>
    </tr>
    <tr>
      <td width='20%' align='center'>FILE</td>
      <td>${select.fname}</td>
    </tr>
    <tr>
      <td align='center'>파일<br/>수정</td>
      <td><input type='file' name='file' size='67'/>
      </td>
    </tr>



    <tr>
      <td colspan='2' align='center'>
        <input type='submit' value='modify'>
      </td>
    </tr>
  </table>


  <hr width='600' size='2' color='gray' noshade>
</form>
</body>
</html>

