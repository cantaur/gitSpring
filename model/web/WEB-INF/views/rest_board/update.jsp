<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

  <meta charset='utf-8'>
  <title>Spring Board</title>
  <script type="text/javascript" language="javascript"
          src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <style>
    a { text-decoration:none }
  </style>
</head>

<div style="text-align: center;">
  <hr width='600' size='2' color='gray' noshade>
  <span style="color: gray; font-size: medium; ">
    <h3>Simple Board with Spring(ajax)</h3>
  </span>
  <span style="color: gray; font-size: medium; ">
    <a href='list.do'>list</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='../'>index</a><br/>
  </span>
  <hr width='600' size='2' color='gray' noshade>
</div>
<form name="input" method="post" id="writeForm" action="update.do" enctype="multipart/form-data">
  <table border='0' width='600' align='center' cellpadding='3' cellspacing='1' bordercolor='gray'>
    <input type='hidden' id = "seq" name='seq'>

    <tr>
      <td width='20%' align='center'>WRITER</td>
      <td>
        <input type='text' id = "writer" name='writer' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>EMAIL</td>
      <td><input type='text' id="email" name='email' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>SUBJECT</td>
      <td><input type='text' id="subject" name='subject' size='67'/>
      </td>
    </tr>
    <tr>
      <td align='center'>CONTENT</td>
      <td><textarea id="content" name='content' rows='15' cols='60'> </textarea>
      </td>
    </tr>
    <tr>
      <td width='20%' align='center'>FILE</td>
      <td id="file"></td>
    </tr>
    <tr>
      <td align='center'>파일<br/>수정</td>
      <td><input type='file' name='file' size='67'/>
      </td>
    </tr>
    <tr>
      <td colspan='2' align='center'>
        <input type='button' value='modify' id="btn"/>
      </td>
    </tr>
  </table>


  <hr width='600' size='2' color='gray' noshade>
</form>
<script>
  var seq = location.href.split('seq=')[1];
  console.log(seq)
  viewContent(seq)
  function viewContent(seq) {
    $.ajax({
      url: "../rest_board/content/" + seq + ".json", //서비스 주소
      success: function (res) {
        console.log(res)
        $('#seq').val(res['seq']);
        $('#writer').val(res['writer']);
        $('#email').val(res['email']);
        $('#subject').val(res['subject']);
        $('#content').val(res['content']);

        $('#file').text(res['fname']);
        $('#file a').attr("href","download.do?fname=" + res['fname']);

        $('#modify').attr("href","update.do?seq=" + res['seq']);
        $('#delete').attr("data-seq",+ res['seq']);
      }
    })
  }

  function updateContent(seq){
    var seq = seq;
    $("#btn").on("click", function(){
      var form = $('#writeForm')[0];
      var formData = new FormData(form);
      $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "../rest_board/update",
        data: formData,
        processData: false,
        contentType: false,
        cache: false,
        success: function (data) {
          console.log("SUCCESS : ", data);
          location.href="list.do";
        },
        error: function (e) {
          console.log("ERROR : ", e);
        }
      });
    });
    $.ajax({
      type: 'POST',
      url: "../rest_board/update/"+seq,

      success: function(e){
        alert("게시글이 수정되었습니다.");
        location.href = "../rest_board/list.do"
      }
    })
  }
  $(document).on('click', '#update', function(){
    deleteContent($(this).attr('data-seq'))
  })
</script>
</body>
</html>

