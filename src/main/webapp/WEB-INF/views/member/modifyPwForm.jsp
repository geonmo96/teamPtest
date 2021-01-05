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
	function modify(){
		var pw = document.getElementById("pw1");
		var pwChk = document.getElementById("pw2");
		if(pw.value == false){
			alert("비밀번호를 입력해주세요")
			return ;
		}
		if(pw.value != pwChk.value){
			alert("비밀번호가 일치하지 않습니다")
			return ;
		} else {
			fo.submit();
		}
	}
	function pwEqualsCheck(){
		var pw = document.getElementById("pw1").value;
		var pwChk = document.getElementById("pw2").value;
		if(pw == pwChk){
			document.getElementById("pwCheckView").innerHTML = "일치";
			document.getElementById("pwCheckView").style = "color:green";
		} else{
			document.getElementById("pwCheckView").innerHTML = "일치하지 않습니다";
			document.getElementById("pwCheckView").style = "color:red";
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<form action="modifyPw" method="post" id="fo">
		<table class="table">
			<tr>
				<td colspan="2"><h3>비밀번호 수정</h3><hr></td>
			</tr>
			<tr>
				<td align="center"> <input type="password" name="pw" id="pw1" placeholder="비밀번호 입력" style="text-align:left; width:60%; height:30px;"> </td>
			</tr>
			<tr>
				<td align="center">
					<input type="password" id="pw2" onkeyup="pwEqualsCheck()" placeholder="비밀번호 확인" style="text-align:left; width:60%; height:30px;">
					<label id="pwCheckView"></label>
				</td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="비밀번호 변경" onclick="modify()" class="button button1"></td>
			</tr>
		</table>
		<input type="hidden" value="${id }" name="id">
		
	</form>
</body>
</html>