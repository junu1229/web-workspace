<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
MemberVO mv = (MemberVO) request.getAttribute("mv");
System.out.println(mv);
%>
</head>
<body>
	<div class="container">
    	<% if(mv.getName()!=null) { %>
	        <h2>검색한 인원입니다.</h2>
	        <th>이름 : <%= mv.getName() %></th>
	        <th>나이 : <%= mv.getAge() %></th>
	        <th>주소 : <%= mv.getAddr() %></th>
        <% } else {%>
        	<h2>없는 인원 입니다.</h2>
        	<% } %>
    </div>
</body>
</html>