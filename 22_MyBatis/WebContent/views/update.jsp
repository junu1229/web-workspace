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
	<c:if test="${sessionScope.vo == null}">
		<h2>로그인이 필요합니다</h2>
	</c:if>
	<c:if test="${sessionScope.vo != null}">
		<form action="/update.do" method="post">
	        <label for="password">비밀번호 : </label>
	        <input type="password" name="password" id="password"required>
	        <label for="name">이름 : </label>
	        <input type="text" name="name" id="name" required>
	        <label for="addr">주소 : </label>
	        <input type="text" name="addr" id="addr" required>
	        <input type="submit" value="signIn">
	    </form>
	</c:if>
</body>
</html>