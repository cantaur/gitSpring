<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sp01 Index</title>
</head>
<body style="text-align:center">
<h1>
    Sp01 for Spring MVC Controller
</h1>

<p>
    <a href="test/">m01</a>
    <a href="test/base1">m02</a>
    <a href="test/base2">m03</a>
    <a href="test/base3">m04</a>
    <a href="test/form">form</a>
</p>
<p>
    <a href="test/param1?name=홍길동&age=27">m05</a>
    <a href="test/param2?name=이순신&age=28">m06</a>
    <a href="test/param3?names=강감찬&names=이순신&names=유관순">m07</a>
    <a href="test/param4?ns=강감찬&ns=이순신&ns=유관순">m08</a>
    <a href="test/param5?names=강감찬&names=이순신&names=유관순">m09</a>
</p>
<p>
    <!--
    <a href="test/param6?list[0].name=홍길동&list[0].age=27&list[1].name=이순신&list[1].age=28">m10</a>
    [ -> %5B
    ] -> %5D
     -->
    <a href="test/param6?list%5B0%5D.name=홍길동&list%5B0%5D.age=27&list%5B1%5D.name=이순신&list%5B1%5D.age=28">m10</a>
    <a href="test/param7?name=홍길동&age=27&page=10">m11</a>
    <a href="test/param8?subject=데이트&cdate=2021/07/22 14:56:30">m12</a>
</p>

<p>
    <a href="test/json1">m13</a>
    <a href="test/json2">m14</a>
</p>
<!--
<a href="addr/addr.do">주소록</a><br/>
 -->
</body>
</html>
