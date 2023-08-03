<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<%
String name = request.getParameter("name");
List<MemberVO> list = (List<MemberVO>) application.getAttribute("list");
//List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
%>
</head>
<body>
    <div class="container">
        <h2>전체 Cafe 명단 리스트</h2>
        <% if(name!=null) { %>
        <h4><%= name %>님이 방금전 회원가입 하셨습니다.</h4>
        <% } %>
        <table class="table">
        <% if(list!=null) { %>
            <% for(MemberVO mv:list) { %>
            <tr>
                <th>이름 :<%= mv.getName() %></th>
                <th>나이 :<%= mv.getAge() %></th>
                <th>주소 :<%= mv.getAddr() %></th>
            </tr>
            <%} %>
        <% } %>
        </table>
    </div>
</body>
</html>