<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.button {
		background-color: #4CAF50;
		border: none;
		color: white;
		padding: 10px 32px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 18px;
		-webkit-transition-duration: 0.4s;
		transition-duration: 0.4s;
		cursor: pointer;
	}
	
	.button1 {
		background-color: #555555;
		color: white;
	}
	
	.button1:hover {
		background-color: black;
		color: white;
	}
		
</style>
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
	<div style="width: 80%; padding-left: 10%;">
		<hr color="#000000">
		<h1>${boardDto.title }</h1>
		<font style="size: 5px">${boardDto.savedate } 조회수 ${boardDto.hit }</font>
		<hr color="#BDBDBD">
		<div align="center">
			${boardDto.content }
		</div>
		<hr color="#000000">
		<c:if test="${sessionScope.admin == 'admin' }">
			<div align="right">
				<input type="button" id="modifyBtn" value="공지사항 수정" onclick="modifyNotice()" class="button button1">
				<input type="button" id="deleteBtn" value="공지사항 삭제" onclick="deleteNotice()" class="button button1">
			</div>
		</c:if>
	</div>
	
	
	
</body>
</html>