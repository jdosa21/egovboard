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
<title>게시판 수정 페이지</title>
<!-- 비동기 연결 ajax-jquery  -->
<script src="/myproject_new/script/jquery-1.12.4.js"></script>
<script src="/myproject_new/script/jquery-ui.js"></script>
</head>
<style>
body {
	font-size:9pt;
}
button {
	font-size:9pt;
}
table {
	width: 600px;
	border-collaps:collapse;
}
th, td {
	border:1px solid #cccccc;
	padding: 3px;
}

.input1 {
	width:98%;
}

.textarea {
	width:98%;
	height:70px;
}
</style>

<script>
	function fn_submit() {
		//jquery 형식 ajax 비동기
		// trim() -> 앞뒤 공백 제거
		if($.trim($("#title").val()) == "") {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		
		$("#title").val($.trim($("#title").val()) ); // 앞 뒤 공백제거
		
		if($.trim($("#pass").val()) == "") {
			alert("암호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		$("#pass").val($.trim($("#pass").val()) ); // 앞 뒤 공백제거
		
		
		var formData = $("#frm").serialize();
		
		// ajax: 비동기 전송 방식의 기능을 가지고 있는 jquery의 함수
		$.ajax({
			/* 전송 전 세팅 */
			type: "POST", // 전송타입
			data: formData, // 데이터
			url: "boardModifySave.do", // 전송 url
			dataType: "text", // 리턴 타입
			
			/* 전송 후 세팅 */
			success: function(result) { // controller -> "ok"
				if(result == "1") {
					alert("저장완료");
					location="boardList.do";
				} else if(result == "-1") {
					alert("암호가 일치하지 않습니다.");
				} else {
					alert("저장실패\n관리자에게 연락해주세요.");
				}
			},
			error: function() { // 장애발생
				alert("오류발생");
			}
		});
		
		//js 형식
		/*if( document.frm.title.value == "") {
			alert("제목을 입력해주세요.");
			document.frm.title.focus();
			return false;
		}
		
		if( document.frm.pass.value == "") {
			alert("암호를 입력해주세요.");
			document.frm.title.focus();
			return false;
		}*/
		
		// document.frm.submit(); // 동기전송방식
		
	}
</script>
<body>
<!-- form 태그에 method="post" action="boardWriteSave.do" 비동기이기 때문에 안적어도 된다 -->
<form id="frm">
	<input type="hidden" name="unq" value="${boardVO.unq }"> <!-- 숨겨서 unq 값 전송 -->
	<table>
		<caption>게시판 등록</caption>
		<tr>
			<!-- 라벨을 넣으면 제목을 눌렀을 때 커서가 input에 자동으로 들어가게 해준다 id와 일치해야 함 -->
			<th width="20%"><label for="title">제목</label></th> 
			<td width="80%"><input type="text" name="title" id="title" class="input1" value="${boardVO.title }"></td>
		</tr>
		<tr>
			<th><label for="pass">암호</label></th>
			<td><input type="password" name="pass" id="pass"></td>
		</tr>
		<tr>
			<th><label for="name">글쓴이</label></th>
			<td><input type="text" name="name" id="name" value="${boardVO.name }"></td>
		</tr>
		<tr>
			<th><label for="content">내용</label></th>
			<td><textarea name="content" id="content" class="textarea">${boardVO.content }</textarea></td>
		</tr>
		<tr>
			<th colspan="2"> <!-- colspan: 가로합침 -->
			<button type="submit" onclick="fn_submit(); return false;">수정</button>
			<button type="reset">취소</button>
			</th>
		</tr>
	</table>
</form>
</body>
</html>