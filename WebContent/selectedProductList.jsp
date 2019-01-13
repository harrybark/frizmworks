<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberDTO member = null;
	if (session.getAttribute("sessionId") != null) {
		member = (MemberDTO) request.getAttribute("member");
		session.getAttribute("sessionId");
	}
%>

<div class="selectedView">
	<div class="subSelected">
		<h3>상품 보기</h3>
		<c:forEach var="pList" items="${productList }">
			<ul>
				
				<li><img src="upload/${pList.product_fileRealName }"
					width="200"></li>
					<hr style="width:400px;">
				<li>상품 이름 : ${pList.product_Name }</li>
					<hr style="width:400px;">
				<li>상품 설명 : <br>${pList.product_Explanation }</li>
				<li>상품 가격 : ${pList.product_Price }원</li>
				<li class="s1" style="width:400px;"><c:choose>
						<c:when test="${sessionScope.sessionId ne null }">
							<button type="button" onclick="CartfadeIn()">add to cart</button>
							<button type="button" name="buybtn" >buy it</button>
							<button type="button" onclick="goback()">뒤로 가기</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="CartfadeIn()"	disabled>add to cart</button>
							<button type="button" name="buybtn" disabled>buy it</button>
							<button type="button" onclick="goback()">뒤로 가기</button>
						</c:otherwise>
					</c:choose></li>
			</ul>
			<div class="cartView" style="display: none;">
				<form action= "" id="cartform" method="post">
					<ul class="cartView_One">
						<li><input type="hidden" name="memberId" id="memberId" class="memberId" value="${member.memberId }"></li>
						<li><input type="hidden" name="memberPw" id="memberPw" class="memberPw" value="${member.memberPw }"></li>
						<li><input type="hidden"name="product_No" value="${pList.product_No }"></li>
						<li><input type="hidden"name="product_Name" value="${pList.product_Name }"></li>
						<li class="selectbox">수량 : 
						<select name="numbers">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">12</option>
								<option value="13">13</option>
						</select>
						<img onclick="closeCart()" src="img/closebox.png" alt="closeImg" align="right"/>
						</li>
						<li><input type="hidden" name="product_Price" value="${pList.product_Price }"></li>
					</ul>
				</form>
				<ul class="cartView_Two">
					<li>
						<button type="button" onclick="addCart()">카트 담기</button> 
					</li>
					
				</ul>
			</div>
		</c:forEach>


		<script type="text/javascript">
			function CartfadeIn() {
				$('.cartView').fadeIn();
			}

			function closeCart() {
				$('.cartView').fadeOut();

			}

			function addCart() {

				var $cls = $('.cartView_Two').parents('.cartView');
				var memberId = $cls.find('input.memberId').val();
				var memberPw = $cls.find('input.memberPw').val();
				var dataform = $('#cartform').serialize();
				console.log(memberId);
				
				$.ajax({
					url : "addCart.ca",
					data : dataform,
					type : "POST",
					dataType : "json",
					success : function() {
						alert("성공 ");
						location.href="main.mo?memberId="+memberId+"&memberPw=" + memberPw;
					},
					error : function() {
						alert("error!");
					}

				}); 
			}
		</script>


		<script type="text/javascript">
			function goback() {
				window.history.go(-1);
			}
		</script>
	</div>
</div>