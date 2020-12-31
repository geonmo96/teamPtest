<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	text-align: center;
}


</style>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	
	<div>
	<h1>가입하실 서비스를 선택해주세요.</h1>
	<a href="join">
	<img src="../resources/images/joing_user/user_member.png" style="max-width:50%;height:auto;"
	onmouseover="this.src='../resources/images/joing_user/user_member2.png'"
	onmouseout="this.src='../resources/images/joing_user/user_member.png'">	
	</a>	
	
	<a href="joinSeller">	
	<img src="../resources/images/joing_user/user_seller.png" style="max-width:50%;height:auto;"
	onmouseover="this.src='../resources/images/joing_user/user_seller2.png'"
	onmouseout="this.src='../resources/images/joing_user/user_seller.png'">	
	</a>
	</div>
</body>
</html>