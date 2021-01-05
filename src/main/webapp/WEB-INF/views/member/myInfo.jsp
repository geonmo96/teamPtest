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
.table {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 18px;
	-webkit-transition-duration: 0.4s;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: #555555;
	color: white;
}

.button1:hover {
	background-color: black;
	color: white;
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
			<table class="table">
				<tr> <td colspan="2"> <h3>${dto.name }님의 정보</h3> <hr> </td> </tr>
				<tr> <td align="center">이름</td> <td align="center">${dto.name }</td> </tr>
				<tr> <td align="center">아이디</td> <td align="center">${dto.id }</td> </tr>
				<tr> <td align="center">비밀번호</td> <td align="center"><input type="button" onclick="inputPw()" value="비밀번호 변경"></td> </tr>
				<tr> <td align="center">이메일 주소</td> <td align="center">${dto.email }</td> </tr>
				<tr> <td align="center">휴대폰 정보</td> <td align="center">${dto.m_tel }</td> </tr>
				<tr> <td align="center">기본   주소</td> <td align="center">${dto.m_address }</td> </tr>
			</table>
		</div>
	</div>
</body>
</html>