<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div>
		<div>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=b7c160fc4b5f9830243927d9a94aea71&redirect_uri=http://localhost:8080/root/member/loginKakao&response_type=code">
				<img width="165px" src="${pageContext.request.contextPath}/resources/images/kakao_btn.png">
			</a>
			<a href="createNaverState">
				<img width="165px" src="${pageContext.request.contextPath}/resources/images/naver_btn.PNG">
			</a>
		</div>
		<form action="login" method="post">
		<table>
			<tr> 
				<td> 					
					<input type="text" name="id" placeholder="아이디"> 
				</td> 
			</tr>
			<tr> <td> <input type="password" name="pw" placeholder="비밀번호"> </td> </tr>
			<tr> <td> <input type="submit" value="로그인"> </td> </tr> 
				
			<tr> <td> <a href="findIdEmail">아이디 찾기</a> </td> <td> <a href="findPwEmail">비밀번호 찾기</a> </td> </tr> 
			<tr> <td> <a href="join">회원가입</a>
		</table>
		</form>
	</div>
</body>
</html>