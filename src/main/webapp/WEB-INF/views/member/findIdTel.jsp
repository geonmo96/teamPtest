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
		var name = $("#name").val();
		var m_tel = $("#m_tel").val();
		var fo = $("#fo");
		console.log(name);
		$.ajax({
			url : "dbNameCheck",
			data : {"name":name, "m_tel":m_tel},
			type : "POST",
			success : function(data){
				if(data == 0){
					alert("일치하는 휴대폰 정보가 없습니다.");
				} else if(data == -1){
					alert("이름과 전화번호가 일치하지 않습니다");
				} else if(data == 1){
					alert("문자전송가 전송되었습니다");
					$("#fo").submit();
				}
			},
			fail : function(){
				alert("에러 - check")	
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<a href="findIdEmail">이메일로 찾기</a>
	<a href="findIdTel">가입된 전화번호로 찾기</a>
	<form action="idAuthCheck" method="post" id="fo">
		<input type="text" name="name" id="name" placeholder="이름을 입력하세요">
		<input type="text" name="m_tel" id="m_tel" placeholder="전화번호를 입력하세요">
		<input type="button" onclick="check()" value="아이디 찾기">
	</form>
</body>
</html>