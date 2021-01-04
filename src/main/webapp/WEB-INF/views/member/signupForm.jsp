<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath }/resources/member_js/daumpost.js"></script>
<script src="${pageContext.request.contextPath }/resources/member_js/signupCheck.js?ver=123"></script>
<script type="text/javascript">
</script>
<style type="text/css">

table {
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
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
		<form action="signup" method="post" id="fo">	

			<table>
				<tr>
					<td colspan="2">
						<h3>회원정보 입력</h3><hr>
					</td>
				</tr>
				<tr>
					<td width="5%"></td>
					<td>						
			<input type="hidden" name="member_code" value="${param.member_code }">
			
				<tr> <td></td> 
					<td>
						<input type="text" name="id" id="id" onblur="dbIdCheck()" placeholder=" 아이디" style="text-align:left; width:60%; height:30px;">
						<label id="dbIdCheckView" style="size:8px;"></label>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="password" name="pw" id="pw" placeholder=" 비밀번호" style="text-align:left; width:60%; height:30px;"></td>
				</tr>
				
				<tr>
					<td></td> 
					<td>
						<input type="password" name="pwChk" id="pwChk" onkeyup="pwEqualsCheck()" placeholder=" 비밀번호 확인" style="text-align:left; width:60%; height:30px;">
						<label id="pwCheckView"></label>
					</td> 
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="name" id="name" placeholder=" 이름" style="text-align:left; width:60%; height:30px;"></td>
				</tr>
				
				<tr> 
					<td></td> 
					<td>
						<input type="text" name="m_tel" id="m_tel" placeholder=" 연락처" style="text-align:left; width:60%; height:30px;"> 
						<input type="button" onclick="sendSms()" value="인증 문자 전송"><br>
					</td>  
				</tr>
				<tr> 
					<td></td> 	
					<td>
						<input type="text" id="authCode" placeholder=" 인증번호 입력" style="text-align:left; width:60%; height:30px;">
						<input type="button" onclick="authCodeCheck()" value="확인"> 
					</td>  
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="email" id="email"  placeholder=" 이메일" style="text-align:left; width:60%; height:30px;"></td>
				</tr>
				
				<tr> 
					<td></td> 
					<td>
						<input type="text" name="m_address" id="m_address" readonly="readonly" placeholder=" 주소 (검색 기능 이용)" style="text-align:left; width:60%; height:30px;"> 
						<input type="button" value="검색" onclick="searchAddress()">
					</td> 
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="m_address2" id="m_address2" placeholder=" 상세주소" style="text-align:left; width:60%; height:30px;"></td>
				</tr>
				
				<tr style="text-align: center;">
					<td colspan="2">
					<br>
					<input type="button" class="button button1" value="회원가입" onclick="chkCheck()"></td>
				</tr>
			</table>
		</form>
</body>
</html>