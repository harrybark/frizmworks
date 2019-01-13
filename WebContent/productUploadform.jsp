<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>상품 업로드</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/reset.css" media="all">
</head>
<body>

	<div id="uploadproduct">
		<div class="uploadproduct-sub1">
			<h3>업로드 게시판</h3>
			<h5>admin 계정만 이용가능한 공간 입니다.</h5>
			<form id="File_form" method="post" action="" enctype="multipart/form-data">
			<ul>
			<li>
			<label for="memberId">작성자</label> ${member.memberId } 님
			<input type="hidden" name="memberId" id="memberId" value="${member.memberId }">
			</li>
			<li>
			<label for="product_Name">상품 명</label>
			<input type="text" name="product_Name" id="product_Name"/>
			</li>
			<li>
			<label for="product_Categories">상품 분류</label>
			<select name="product_Categories">
			<option value="" selected> :: 선택 :: </option>
			<option value="outer">OUTER</option>
			<option value="top">TOP</option>
			<option value="bottom">BOTTOM</option>
			<option value="acc">ACC</option>
			</select>
			</li>
			<li>
			<label for="product_Explanation">상품 설명</label>
			<textarea rows="5" cols="20" name="product_Explanation"></textarea>
			</li>
			<li>
			<label for="product_Price">상품 가격</label>
			<input type="text" name="product_Price"/>
			</li>
			<li>
			<label for="product_Inventory">상품 재고</label>
			<input type="text" name="product_Inventory">
			</li>
			<li><input type="file" name="file1"></li>
			</ul>
			<button type="button" onclick="uploadproduct()" >상품 업로드</button>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		uploadproduct = function() {
			var memberId = $("#memberId");
			 var formData = new FormData();
			 formData.append("memberId", $("input[name=memberId]").val()); 
			 formData.append("product_Name", $("input[name=product_Name]").val()); 
			 formData.append("product_Categories", $("select[name=product_Categories]").val());
			 formData.append("product_Explanation", $("textarea[name=product_Explanation]").val());
			 formData.append("product_Price", $("input[name=product_Price]").val());
			 formData.append("product_Inventory", $("input[name=product_Inventory]").val());
			 formData.append("file1", $("input[name=file1]")[0].files[0]);
			 
		$.ajax({
			
			url : "uploadProduct.pd",
			data : formData,
			processData: false, 
			contentType: false,
			type : "POST",
			success : function(){
				alert("succes to upload");
				location.href="productList.pd?memberId="+memberId.val();
			} , error : function(){
				alert("fail to upload. try again");
				location.href="/productUploadform.pd?memberId="+memberId.val();
			}
		});
		}
	</script>
</body>
</html>