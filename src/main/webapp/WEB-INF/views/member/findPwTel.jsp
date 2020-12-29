<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function submitBtn(){
		if(document.getElementById("name").value == null){
			alert("이름을 입력하세요")
		} else if(document.getElementById("id").value == null){
			alert("아이디를 입력해주세요")
		}else {
			var name = $("#name").val();
			var id = $("#id").val();
			var fo = $("#fo");
			console.log(name);
			$.ajax({
				url : "findPwTelCheck",
				data : {"name":name, "id":id},
				type : "POST",
				success : function(data){
					if(data == 0){
						alert("입력하신 아이디는 없는 아이디입니다");
					} else if(data == -1){
						alert("회원정보가 일치하지 않습니다");
					} else if(data == 1){
						alert("문자가 전송되었습니다");
						$("#fo").submit();
					}
				},
				fail : function(){
					alert("에러 - check")	
				}
			});
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<a href="findPwEmail">가입된 이메일로 찾기</a>
	<form action="telCodeForm" method="post" id="fo">
		<table>
			<tr>
				<td>이름 </td>
				<td><input type="text" name="name" id="name" placeholder="이름을 입력하세요"> </td>
			</tr>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="id" id="id" placeholder="아이디를 입력하세요"> </td>
			</tr>
		</table>
		<input type="button" value="비밀번호 찾기" onclick="submitBtn()">
	</form>
</body>
</html>