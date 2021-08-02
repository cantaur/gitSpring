<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Sp02 Index</title>
	</head>
	<body style="text-align:center">
		<h3>
			Sp02 for Spring Ajax
		</h3>

	    <a href="ajax/test01.do">Ajax01</a>&nbsp;&nbsp;
		<a href="ajax/test02.do">Ajax02</a>&nbsp;&nbsp;&nbsp;
		<a href="ajax/test03.do">Ajax03</a>&nbsp;&nbsp;
		<a href="ajax/test04.do">Ajax04</a>&nbsp;&nbsp;
		<br/><br/>
		<h3>ajax 응용</h3>

		<a href="file/list.do">Drag&Drop</a>&nbsp;&nbsp;
		<a href="chart/chart.do">Chart</a>&nbsp;&nbsp;

		<br/><br/>
		<h3>restful 테스트</h3>
		<br/>
		<a href="rest/getText">getText</a>&nbsp;&nbsp;
		<a href="rest/getAddress.xml">getAddress</a>(xml)&nbsp;&nbsp;&nbsp;
		<a href="rest/getAddress.json">getAddress</a>(json)&nbsp;&nbsp;&nbsp;
			<a href="rest/getList.xml">getList</a>(xml)&nbsp;&nbsp;&nbsp;
			<a href="rest/getList.json">getList</a>(json)&nbsp;&nbsp;
			<a href="rest/getMap.xml">getMap</a>(xml)&nbsp;&nbsp;
			<a href="rest/getMap.json">getMap</a>(json)
		<br/><br/>
		<a href="rest/check.json?height=170&weight=70">getParam</a>(json)&nbsp;&nbsp;
		<a href="rest/check.xml?height=170&weight=70">getParam</a>(xml)&nbsp;&nbsp;
		<a href="rest/product/bag/001.xml">product/bag/001</a>(xml)&nbsp;&nbsp;
		<a href="rest/product/bag/002.json">product/bag/002</a>(json)
		<br/><br/>
		<h3>restful 구축(Address)</h3>
		<a href="rest_addr/write.do">Address Write Form</a>&nbsp;&nbsp;







	</body>
</html>
