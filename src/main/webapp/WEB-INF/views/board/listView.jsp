<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function writeNotice(){
		location.href="writeForm";
	}
</script>
<style type="text/css">
	.board{
		width: 80%;
		margin: 0 auto;
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
</head>
<body>
	<jsp:include page="../default/header.jsp"></jsp:include>
	<c:set var="page" value="${totalContent / 10 }"></c:set>
	<div>
		<table class="board">
			<tr>
				<td colspan="3"> <h3>공지사항</h3> <hr color="#000000"> </td>
			</tr>
			<tr> <th width="20%" align="center">조회수</th> <th width="60%" align="center">제목</th> <th width="20%" align="center">작성일</th> </tr>
			<c:forEach items="${list }" var="boardDto">
				<tr> <td colspan="3"><hr color="#EAEAEA"></td> </tr>
				<tr>
					<td align="center">${boardDto.hit }</td>
					<td align="center"><a href="contentView?write_no=${boardDto.write_no }">${boardDto.title }</a></td>
					
					<td align="center">${boardDto.savedate }</td>
				</tr>
			</c:forEach>
			<tr> <td colspan="3"><hr color="#EAEAEA"></td> </tr>
			<tr>
				<td colspan="3" align="center">
					<c:forEach begin="1" end="${totalPage }" var="page">
						<a href="listView?page=${page }">${page }</a> &nbsp;
					</c:forEach>
				</td>
			</tr>
			<tr> <td colspan="3"><hr color="#000000"></td> </tr>
			<c:if test="${sessionScope.admin == 'admin' }">
				<tr>
					<td colspan="3" align="right"> <input type="button" onclick="writeNotice()" class="button button1" value="공지사항 등록"></td>
				</tr>
			</c:if>
		</table>
		
	</div>
</body>
</html>