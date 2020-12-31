<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<a href="findIdTel">가입된 전화번호로 찾기</a>
	<form action="idEmailCheck" method="post">
		<input type="text" name="name" placeholder="이름을 입력하세요"><br>
		<input type="text" name="email" placeholder="이메일을 입력하세요"><br>
		<input type="submit" value="이메일 전송">
	</form>
</body>
</html>