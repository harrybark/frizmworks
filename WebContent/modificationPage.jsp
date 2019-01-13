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
	
		<h2>게시글 수정</h2>
		<c:forEach var="list" items="${review_dto }">
		<form action="modificationComplete.bo?memberId=${member.memberId }" method="post" name="modform" enctype="multipart/form-data">
		<ul>
				<li><input type="hidden" name="review_No" value="${list.review_No }"></li>	
				<li>Writer : ${list.review_Writer } 님 <input type="hidden" name="review_Writer" value="${list.review_Writer }"></li>
				<li>Subject : <input type="text" name="review_Subject" value="${list.review_Subject }"></li>
				<li>
			</li>
			<li contentEditable="false" style="overflow-x:auto; height: auto;">
			<img src="upload/${list.review_fileRealName}">
			Contents : <input type="text" name="review_Contents" value="${list.review_Contents }"/>
			</li>
			<li><input type="file" name="file3" id="file3"></li>
			<li><input type="file" name="file4"></li>
			<li> Password : <input type="password" name="review_Password"></li>
			<li>
			<button type="button" onclick="modList()">수정</button></li>
			<li><Button type="button" onclick="Cancel();">취소</Button></li>
		</ul>
	</form>
		</c:forEach>
	</div>
	
	
	<script type="text/javascript">
	function Cancel() {
		window.history.go(-1);
	}
	function modList(){
		var password = $('input[name=review_Password]');
		var file3 = $('#file3').val();
		if(file3 == "" || file3 == null || file3 =='선택된 파일 없음'){
			alert('수정 할 이미지가 누락 되었습니다.');
			return false;
		}
		if(password.val() == null || $.trim(password.val()) == ''){
			alert('비밀번호를 입력하십시오.');
			password.focus();
			return false;
		}
		document.modform.submit();
	}
	
</script>
</div>