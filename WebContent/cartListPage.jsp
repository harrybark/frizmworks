<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="cartList">
		<div class="subList">
			<h3>장바구니 목록</h3>
			<c:set var="cart" value="${cartList}"/>
			<c:set var="member" value="${member}"/>
			<c:if test="${empty cart}">
			<h4>카트가 비어있습니다.
			<p style="margin:20px 0;"><a href="productList.pd?memberId=${member.memberId }&memberPw=${member.memberPw}" style="text-align:center; text-decoration:underline; height:30px; color:red;">VIEW MORE PRODUCT</a></p>
			
			</h4>
			</c:if>
			<c:forEach var="list" items="${cartList }" varStatus="status">
				<div class="cart-s1">
				<ul>
					<h4>[ 목록 ]</h4>
					<li><input type="hidden" name="cart_No" class="cart_No"
						value="${list.cart_No }"></li>
					<li>아이디 : <span style="text-decoration:underline">${list.memberId }</span> <input type="hidden" name="memberId"
						class="memberId" value="${list.memberId }"></li>
					<li><input type="hidden" name="memberPw" class="memberPw"
						name="memberPw" value="${member.memberPw }"></li>
					<li><input type="hidden" name="product_No" class="product_No"
						name="product_No" value="${list.product_No }"></li>
					<li>상품 명 : ${list.product_Name }<input type="hidden"
						name="product_Name" class="product_Name"
						value="${list.product_Name }"></li>
					<li class="div1">상품 개수 : <select id="numbers" class="numbers">
							<option value="1" ${list.numbers eq 1 ? 'selected' : ''}>1</option>
							<option value="2" ${list.numbers eq 2 ? 'selected' : ''}>2</option>
							<option value="3" ${list.numbers eq 3 ? 'selected' : ''}>3</option>
							<option value="4" ${list.numbers eq 4 ? 'selected' : ''}>4</option>
							<option value="5" ${list.numbers eq 5 ? 'selected' : ''}>5</option>
							<option value="6" ${list.numbers eq 6 ? 'selected' : ''}>6</option>
							<option value="7" ${list.numbers eq 7 ? 'selected' : ''}>7</option>
							<option value="8" ${list.numbers eq 8 ? 'selected' : ''}>8</option>
							<option value="9" ${list.numbers eq 9 ? 'selected' : ''}>9</option>
							<option value="10" ${list.numbers eq 10 ? 'selected' : ''}>10</option>
					</select>

					</li>
					<li>상품 가격 : ${list.product_Price }<input type="hidden" name="product_Price"
						class="product_Price" disabled="disabled"
						value="${list.product_Price }"></li>
					<li>상품 총 가격 : ${list.product_Price* list.numbers } <input type="hidden" name="totalPrice"
						class="totalPrice"  
						value="${list.product_Price* list.numbers }">
					</li>
					<li>
						<button onclick="payment()" stlye="margin-left:15px;">구매하기</button>
						<button type="button" class="removeCart">삭제하기</button>
					</li>
				</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		$('select.numbers').change(function mod() {
					/* 상품 수량 변경 스크립트 */
					var $ul = $(this).parents('ul');
					var val = $ul.find('input.numbers').val()

					var cart_No = $ul.find('input.cart_No').val();
					var memberId = $ul.find('input.memberId').val();
					var memberPw = $ul.find('input.memberPw').val();
					var product_No = $ul.find('input.product_No').val();
					var product_Name = $ul.find('input.product_Name').val();

					var numbers = $ul.find('select.numbers').val();
					var product_Price = $ul.find('input.product_Price').val();
					var totalPrice = $ul.find('input.totalPrice').val();

					var dataString = "cart_No=" + cart_No + "&memberId="
							+ memberId + "&product_No=" + product_No
							+ "&product_Name=" + product_Name + "&numbers="
							+ numbers + "&product_Price=" + product_Price
							+ "&totalPrice=" + totalPrice;

					$.ajax({
						url : "cartNumberChange.ca",
						data : dataString,
						type : "get",
						dataType : "text",
						success : function(result) {
							alert("수량을 변경하였습니다.");
							console.log(result);
							location.href = "cartList.ca?memberId=" + memberId
									+ "&memberPw=" + memberPw;
						},
						error : function(result) {
							alert("수량 변경 오류 입니다.");
							console.log(result);
							location.href = "cartList.ca?memberId=" + memberId
									+ "&memberPw=" + memberPw;
						}
					});
				});

		$('button.removeCart').click(function removeCartIndex() {
			/* 장바구니 삭제 */
			var $ul = $(this).parents('ul');
			var val = $ul.find('input.numbers').val()

			var cart_No = $ul.find('input.cart_No').val();
			var memberId = $ul.find('input.memberId').val();
			var memberPw = $ul.find('input.memberPw').val();
			var product_No = $ul.find('input.product_No').val();

			var dataString = "cart_No=" + cart_No + "&memberId=" + memberId
					+ "&product_No=" + product_No;

			$.ajax({
				url : "cartIndexRemove.ca",
				data : dataString,
				type : "get",
				dataType : "text",
				success : function() {
					alert("카트 목록을 삭제하였습니다.");
					location.href = "cartList.ca?memberId=" + memberId
							+ "&memberPw=" + memberPw;
				},
				error : function() {
					alert("카트 목록 삭제 오류 입니다.");
					location.href = "cartList.ca?memberId=" + memberId
							+ "&memberPw=" + memberPw;
				}
			});

		});
	</script>
</body>
</html>
