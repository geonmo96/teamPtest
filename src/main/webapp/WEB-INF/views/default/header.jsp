<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>
 ul {
 	list-style: none;
 	text-align: center;
 }
 li { 
 	 display: inline;
 }
</style>
</head>
<body>
	<div>
		<table width="100%" background="../resources/images/header_b.JPG">
			<tr>
				<td width="30%"></td>
				<td align="center" width="30%">
					<a href="#" width="40%">
						<img src="../resources/images/logo.png" height="100px">
					</a>
				</td>
				<td align="right" valign="top" width="30%">
					<c:choose>
						<c:when test="${sessionScope.USER == null}">
							<a href="${pageContext.request.contextPath }/member/loginForm">로그인</a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/member/signupForm">회원가입</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="#">${sessionScope.USER }님</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
					</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

		<hr>
		<ul>
			<li><a href="#">산지직송</a></li>&nbsp;&nbsp;
			<li><a href="#">지역명물</a></li>&nbsp;&nbsp;
			<li><a href="#">차&음료</a></li>&nbsp;&nbsp;
			<li><a href="#">묻고 답하기</a></li>&nbsp;&nbsp;
			<li><a href="#">공지사항</a></li>&nbsp;&nbsp;
			<li><a href="#">리뷰이벤트</a></li>&nbsp;&nbsp;
			<li><a href="#">쇼핑스토리</a></li>&nbsp;&nbsp;
			<li><a href="#">판매자정보</a></li>&nbsp;&nbsp;
		</ul>
		<hr>
	</div>
</body>
</html>