<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%= request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload Form</title>

<style>
body {

	font-family: "Trebuchet MS", "Helvetica", "Arial",  "Verdana", "sans-serif";

	font-size: 80%;
}
</style>
</head>
<body>
	<%response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8"); %>
	<jsp:include page="../default/header.jsp"></jsp:include>

	<c:set var="path" value="${pageContext.request.contextPath }"/>
<h3>상품 등록</h3>
<form action="${path}/seller/upload" method="post" enctype="multipart/form-data">
	<select class="category" name="categorynum">
	<option value="0">전체</option>
	<option value="1">육지</option>
	<option value="2">해상</option>
	<option value="3">공중</option>
	</select><br>
	<label>상품명 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
	</label><input type="text" name="itemName"><br>
	<label>제조사 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
	 </label><input type="text" name="makerName"><br>
	<label>브랜드 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
	</label><input type="text" name="brandName"><br>
	<label>원산지 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
	</label><input type="text" name="makeRegion"><br>
	<label>상품무게 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <select class="category" name="kgpic">
	<option value="0">단위</option>
	<option value="1">g</option>
	<option value="2">Kg</option>
	<option value="3">T</option>
	</select>
	</label><input type="text" name="kg"><br>
	<label>상품가격 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
	</label><input type="text" name="itemprice"><br>
	<label>재료원산지 &nbsp;&nbsp;: </label><input type="text" name="itemRegion"><br>
	<label>상품설명 &nbsp;&nbsp;: </label><br><textarea name="itemValue"></textarea>
	<br>
	<input type="file" name="file">
	<input type="submit" value="업로드">
</form>


</body>
</html>