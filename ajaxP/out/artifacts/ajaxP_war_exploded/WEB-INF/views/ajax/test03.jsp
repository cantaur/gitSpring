<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Ajax Test02</title>
    <script type="text/javascript" language="javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script type="text/javascript">
        // $(document).ready(function () {
        // JQuery의 원래 문법
        // });
        $(function () {
            //$("#searchOk01").on("click", function () {//클릭할 때 다음 함수를 수행하시오
            $("#seq").on("keyup", function () {
                $.ajax({
                    //파라미터에 객체가 들어간다
                    url: "../ajax03/search01.json",
                    type: "GET",
                    data: {seq:$("#seq").val()}, //서버에 날려줄 객체
                    success: function (data){//서버로부터 날라오는 responce data,
                        //var jsobj = JSON.parse(data); //넘어온 json data를 자바스크립트의 오브젝트형태로 바꿔야함, jQuery 낮은 버전일 때 사용
                        //var json = JSON.stringify(data); *참고 : 자바스크립트 객체를 다시 json으로 바꿀 때
                        if(!data){
                            //alert("존재하지 않는 seq");
                            return false;
                        }
                        var html = " ";
                        html += "<form id='ajax'>";
                        html += "번호<input name='seq' value='"+data.seq+"'>"; //해당 id값을 갖고 있는 객체가 리턴된다
                        html += "이름<input name='name' value='"+data.name+"'>";
                        html += "주소<input name='addr' value='"+data.addr+"'>";
                        html += "날짜<input name='rdate' value='"+data.rdate+"'>";
                        html += "</form>";
                        $("#container").html(html);
                    }
                });
            });
            //해당 id값을 갖고 있는 객체가 리턴된다

            $("#searchOk02").on("click", function(){
                $.ajax({
                    url: "../ajax03/search02.json",
                    type: "POST",
                    data: {name: $("#name").val()},
                    success: function(data){
                        if(!data){
                            alert("존재하지 않는 name");
                            return false;
                        }
                        var html="";
                        html += "<table border='1' width='50%'>";
                        html += "<tr>";
                        html += "<th> 번호 </th>";
                        html += "<th> 이름 </th>";
                        html += "<th> 주소 </th>";
                        html += "<th> 날짜 </th>";
                        html += "</tr>";

                        if(data.length==0){
                            html += "<tr>";
                            html += "<td colspan='4' align='center'> 데이타 없음</td>";
                            html += "</tr>";
                        }else{
                            for(let address of data){
                                html += "<tr>";
                                html += "<td align='center'>"+address.seq+"</td>";
                                html += "<td align='center'>"+address.name+"</td>";
                                html += "<td align='center'>"+address.addr+"</td>";
                                html += "<td align='center'>"+address.rdate+"</td>";
                                html += "</tr>";
                            }
                        }
                        html+="</table>";
                        $("#container").html(html);

                    }
                });
                //alert("아래 button 클릭됨");
            });
        });

    </script>

</head>
<body>
<center>
    <h2>(방법3) @ResponseBody</h2>

    번호: <input type="text" name="seq" id="seq"/>
    <input type="button" value="번호 검색" id="searchOk01"/>
    <br/>

    이름: <input type="text" name="name" id="name"/>
    <input type="button" value="이름 검색" id="searchOk02"/>

    <br/><br/>
    <div id="container"></div>
    <br/><br/>

    <a href="../">인덱스</a><br/><br/>
</center>
</body>
</html>