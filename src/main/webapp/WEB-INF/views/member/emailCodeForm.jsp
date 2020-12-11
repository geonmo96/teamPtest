<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function init(){
		alert("${message}");
		if("${message}" != "메일이 전송되었습니다"){
			location.href="findId";
		}
	} 
	function checkCode(){
		var inputCode = document.getElementById("code").value;
		var code = "${code}";
		if(code == inputCode){
			alert("인증되었습니다<br>메일을 확인해주세요")
			$.ajax({
				url : "sendId",
				method : "POST",
				data : {"email" : "${email}"},
				success : function(data){
					location.href="main"
				},
				error : function(){
					alert("에러 발생")
				}
			});
		} else {
			alert("잘못 입력하셨습니다")
		}
	}
</script>
</head>
<body onload="init()">
	코드 : <input type="text" name="code" id="code"> <input type="button" value="확인" onclick="checkCode()">
</body>
</html>