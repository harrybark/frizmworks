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

<div class="modificationPage">
	<div class="modification-sub">
	
		<h2>게시글 삭제</h2>
		<c:forEach var="list" items="${review_dto }">
		<form action="removalComplete.bo?memberId=${member.memberId }" method="post" name="removalform">
		<ul>
				<li><input type="hidden" name="review_No" value="${list.review_No }"></li>	
				<li>Writer : ${list.review_Writer } 님 <input type="hidden" name="review_Writer" value="${list.review_Writer }"></li>
				<li>Subject : ${list.review_Subject }</li>
				<li>
			</li>
			<li contentEditable="false" style="overflow-x:auto; height: auto;">
			<img src="upload/${list.review_fileRealName}">
			Contents : ${list.review_Contents }
			</li>
			<li> Password : <input type="password" name="review_Password"></li>
			<li><button type="button" onclick="removalBtn()">삭제</button><li>
			<li><Button type="button" onclick="Cancel();">취소</Button></li>
			
		</ul>
	</form>
		</c:forEach>
	</div>
	
	
	<script type="text/javascript">
	function Cancel() {
		window.history.go(-1);
	}

	function removalBtn(){
		document.removalform.submit();
	}
	
</script>
</div>