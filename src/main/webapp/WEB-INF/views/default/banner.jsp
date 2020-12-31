<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.banner{
		width: 200px;
		float: left;
	}
</style>
</head>
<body>
	<div class="banner">
		<b>나의 쇼핑 내역</b><br><br>
		<a href="#">주문</a><br>
		<a href="https://tracker.delivery/#/:carrier_id/:track_id" target="_blank">배송조회</a><br>
		<a href="#">취소/반품/교환 신청</a><br>
		<a href="#">취소/반품/교환 현황</a><br>
		<c:if test="${sessionScope.login == 'local'}">
			<hr>
			<b>회원정보</b><br><br>
			<a href="${pageContext.request.contextPath }/member/myInfo">회원정보 변경</a><br>
			<a href="${pageContext.request.contextPath }/member/inputPw?message=secession">탈퇴</a><br>
		</c:if>	
	</div>
</body>
</html>