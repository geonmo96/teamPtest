<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	function checkBlank(){
		var title = $("#title").val();
		var content = $("#content").val();
		if(title == false){
			alert("제목이 없습니다")
		} else if(content == false){
			alert("내용이 없습니다")
		} else {
			alert("수정되었습니다");
			fo.submit();
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<form action="modify" method="post" id="fo">
		<input type="hidden" name="write_no" value="${boardDto.write_no }">
		<div style="width: 60%; margin: 0 auto;">
			<h3>공지사항 수정</h3>
			<hr color="#000000">
			<div align="center">
				<input type="text" name="title" id="title" value="${boardDto.title }" style="height:50px; width:680px" placeholder="제목"><br>
				<textarea rows="50" cols="100" name="content" id="content" placeholder="내용">${boardDto.content }</textarea><br>
				<input type="button" onclick="checkBlank()" value="공지사항 수정" class="button button1">
			</div>
		</div>
	</form>
</body>
</html>