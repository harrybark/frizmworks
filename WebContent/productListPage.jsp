<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberDTO member = null;
	if (session.getAttribute("sessionId") != null) {
		member = (MemberDTO) request.getAttribute("member");

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List Page</title>
</head>
<body>

	<div class="product-list">
		<div class="sub-productlist">

			<c:choose>
				<c:when test="${member.memberId ne null}">
					<c:forEach var="list" items="${pList }">
						<div class="product-s1">
							<a href="selectedProduct.pd?memberId=${member.memberId }&product_No=${list.product_No}">
								<ul>
									<li><img src="upload/${list.product_fileRealName }"
										src="realImg" /></li>
										<hr >
									<li class="s1" style="margin:5px 0;">상품 이름 : ${ list.product_Name}</li>
									    <hr >
									<li style="margin:5px 0;">상품 설명 : <br>${list.product_Explanation }</li>
									<li style="margin:10px 0;">상품 가격 : ${list.product_Price }원</li>
									<hr>
								</ul>
							</a>
						</div>
					</c:forEach>

				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${pList }">
						<div class="product-s1">
							<a href="selectedProduct.pd?product_No=${list.product_No}">
								<ul>
									<li><img src="upload/${list.product_fileRealName }"
										src="realImg" /></li>
										<hr>
									<li class="s1" style="margin:5px 0;"> 상품 이름 : ${ list.product_Name}</li>
									    <hr>
									<li style="margin:5px 0;">상품 설명 : <br>${list.product_Explanation }</li>
									<li style="margin:10px 0;">상품 가격 : ${list.product_Price }원</li>
								<hr>
								</ul>
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<div class="product-upload">
		<c:if test="${member.memberId eq 'admin' }">
			<a href="productUploadform.pd?memberId=${member.memberId }">상품등록</a>
		</c:if>
	</div>
</body>
</html>