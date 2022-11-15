<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script>
$( function() {
  $("#birth").datepicker({
    changeMonth: true,
    changeYear: true
  });
  
  // 중복체크 이벤트
  $("#btn_idcheck").click( function() {
	  
	  var userid = $("#userid").val(); // 현재 인풋태그에 입력된 값
	  userid = $.trim(userid); // 공백제거
	  
	  if(userid == "") {
		  alert("아이디를 입력해주세요.");
		  $("#userid").focus;
		  return false;
	  }
	  
	  // idcheck.do로 비동기 데이터 전송
	 
	  $.ajax({
		  type: "POST", // 전송타입
			data: "userid="+userid, // json 타입의 전송 데이터
			url: "idCheck.do", // 전송 url
			dataType: "text", // 리턴 타입
			success: function(result) { // controller -> "ok"
				if(result == "ok") {
					alert("사용 가능한 아이디입니다.");
				} else {
					alert("이미 사용중인 아이디입니다.");
				}
			},
			error: function() { // 장애발생
				alert("오류발생");
			}
	  });
  });
  
  // 클릭 시 이벤트 함수
  $("#btn_submit").click( function(){
	  
	  var userid = $("#userid").val();
  	  var pass = $("#pass").val();
  	  var name = $("#name").val();
  	  
  	  // 공백 제거
  	  userid = $.trim(userid);
  	  pass = $.trim(pass);
  	  name = $.trim (name);
  	  if(userid=="") { // 아무것도 안적었을 때
  		  alert("아이디를 입력해주세요");
  		  $("#userid").focus(); // 아이디 입력창으로 이도
  		  return false; // 프로그램 중단
  	  }
  	  if(pass=="") { // 아무것도 안적었을 때
		  alert("암호를 입력해주세요");
		  $("#pass").focus(); // 아이디 입력창으로 이도
		  return false; // 프로그램 중단
	  }
  	  if(name=="") { // 아무것도 안적었을 때
		  alert("이름을 입력해주세요");
		  $("#name").focus(); // 아이디 입력창으로 이도
		  return false; // 프로그램 중단
	  }
  	  $("#userid").val(userid); // 실제 공백이 제거된 값  
  	  $("#pass").val(pass); // 실제 공백이 제거된 값  
      $("#name").val(name); // 실제 공백이 제거된 값 
      
      // 폼데이터 전송
      var formData = $("#frm").serialize();
      
      $.ajax({
			type: "POST", // 전송타입
			data: formData, // 데이터
			url: "memberWriteSave.do", // 전송 url
			dataType: "text", // 리턴 타입
			success: function(result) { // controller -> "ok"
				if(result == "ok") {
					alert("저장완료");
					location="loginWrite.do";
				} else {
					alert("저장실패");
				}
			},
			error: function() { // 장애발생
				alert("오류발생");
			}
		});
  });
} );
</script>

</head>

<style>
body{
	font-size: 9pt;
	font-color:#333333;
	font-family:맑은 고딕;
}
a {
	text-decoration: none; /* a태그 언더라인 지우기 */
}
table{
	width: 600px;
	border-collapse: collapse;
}
th, td{
	border: 1px solid #cccccc;
	padding: 3px;
	line-height:2;
}
caption {
	font-size: 15pt;
	font-weight: bold;
	margin-top: 10px;
	padding-bottom: 5px;
}
.div_button{
	width: 600px;
	text-align: center;
	margin-top: 5px;
}
</style>

<body>
<table>
	<tr>
		<th width="25%">홈</th>
		<th width="25%"><a href="/myproject_new/boardList.do">게시판</a></th>
		<th width="25%"><a href="/myproject_new/memberWrite.do">회원가입</a></th>
		<th width="25%"><a href="/myproject_new/loginWrite.do">로그인</a></th>
	</tr>
</table>

<form id="frm">
	<table>
		<caption>회원가입</caption>
		<tr>
			<th><label for="userid">아이디</label></th>
			<td>
			<input type="text" name="userid" id="userid" placeholder="아이디입력">
			<button type="button" id="btn_idcheck">중복체크</button>
			</td>
		</tr>
		<tr>
			<th><label for="pass">암호</label></th>
			<td>
			<input type="password" name="pass" id="pass">
			</td>
		</tr>
		<tr>
			<th><label for="name">이름</label></th>
			<td>
			<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<th><label for="gender">성별</label></th>
			<td>
			<input type="radio" name="gender" id="gender" value="M">남
			<input type="radio" name="gender" id="gender" value="F">여
			</td>
		</tr>
		<tr>
			<th><label for="birth">생년월일</label></th>
			<td>
			<input type="text" name="birth" id="birth">
			</td>
		</tr>
		<tr>
			<th><label for="phone">연락처</label></th>
			<td>
			<input type="text" name="phone" id="phone"> (예:010-1234-5678)
			</td>
		</tr>
		<tr>
			<th><label for="address">주소</label></th>
			<td>
			<input type="text" name="zipcode" id="zipcode">
			<button type="button">우편번호찾기</button>
			<br>
			<input type="text" name="address" id="address">
			</td>
		</tr>
	</table>
	
	<div class="div_button">
		<button type="button" id="btn_submit">저장</button>
		<button type="reset">취소</button>
	</div>
</form>

</body>
</html>