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
<title>수정 페이지</title>
</head>

<style>
table {
	width: 400px;
	border-collapse: collapse; /* 셀 사이 간격 없음 */
}
th,td{
	border: 1px solid #cccccc; /* 보더 회색 */
	padding: 5px; /* 내부간격  */
}
</style>
<body>


<form name="frm" method="post" action="deptModifySave.do">
<table>
	<tr>
		<th>부서번호</th>
		<td><input type="text" name="deptno" value="${vo.deptno }"></td>
	</tr>
	<tr>
		<th>부서이름</th>
		<td><input type="text" name="dname" value="${vo.dname }"></td>
	</tr>
	<tr>
		<th>부서위치</th>
		<td><input type="text" name="Loc" value="${vo.loc }"></td>
	</tr>
	<tr>
		<th colspan="2">
		<button type="submit">수정</button>
		</th>
	</tr>
</table>
</form>


</body>
</html>