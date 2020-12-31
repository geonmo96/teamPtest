<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.care.root.file.service.FileServiceImpl"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table border = "1">
	<c:forEach var="item" items="${alllist }" begin="0" end="${allnum }" varStatus="number">
	<td><a href="itemview?itemnum=${alllist.get(number.index)}"> <img src="../../img/${alllist.get(number.index)}.jpg" style="width:150px;" ></a></td>
	</c:forEach>
	</table>
</body>
</html>