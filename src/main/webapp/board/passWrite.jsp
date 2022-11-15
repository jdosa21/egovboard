<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 문법 -->
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 입력 화면</title>
<!-- 비동기 연결 ajax-jquery  -->
<script src="/myproject_new/script/jquery-1.12.4.js"></script>
<script src="/myproject_new/script/jquery-ui.js"></script>
</head>

<script>
$(function(){ // jquery 문법의 시작
	
	$("#delBtn").click(function(){ // 사용자가 버튼 클릭
		
		var pass = $("#pass").val();
		pass = $.trim(pass); // 앞뒤 공백 제거
		if(pass == "") {
			alert("암호를 입력해주세요.");
			$("#pass").focus() // 암호가 있는 곳에 커서 이동
			return false;
		}
		
		// ajax 비동기 전송
		var sendData = "unq=${unq}&pass="+pass;
		$.ajax({
			/* 전송 전 세팅 */
			type: "POST", // 전송타입
			data: sendData, // json 설정
			url: "boardDelete.do", // 전송 url
			dataType: "text", // 리턴 타입
			
			/* 전송 후 세팅 */
			success: function(result) { // controller -> "ok"
				if(result == "1") {
					alert("삭제완료");
					location="boardList.do";
				} else if(result == "-1") {
					alert("암호가 일치하지 않습니다.");
				} else {
					alert("삭제실패\n관리자에게 연락해주세요.");
				}
			},
			error: function() { // 장애발생
				alert("오류발생");
			}
		});
	});
});
</script>
<body>

<table>
	<tr>
		<th>암호입력</th>
		<td><input type="password" id="pass"></td>
		<td><button type="button" id="delBtn">삭제하기</button></td>
	</tr>
</table>
</body>
</html>