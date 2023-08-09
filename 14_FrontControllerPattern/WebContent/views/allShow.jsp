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
	<c:forEach items="${voList}" var="vo">
		<p>아이디 : ${vo.getId()}</p>
		<p>비밀번호 : ${vo.getPassword()}</p>
		<p>이름 : ${vo.getName()}</p>
		<p>주소 : ${vo.getAddress()}</p>
	</c:forEach>
</body>
</html>