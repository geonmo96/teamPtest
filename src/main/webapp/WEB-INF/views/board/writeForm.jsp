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
	function writeNotice(){
		var title = $("#title").val();
		var content = $("#content").val();
		if(title == false){
			alert("공지사항 제목을 입력하세요");
		} else if(content == false){
			alert("공지사항 내용을 입력하세요");
		} else{
			alert("새로운 공지사항이 등록되었습니다")
			fo.submit();
		}
	}
</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<form action="write" method="post" id="fo">
		<div style="width: 60%; margin: 0 auto;">
			<h3>공지사항 작성</h3>
			<hr color="#000000">
			<div align="center">
				<input type="text" name="title" id="title" value="${boardDto.title }" style="height:50px; width:680px" placeholder="제목"><br>
				<textarea rows="50" cols="100" name="content" id="content" placeholder="내용">${boardDto.content }</textarea><br>
				<input type="button" value="공지사항 작성" onclick="writeNotice()" class="button button1">	
			</div>
		</div>
		
	</form>
</body>
</html>