<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
	<div>
		<h1>쇼핑몰이름</h1>
		<hr>
		<br>
		&nbsp;&nbsp;
		<a href="#">산지직송</a>&nbsp;&nbsp;
		<a href="#">지역명물</a>&nbsp;&nbsp;
		<a href="#">차&음료</a>&nbsp;&nbsp;
		<a href="#">묻고 답하기</a>&nbsp;&nbsp;
		<a href="#">공지사항</a>&nbsp;&nbsp;
		<a href="#">리뷰이벤트</a>&nbsp;&nbsp;
		<a href="#">쇼핑스토리</a>&nbsp;&nbsp;
		<a href="#">판매자정보</a>&nbsp;&nbsp;
		<c:choose>
			<c:when test="${sessionScope.USER == null}">
				<a href="${pageContext.request.contextPath }/member/loginForm">로그인</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/member/signupForm">회원가입</a>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="#">${sessionScope.USER }님</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
		
		<br><br>
		<hr>
	</div>
</body>
</html>