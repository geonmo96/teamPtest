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
	function check(){
		var inputCode = $("#inputCode").val();
		console.log(inputCode)
		if(inputCode == ${authCode}){
			alert("인증이 되었습니다.");
			if("${find}" == "id"){
				location.href="idView";
			} else if("${find}" == "pw"){
				var fo = document.createElement("form");
				fo.setAttribute("method", "post");
				fo.setAttribute("action", "modifyPwForm");
				var id = document.createElement("input");
				id.setAttribute("type", "hidden");
				id.setAttribute("name", "id");
				id.setAttribute("value", "${id}");
				fo.appendChild(id);
				document.body.appendChild(fo);
				fo.submit();
			}
		} else {
			alert("잘못 입력하셨습니다.");
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	
	
	<table class="table">
		<tr>
			<td colspan="2"><h3>비밀번호 수정</h3><hr></td>
		</tr>
		<tr>
			<td align="center"><input type="text" name="inputCode" id="inputCode" placeholder="인증번호 입력" style="text-align:left; width:60%; height:30px;"> </td>
		</tr>
		<tr>
			<td align="center"> <input type="button" value="확인" onclick="check()" class="button button1"></td>
		</tr>
	</table>
</body>
</html>