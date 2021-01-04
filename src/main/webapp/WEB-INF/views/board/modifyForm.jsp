<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<input type="text" name="title" id="title" value="${boardDto.title }"><br>
		<textarea rows="50" cols="100" name="content" id="content">${boardDto.content }</textarea>
		<input type="button" onclick="checkBlank()" value="공지사항 수정">
	</form>
</body>
</html>