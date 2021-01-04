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
	
	<form action="idAuthCheck" method="post" id="fo">
	<table class="table">
		<tr>
			<td colspan="2"><h3>전화번호로 아이디 찾기</h3><hr></td>
		</tr>
		<tr>
			<td align="center"><input type="text" name="name" id="name" placeholder="이름을 입력하세요" style="text-align:left; width:60%; height:30px;"></td>
		</tr>
		<tr>
			<td align="center"><input type="text" name="m_tel" id="m_tel" placeholder="전화번호를 입력하세요" style="text-align:left; width:60%; height:30px;"></td>
		</tr>
		<tr>
			<td align="center"><input type="button" onclick="check()" value="아이디 찾기" class="button button1"></td>
		</tr>
	</table>
	</form>
</body>
</html>