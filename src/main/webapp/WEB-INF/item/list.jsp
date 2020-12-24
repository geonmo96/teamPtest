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
<%FileDTO dto = new FileDTO(); 
FileServiceImpl fisv = new FileServiceImpl();
int fileListNum = fisv.fileList(); 
if(fileListNum == 0){
%>
<script type="text/javascript">
alert('리스트 없음');
</script>
<%}else if(fileListNum > 0){
	ArrayList<String> itemnumbers = fisv.fileallnum();
	for(int i = 0; i < fileListNum ; i ++){
	String itemnum = itemnumbers.get(i);%>
	<a href="/seller/itemView/itme?=<%=itemnum %>"><img src=" <%=itemnum%>.jpg"></a>
	<% } 
	}
	%>



</body>
</html>