<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	location.href="https://nid.naver.com/oauth2.0/authorize?client_id=0jF_bgnlPUqcPix8EEPa&response_type=code&redirect_uri=http://localhost:8080/root/member/loginNaver&state=${sessionScope.state}"
</script>
</body>
</html>