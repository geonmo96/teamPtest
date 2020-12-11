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
	<form action="findIdToEmail" method="post">
		이름 입력 : <input type="text" name="name"><br>
		이메일 입력  : <input type="text" name="email"><br>
		<input type="submit" value="이메일 전송">
	</form>
</body>
</html>