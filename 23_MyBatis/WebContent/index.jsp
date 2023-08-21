<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
    <input type="text" id="search" name="search">
    <button type="button" id="searchBtn"></button>
    <div>
        <p>학번</p>
        <p>이름</p>
        <p>주소</p>
        <p>학과</p>
        <p>계열</p>
    </div>
    <script>
		$('#searchBtn').click(function() {
			const string = $('#search').val();
			$.ajax({
				type: 'post',
				url: 'find.do',
				data: string,
				
				success:function(data) {
					console.log(data.result);
					const result = eval(`(${data.result})`);
					console.log(result);
				}
			});
		});
	</script>
</body>
</html>