<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.content{
		float: right;
		width : 80%;
	}
</style>
<script type="text/javascript">
	function inputPw(){
		location.href = "inputPw?message=modifyPw"; 
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<br>
	<div>
		<div><jsp:include page="../default/banner.jsp"></jsp:include></div>
		<div class="content">
			<h4>회원정보 변경</h4>
			${dto.name }님의 정보
			<table>
				<tr> <td>이름</td> <td>${dto.name }</td> </tr>
				<tr> <td>아이디</td> <td>${dto.id }</td> </tr>
				<tr> <td>비밀번호</td> <td><input type="button" onclick="inputPw()" value="비밀번호 변경"></td> </tr>
				<tr> <td>이메일 주소</td> <td>${dto.email }</td> </tr>
				<tr> <td>휴대폰 정보</td> <td>${dto.m_tel }</td> </tr>
				<tr> <td>주소</td> <td>${dto.m_address }</td> </tr>
			</table>
		</div>
	</div>
</body>
</html>