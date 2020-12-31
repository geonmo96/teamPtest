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
	<tr><td>카테고리</td><td><% 
	if(fdto.getCategorynum() == 1){
		%>육지<%
	}
	else if(fdto.getCategorynum() == 2){
		%>해상<%
	}
	else if(fdto.getCategorynum() == 3){
		%>공중<%
	};
							%></td></tr>
	
	<tr><td>상품번호</td><td><%=fdto.getItemNum() %></td></tr>
	<tr><td>상품명</td><td><%=fdto.getItemName() %></td></tr>
	<tr><td>상품금액</td><td><%=fdto.getItemprice() %>원</td></tr>
	<tr><td>제조사</td><td><%=fdto.getMakerName() %></td></tr>
	<tr><td>브랜드</td><td><%=fdto.getBrandName() %></td></tr>
	<tr><td>제조국</td><td><%=fdto.getMakeRegion() %></td></tr>
	<tr><td>원산지</td><td><%=fdto.getItemRegion() %></td></tr>
	<tr><td>총중량</td><td><%=fdto.getKg() %>
	<%if(fdto.getKgpic() == 1){
		%>g<%
	}
	else if(fdto.getKgpic() == 2){
		%>Kg<%
	}
	else if(fdto.getKgpic() == 3){
		%>T<%
	};%>
	</td></tr>
	<tr><td>상품설명</td><td><%=fdto.getItemValue() %></td></tr>
	<tr><td>상품사진</td><td>		<img src="../../img/<%=fdto.getItemNum()%>.jpg" style="width:150px;" ></td></tr>
	<tr><td><a href="#">구매</a></td><td><a href="#">장바구니</a></td><td><a href=../item/list>목록보기</a>



	</table>	
</body>
</html>