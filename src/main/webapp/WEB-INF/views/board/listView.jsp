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
	<div>
		<table border="1">
			  
			<tr> <th>제목</th> <th>조회수</th> <th>작성일</th> </tr>
			<tr>
				<c:forEach items="${list }" var="boardDto">
					<td><a href="contentView?write_no=${boardDto.write_no }">${boardDto.title }</a></td>
					<td>${boardDto.hit }</td>
					<td>${boardDto.savedate }</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>