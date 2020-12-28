<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function messageView(){
		if("${param.message}" == "modifyPw"){
			document.getElementById("message").innerHTML = "비밀번호 변경을 위해 아이디와 비밀번호를 입력해주세요";
			document.getElementById("fo").action = "modifyPwForm";
		} else if("${param.message} == secession"){
			document.getElementById("message").innerHTML = "회원 탈퇴를 위해 아이디와 비밀번호를 입력해주세요";
			document.getElementById("fo").action = "secession";
		}
	}
	function checkIdPw(){
		var id = $("#id").val();
		var pw = $("#pw").val();
		$.ajax({
			url : "checkIdPw",
			type : "POST",
			data : {"id":id, "pw":pw},
			success : function(data){
				if(data == "-1"){
					alert("아이디가 없습니다");
				} else if(data == "0"){
					alert("비밀번호가 틀렸습니다");
				} else {
					fo.submit();
				}
			}
		});
	}
</script>
</head>
<body onload="messageView()">
	<jsp:include page="../default/header.jsp"></jsp:include>
	<!-- action="#" > modifyPwForm, secession 으로 이동됨  -->
	<form action="#" method="post" id="fo">
		<label id="message"></label><br>
		<input type="text" name="id" id="id" placeholder="아이디"><br>
		<input type="password" name="pw" id="pw" placeholder="비밀번호"><br>
		<input type="button" value="확인" onclick="checkIdPw()">		
	</form>
</body>
</html>