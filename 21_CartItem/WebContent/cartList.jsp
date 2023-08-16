<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align: center;
	}
</style>
</head>
<body>
	<h1 style="text-align: center;">장바구니</h1>
	<div style="display: flex; justify-content: end;">
		<a href="itemList.do">쇼핑 계속하기</a>
	</div>
	<table style="width: 100%;" border="1">
		<tr>
			<td style="width: 10%;">번호</td>
			<td style="width: 30%;">상품이미지</td>
			<td style="width: 20%;">상품명</td>
			<td>상품가격</td>
			<td style="width: 10%;">수량</td>
			<td style="width: 10%;"><button onclick="removeCart()">삭제</button></td>
		</tr>
	</table>
	<script>
		for(var i =0; i<localStorage.length; i++){
			console.log(localStorage.getItem(localStorage.key(i)));
		}
	</script>
</body>
</html>