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
	<table style="width: 100%;" border="1" id="tb">
		<tr>
			<td style="width: 10%;">번호</td>
			<td style="width: 30%;">상품이미지</td>
			<td style="width: 20%;">상품명</td>
			<td>상품가격</td>
			<td style="width: 10%;">수량</td>
			<td style="width: 10%;"><button onclick="removeCart()">삭제</button></td>
		</tr>
	</table>
	<div id="sumResult"></div>
	<script>
		var sum = 0;
		for(var i =0; i<localStorage.length; i++){
			const result = JSON.parse(localStorage.getItem(localStorage.key(i)));
			console.log(result.item_id);
			console.log(result);
			document.querySelector('#tb').innerHTML +=`
			<tr>
			<td style="width: 10%;">\${result.item_id}</td>
			<td style="width: 30%;" ><img src='\${result.picture_url}' style="width: 100%; height: 100%;"></td>
			<td style="width: 20%;">\${result.item_name}</td>
			<td class="prices" id="price\${result.item_id}">\${result.price}</td>
			<td style="width: 10%;">
				<button style="background-image: url(img/up.jpg); width: 3rem; height: 3rem; background-position: center; background-size: cover;" id='countup\${result.item_id}' class='numUp'></button>
				<div id='count\${result.item_id}' class="counts">1</div>
				<button style="background-image: url(img/down.jpg); width: 3rem; height: 3rem; background-position: center; background-size: cover;" id='countdown\${result.item_id}' class='numDown'></button>
			</td>
			<td style="width: 10%;"><input type="checkbox" name="cartitem\${result.item_id}" id="item\${result.item_id}" value"item\${result.item_id}" class='cartitem'></td>
			</tr>
			`;
			sum += result.price;
		}
		
		document.querySelectorAll('.numUp').forEach(up =>
			up.addEventListener("click", function(){
				const countId = up.id.substring(7, 8);
				document.querySelector(`#count\${countId}`).innerHTML = 1+parseInt(document.querySelector(`#count\${countId}`).textContent);
				sum += parseInt(document.querySelector(`#price\${countId}`).textContent);
				document.querySelector('#sumResult').innerHTML = `<tr style="width: 100%;" id="total">총 결제 금액: \${sum}</tr>`;
			})
		);
		document.querySelectorAll('.numDown').forEach(up =>
			up.addEventListener("click", function(){
				const countId = up.id.substring(9, 10);
				if(parseInt(document.querySelector(`#count\${countId}`).textContent)>1) {
					document.querySelector(`#count\${countId}`).innerHTML = parseInt(document.querySelector(`#count\${countId}`).textContent)-1;
					sum -= parseInt(document.querySelector(`#price\${countId}`).textContent);
					document.querySelector('#sumResult').innerHTML = `<tr style="width: 100%;" id="total">총 결제 금액: \${sum}</tr>`;
				} 
			})
		);
		const cartitems = document.querySelectorAll('.cartitem');
		function removeCart() {
			cartitems.forEach(item => {
				if(item.checked) {
					localStorage.removeItem(item.id);
					location.reload();
				}
			})
		}
		
		document.querySelector('#sumResult').innerHTML = `<p>총 결제 금액: \${sum}</p>`;
	</script>
</body>
</html>