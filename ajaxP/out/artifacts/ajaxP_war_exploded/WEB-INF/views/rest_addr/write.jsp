<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Address Rest Create</title>
    <meta charset="utf-8"/>
    <title>Address Rest Create</title>
    <script type="text/javascript" language="javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").on("click", function(){
               console.log("이름: "+$("#name").val());
               console.log("주소: "+$("#addr").val());
               var jsObj = {name:$("#name").val(), addr:$("#addr").val()};
               //alert("jsObj: " + jsObj);
               var jsonData = JSON.stringify(jsObj)//jsObj -> json
               console.log("jsonData: " + jsonData);

               $.ajax({

                   url: "../rest_addr/create.json",
                   //url: "create.json",
                   type: "post",
                   contentType: "application/json",
                   data: jsonData,
                   success: function(data){
                       console.log("안넘어와?");
                       alert("입력 성공: " + jsonData);
                   },
                   error: function(data){
                       alert("입력 실패: " + jsonData);
                   }
               });
           });
        });
    </script>
</head>
<br>
<h2>Address Rest Create</h2>
이름: <input id="name"><br/>
주소: <input id="addr"><br/>

<input type="button" value="주소록 추가" id="btn"/><br/><br/>
</body>
</html>
