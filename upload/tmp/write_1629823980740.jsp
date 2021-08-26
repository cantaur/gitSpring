<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8"/>
		<title>Address Rest Create</title>
		<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript">
		    $(function(){
		    	$("#btn").on("click", function(){
		    		//alert("이름: " + $("#na").val());
		    		//alert("주소: " + $("#ad").val());
		    		//console.log("이름: " + $("#na").val());
		    		//console.log("주소: " + $("#ad").val());
		    		
		    		var jsObj = {name:$("#na").val(), addr:$("#ad").val()};
		    		//alert("jsObj: " + jsObj);
		    		var jsonData = JSON.stringify(jsObj)//jsObj -> json 
		    		//alert("jsonData: " + jsonData);
		    		
		    		$.ajax({
		    			//url: "../rest_addr/create.json",
		    			url: "create.json",
		    			type: "post", 
		    			contentType: "application/json", 
		    			data: jsonData, 
		    			success: function(data){
		    				alert("입력 성공: " + data);
		    			}, 
		    			error: function(data){
		    				alert("입력 실패: " + data);
		    			} 
		    		});
		    	});
		    });
		</script>
	</head>
	<body>
	
		<h2>Rest Address Create</h2>
		이름: <input id="na"> <br/>
		주소: <input id="ad"> <br/>
		<input type="button" value="주소록 추가" id="btn"/><br/><br/>
    </body>
</html>

