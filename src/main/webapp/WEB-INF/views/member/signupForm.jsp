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
input:focus {
	outline: 2px solid #d50000;
}

input:focus {
	outline: none;
}
</style>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<div style ="padding: 5px 100px 5px 100px;">		
		<form action="signup" method="post" id="fo">	
		<input type="text" placeholder=" 아이디" style="text-align:left; width:70%px; height:40px;"><br>

		
<<<<<<< HEAD
			<table width="70%" style="margin-left: auto; margin-right: auto;" border="1">
				<tr>
					<td colspan="2">
					회원정보 입력<hr>
					</td>
				</tr>
				<tr>
					<td width="5%"></td>
					<td>						
						<input type="text" name="id" id="id" onblur="dbIdCheck()" placeholder=" 아이디" style="text-align:left; width:70%px; height:40px;">
=======
		<form action="signup" method="post" id="fo">
			<input type="hidden" name="member_code" value="${param.member_code }">
			<table>
				<tr> <td>아이디</td> 
					<td>
						<input type="text" name="id" id="id" onblur="dbIdCheck()">
>>>>>>> af6a5f6bed62633112c8531147163df33823cbd9
						<label id="dbIdCheckView"></label>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="password" name="pw" id="pw" placeholder=" 비밀번호" style="text-align:left; width:70%px; height:40px;"></td>
				</tr>
				
				<tr>
					<td></td> 
					<td>
						<input type="password" name="pwChk" id="pwChk" onkeyup="pwEqualsCheck()" placeholder=" 비밀번호 확인">
						<label id="pwCheckView"></label>
					</td> 
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="name" id="name" placeholder=" 이름"></td>
				</tr>
				
				<tr> 
					<td></td> 
					<td>
						<input type="text" name="m_tel" id="m_tel" placeholder=" 연락처"> 
						<input type="button" onclick="sendSms()" value="인증 문자 전송"><br>
						<input type="text" id="authCode" placeholder=" 인증번호 입력">
						<input type="button" onclick="authCodeCheck()" value="확인"> 
					</td>  
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="email" id="email"  placeholder=" 이메일"></td>
				</tr>
				
				<tr> 
					<td></td> 
					<td>
						<input type="text" name="m_address" id="m_address" readonly="readonly" placeholder="검색 기능을 이용해주세요"> 
						<input type="button" value="검색" onclick="searchAddress()">
					</td> 
				</tr>
				
				<tr>
					<td></td>
					<td><input type="text" name="m_address2" id="m_address2" placeholder=" 상세주소"></td>
				</tr>
				
				<tr style="text-align: center;">
					<td colspan="2">
					<br>
					<input type="button" value="회원가입" onclick="chkCheck()"></td>
				</tr>
			</table>
			
		
		</form>
	</div>
</body>
</html>