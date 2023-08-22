<%@page import="model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div >
		<input style="margin-top: 3rem; margin-left: 5%; width: 60%;" type="text" id="search" name="search">
		<button type="button" id="searchBtn">검색</button>
	</div>
	<div style="display: flex; justify-content: center; margin-top: 3rem;">
		<p style="width: 15%;">학번</p>
		<p style="width: 10%;">이름</p>
		<p style="width: 50%;">주소</p>
		<p style="width: 10%;">학과</p>
		<p style="width: 10%;">계열</p>
	</div>
	<hr style="margin: 0;">
	<div id="result" >
	</div>
    <script>
		$('#searchBtn').click(function() {
			const search = $('#search').val();
			$.ajax({
				type: 'post',
				url: 'find.do',
				data: "search=" + search,
				dataType: 'json',
				
				success: function(data) {
					let resulthtml ='';
					// $('#result').html(data.result);
					const result = eval(data.result);
					for(let item of result) {
						resulthtml += '<div style="display: flex;">'+'<p style="width: 15%;">'+item.studentNo+'</p>'+
										'<p style="width: 10%;">'+item.studentName+'</p>'+
										'<p style="width: 50%;">'+item.studentAddress+'</p>'+
										'<p style="width: 10%;">'+item.department.departmentName+'</p>'+
										'<p style="width: 10%;">'+item.department.category+'</p>'+'</div>';
					}
					$('#result').html(resulthtml);
				}
			});
		});
		$(document).ready(function() {
			$.ajax({
				type: 'post',
				url: 'find.do',
				dataType: 'json',
				
				success: function(data) {
					let resulthtml ='';
					const result = eval(data.result);
					for(let item of result) {
						resulthtml += '<div style="display: flex;">'+'<p style="width: 15%;">'+item.studentNo+'</p>'+
						'<p style="width: 10%;">'+item.studentName+'</p>'+
						'<p style="width: 50%;">'+item.studentAddress+'</p>'+
						'<p style="width: 10%;">'+item.department.departmentName+'</p>'+
						'<p style="width: 10%;">'+item.department.category+'</p>'+'</div>';
					}
					$('#result').html(resulthtml);
				}
			});
		}) 
	</script>
</body>
</html>