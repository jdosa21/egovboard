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
<title>게시글 목록</title>
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

<body>
<!-- 번호, 제목, 글쓴이, 등록일, 조회수 -->
<div class="div1">일반게시판 목록</div>
<div class="div2">Total: ${total }</div>

<div class="div2">
<form name="searchFrm" method="post" action="boardList.do">
	<select name="searchGubun" id="searchGubun">
		<option value="title">제목</option>
		<option value="name">글쓴이</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="searchText" id="searchText" />
	<button type="submit">검색</button>
</form>
</div>

<table>
	<tr>
		<th width="15%">번호</th>
		<th width="40%">제목</th>
		<th width="15%">글쓴이</th>
		<th width="15%">등록일</th>
		<th width="15%">조회수</th>
	</tr>
	
	<!-- jstl 카운트 변수 -->
	<c:set var="cnt" value="${rowNumber }" />
	
	<!-- jstl 반복문 foreach var items -->
	<c:forEach var="result" items="${resultList}">
	
	<tr align="center">
		<!-- cout은 생략해도 되지만 원래 모습은 이렇다는 걸 보여주기 위해 적음 -->
		<td><c:out value="${cnt }"/></td>
		<td align="left"><a href="boardDetail.do?unq=${result.unq }"><c:out value="${result.title }"/></a></td>
		<td><c:out value="${result.name }"/></td>
		<td><c:out value="${result.rdate }"/></td>
		<td><c:out value="${result.hits }"/></td>
	</tr>
		<c:set var="cnt" value="${cnt-1 }" />
	</c:forEach>
</table>

<div style="width: 600px; margin-top: 5px; text-align: center; ">
	<c:forEach var="i" begin="1" end="${totalPage}">
		<a href="boardList.do?viewPage=${i }">${i }</a>
	</c:forEach>
</div>

<div style="width: 600px; margin-top: 5px; text-align: right; ">
	<button type="button" onclick="location.href='boardWrite.do';">글쓰기</button>
</div>
</body>
</html>