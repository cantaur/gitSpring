<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Title</title>
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

<body onload="input.name.focus()">
<div style="text-align: center;">

  <h1>
    Address Input with Spring5
  </h1>
  <form name="input" action="write.do" method="post" style="display: flex; justify-content: center;">
    <table border="1" width="300" height="200">
      <tr>
        <td width="30%" colspan="2" align="center"><h2>입력폼</h2></td>
      </tr>
      <tr>
        <th width="30%">이름</th>
        <td><input name="name" align="center" size="20" align="center"></td>
      </tr>
      <tr>
        <th width="30%">주소</th>
        <td><input name="addr" size="20" align="center"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="button" value="전송" onclick="check()">
          <input type="reset" value="취소" onclick="input.writer.focus()">
        </td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>