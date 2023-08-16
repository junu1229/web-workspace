<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h1 {
		text-align: center;
	}
	div {
		display: flex;
		justify-content: center;
	}
	a {
		margin: 0 1rem;
		text-decoration: none;
		color: black;
	}
	img {
		width: 100%;
		height: 50%;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>Fruit Total List</h1>
	<div>
		<c:forEach items="${itemList}" var="item">
			<a href="itemView.do?item_id=${item.getItemId()}">
				<img src="${item.getPictureUrl()}" alt="">
				<p>상품명 : ${item.getItemName()}</p>
				<p>가격 : ${item.getPrice()}</p>
			</a>
		</c:forEach>
	</div>
	<hr>
	<h1>오늘 본 상품들</h1>
	<div>
		<% Cookie[] cs = request.getCookies();
			for(Cookie c:cs) {
				if(c.getName().contains("item")) {%>
				<img style="width: 8rem; height: 8rem; margin: 0 1rem;" src="<%= c.getValue() %>">
			<%}
			}
		%>
	</div>
	<script>
		
	</script>
</body>
</html>