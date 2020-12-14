<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<table>
			<tr>
				<td> 비밀번호 입력 </td>
				<td> <input type="password" name="pw" id="pw1"> </td>
			</tr>
			<tr>
				<td> 비밀번호 확인 </td>
				<td>
					<input type="password" id="pw2" onkeyup="pwEqualsCheck()">
					<label id="pwCheckView"></label>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${id }" name="id">
		<input type="button" value="비밀번호 변경" onclick="modify()">
	</form>
</body>
</html>