<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : ${sessionScope.vo.getId()}</p>
	<p>비밀번호 : ${sessionScope.vo.getPassword()}</p>
	<p>이름 : ${sessionScope.vo.getName()}</p>
	<p>주소 : ${sessionScope.vo.getAddress()}</p>
</body>
</html>