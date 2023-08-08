<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : ${sessionScope.dto.getId()}</p>
	<p>비밀번호 : ${sessionScope.dto.getPassword()}</p>
	<p>이름 : ${sessionScope.dto.getName()}</p>
	<p>주소 : ${sessionScope.dto.getAddress()}</p>
</body>
</html>