<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원 정보 조회(회원 번호 검색)</h1>
    <form action="/SelectUserServlet">
        <input type="text" id="userNo" name="userNo">
        <button type="submit">조회</button>
    </form>
</body>
</html>