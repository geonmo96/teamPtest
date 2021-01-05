<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.table {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}
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
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<a href="findIdTel">가입된 전화번호로 찾기</a>
	
		
		
		
	
	<form action="idEmailCheck" method="post">
	<table class="table">
		<tr>
			<td colspan="2"><h3>이메일로 아이디 찾기</h3><hr></td>
		</tr>
		<tr>
			<td align="center"><input type="text" name="name" placeholder="이름을 입력하세요" style="text-align:left; width:60%; height:30px;"></td>
		</tr>
		<tr>
			<td  align="center"><input type="text" name="email" placeholder="이메일을 입력하세요" style="text-align:left; width:60%; height:30px;"></td>
		</tr>
		<tr>
			<td  align="center"><input type="submit" value="이메일 전송" class="button button1"></td>
		</tr>
	</table>
	</form>
</body>
</html>