<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<h1>${boardDto.title }</h1>
	${boardDto.savedate } 조회수 ${boardDto.hit }
	<hr>
	${boardDto.content }
	
</body>
</html>