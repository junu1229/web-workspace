<%@page import="model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    h1 {
        text-align: center;
    }
    a {
        text-decoration: none;
        color: black;
        margin: 0 1rem;
    }
    p {
        margin: 0 1rem;
    }
    input {
        margin: 0 1rem;
    }
    .in {
        margin: 1rem 1rem;
    }
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<% Item item = (Item)request.getAttribute("item"); %>
</head>
<body>
	<h1>${item.getItemName()}의 정보</h1>
    <div style="display: flex; justify-content: end;">
        <p>조회수 : ${item.getCount()}</p>
        <a href="#" id="addCart">장바구니 담기</a>
        <a href="cartList.jsp">장바구니 확인</a>
        <a href="itemList.do">상품 목록 보기</a>
    </div>
    <div style="display: flex;">
        <img src="${item.getPictureUrl()}" style="width: 50%;">
        <div style="align-items: start; display: flex; flex-direction: column; justify-content: center;" >
            <p class="in">종 류 : ${item.getItemName()}</p>
            <p class="in">가 격 : ${item.getPrice()}</p>
            <p class="in">설 명 : ${item.getDescription()}</p>
            <p class="in">설 명 : ${item.toString()}</p>
        </div>
    </div>
    <script>
	    $('#addCart').click(function(){
	    	localStorage.setItem("item"+${item.getItemId()}, '${item}');
	    	alert("장바구니 담기 성공!");
        });
		function view() {
			document.querySelector("#resultView").innerHTML = localStorage.getItem("test");
		};
		function remove() {
			localStorage.removeItem("test");
			location.reload();
		};
    </script>
</body>
</html>