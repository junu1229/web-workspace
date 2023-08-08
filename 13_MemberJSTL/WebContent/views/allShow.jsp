<%@page import="servlet.model.vo.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="dto">
		<p>아이디 : ${dto.getId()}</p>
		<p>비밀번호 : ${dto.getPassword()}</p>
		<p>이름 : ${dto.getName()}</p>
		<p>주소 : ${dto.getAddress()}</p>
	</c:forEach>
</body>
</html>