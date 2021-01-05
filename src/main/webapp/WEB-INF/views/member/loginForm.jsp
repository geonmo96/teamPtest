<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	function message(){
		var message = "${param.message}";
		if(message == ""){
			return false;
		}
		console.log("메시지 출력")
		alert(message)
	}
</script>
</head>
<body onload="message()">
	<jsp:include page="../default/header.jsp"></jsp:include>
	<div align="center">
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=b7c160fc4b5f9830243927d9a94aea71&redirect_uri=http://localhost:8080/root/member/loginKakao&response_type=code">
			<img width="165px" height="40px" src="${pageContext.request.contextPath}/resources/images/kakao_btn.png">
		</a>
		<a href="createNaverState">
			<img width="165px"  height="40px" src="${pageContext.request.contextPath}/resources/images/naver_btn.PNG">
		</a>
	</div>
	<form action="login" method="post">
		<table class="table">
			<tr>
				<td colspan="2"><h3>로그인</h3><hr></td>
			</tr>
			<tr> 
				<td align="center" colspan="2"> 					
					<input type="text" name="id" placeholder="아이디" style="text-align:left; width:60%; height:30px;"> 
				</td> 
			</tr>
			<tr> <td align="center" colspan="2"> <input type="password" name="pw" placeholder="비밀번호" style="text-align:left; width:60%; height:30px;"> </td> </tr>
			<tr> <td align="center" colspan="2"> <input type="submit" value="로그인" class="button button1" > </td> </tr> 
				
			<tr> <td align="center"> <a href="findIdEmail">아이디 찾기</a> </td> <td align="center"> <a href="findPwEmail">비밀번호 찾기</a> </td> </tr> 
			<tr> <td colspan="2" align="center"> <a href="signupSelect">회원가입</a>
		</table>
	</form>
</body>
</html>