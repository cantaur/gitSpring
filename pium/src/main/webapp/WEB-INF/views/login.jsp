<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <meta
            name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <title>Document</title>
</head>
<body>
<fieldset>
    <legend>로그인</legend>
    <form action="/private" method="post">
        <input type="text" name="username" placeholder="아이디를 입력 해 주세요." />
        <br />
        <input type="password" name="password" placeholder="비밀번호를 입력 해 주세요." />
        <br />
        <button type="submit">로그인</button>
    </form>
</fieldset>
</body>
</html>