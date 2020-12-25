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
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<div>
		
		<form action="signup" method="post" id="fo">
			<table>
				<tr> <td>아이디</td> 
					<td>
						<input type="text" name="id" id="id" onblur="dbIdCheck()">
						<label id="dbIdCheckView"></label>
					</td> 
				</tr>
				<tr> <td>비밀번호</td> <td><input type="password" name="pw" id="pw"></td> </tr>
				<tr> <td>비밀번호 확인</td> 
					<td>
						<input type="password" name="pwChk" id="pwChk" onkeyup="pwEqualsCheck()">
						<label id="pwCheckView"></label>
					</td> 
				</tr>
				<tr> <td>이름</td> <td><input type="text" name="name" id="name"></td> </tr>
				<tr> 
					<td>휴대전화</td> 
					<td>
						<input type="text" name="m_tel" id="m_tel"> 
						<input type="button" onclick="sendSms()" value="인증 문자 전송"><br>
						<input type="text" id="authCode">
						<input type="button" onclick="authCodeCheck()" value="확인"> 
					</td>  
				</tr>
				<tr> <td>이메일</td> <td><input type="text" name="email" id="email"></td> </tr>
				<tr> 
					<td>주소</td> 
					<td>
						<input type="text" name="m_address" id="m_address" readonly="readonly" placeholder="검색 기능을 이용해주세요"> 
						<input type="button" value="검색" onclick="searchAddress()">
					</td> 
				</tr>
				<tr>
					<td>상세 주소</td> <td><input type="text" name="m_address2" id="m_address2"></td>
				</tr>
			</table>
		<input type="button" value="회원가입" onclick="chkCheck()">
		</form>
	</div>
</body>
</html>