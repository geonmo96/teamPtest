<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modifyNotice(){
		location.href="modifyForm?write_no=${boardDto.write_no}";
	}
	function deleteNotice(){
		alert("공지사항을 삭제했습니다");
		location.href="delete?write_no=${boardDto.write_no}";
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<h1>${boardDto.title }</h1>
	${boardDto.savedate } 조회수 ${boardDto.hit }
	<hr>
	${boardDto.content }
	
	<br>
	<c:if test="${sessionScope.admin == 'admin' }">
		<input type="button" id="modifyBtn" value="공지사항 수정" onclick="modifyNotice()">
		<input type="button" id="deleteBtn" value="공지사항 삭제" onclick="deleteNotice()">
	</c:if>
	
</body>
</html>