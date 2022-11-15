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
<title>코드목록</title>
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

<script language="javascript">
	function fn_delete(code){
		if(confirm("정말 삭제하시겠습니까?")){
			location = "codeDelete.do?code="+code;
		}
	}
	
	function fn_update(code){
		location = "codeModifyWrite.do?code="+code;
	}
</script>
<body>
<table>
	<caption>
	<div>코드목록</div> <br>
	<div style="width:100%; text-align:Left;">Total: ${resultTotal }개</div>
	</caption>
	<colgroup>
		<col width="14%"/>
		<col width="22%"/>
		<col width="30%"/>
		<col width="34%"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>그룹명</th>
		<th>코드명</th>
		<th>구분</th>
	</tr>
	
	<c:set var="count" value="1" />
	<c:forEach var="list" items="${resultList}" varStatus="status">
		<tr align="center">
			<td>${count}</td>
			<td><c:out value="${list.gid }" /></td>
			<td>${list.name }</td>
			<td>
			<button type="button" onclick="fn_update('${list.code}')">수정</button>
			<button type="button" onclick="fn_delete('${list.code}')">삭제</button>
			</td>
		</tr>
		<c:set var="count" value="${count+1 }"/>
	</c:forEach>
	
</table>
</body>
</html>