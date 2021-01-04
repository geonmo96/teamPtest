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
		
		<table class="table">
			<tr>
				<td colspan="2"><h3>비밀번호 확인</h3> <hr></td>
			</tr>
			<tr>
				<td><label id="message"></label><br></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="id" id="id" placeholder="아이디" style="text-align:left; width:60%; height:30px;"><br></td>
			</tr>
			<tr>
				<td align="center"><input type="password" name="pw" id="pw" placeholder="비밀번호" style="text-align:left; width:60%; height:30px;"><br></td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="확인" onclick="checkIdPw()" class="button button1">	</td>
			</tr>
		</table>	
	</form>
</body>
</html>