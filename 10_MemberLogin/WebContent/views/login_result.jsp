<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% MemberDTO dto = (MemberDTO)session.getAttribute("dto"); %>
</head>
<body>
	<p>아이디 : <%= dto.getId() %></p>
	<p>비밀번호 : <%= dto.getPassword() %></p>
	<p>이름 : <%= dto.getName() %></p>
	<p>주소 : <%= dto.getAddress() %></p>
</body>
</html>