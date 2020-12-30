<%@page import="com.care.root.file.service.FileDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../default/header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<%FileDTO fdto =(FileDTO)request.getAttribute("fdto"); %>
	<table border="1">
	<tr><td>상품번호</td><td><%=fdto.getItemNum() %></td></tr>
	<tr><td>상품명</td><td><%=fdto.getItemName() %></td></tr>
	<tr><td>제조사</td><td><%=fdto.getMakerName() %></td></tr>
	<tr><td>브랜드</td><td><%=fdto.getBrandName() %></td></tr>
	<tr><td>제조국</td><td><%=fdto.getMakeRegion() %></td></tr>
	<tr><td>원산지</td><td><%=fdto.getItemRegion() %></td></tr>
	<tr><td>총중량</td><td><%=fdto.getKg() %></td></tr>
	<tr><td>상품설명</td><td><%=fdto.getItemValue() %></td></tr>
	<tr><td>상품사진</td><td><img src="C:/Users/heamok/Desktop/hm/image/<%=fdto.getItemNum() %>.jpg"></td></tr>

	</table>	
</body>
</html>