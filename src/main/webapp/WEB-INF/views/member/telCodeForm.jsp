<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function check(){
		var inputCode = $("#inputCode").val();
		console.log(inputCode)
		if(inputCode == ${authCode}){
			alert("인증이 되었습니다.");
			location.href="idView";
		} else {
			alert("잘못 입력하셨습니다.");
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<input type="text" name="inputCode" id="inputCode">
	<input type="button" value="확인" onclick="check()">
</body>
</html>