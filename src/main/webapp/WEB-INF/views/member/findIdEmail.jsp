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
	<a href="findIdEmail">이메일로 찾기</a>
	<a href="findIdTel">가입된 전화번호로 찾기</a>
	<form action="idEmailCheck" method="post">
		이름 입력 : <input type="text" name="name"><br>
		이메일 입력  : <input type="text" name="email"><br>
		<input type="submit" value="이메일 전송">
	</form>
</body>
</html>