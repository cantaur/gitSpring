<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fileupload Form</title>
    <style>
        a{text-decoration:none}
    </style>
</head>
<body style="text-align:center">

<h1>Fileupload Form</h1>
<form action="upload.do" method="post" enctype="multipart/form-data">
    이름: <input name="name"><br/><br/>
    파일: <input type='file' name='file'><br/><br/>
    <input type='submit' value="전송">
</form>

</body>
</html>
<%--enctype="multipart/form-data"
인코딩 타입을 반드시 명시해줘야 함--%>