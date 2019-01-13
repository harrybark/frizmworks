<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO member = null;
	if (session.getAttribute("sessionId") != null) {
		member = (MemberDTO) request.getAttribute("member");
		session.getAttribute("sessionId");
	}
%>
<div class="reviewWrite">
<div class="reviewWriteform">
	<h3 class="title">REVIEW</h3>
	<h5 style="text-decoration: underline;">고객님들의 착용샷을 업로드 하는 리뷰
		게시판입니다.</h5>
	<form action="reviewComplete.bo" method="post" name="writeform" enctype="multipart/form-data">
		<ul>
			<li><%=member.getMemberId()%> 님
			 <input type="hidden" name="review_Writer" value="<%=member.getMemberId()%>" /></li>
			<li><label for="review_Subject">Subject</label>
			<input type="text" name="review_Subject" id="review_Subject"/></li>

			<li><textarea name="review_Contents" rows="20" cols="50" style="width:100%;"></textarea>
			</li>
			<li><input type="file" name="file1" /></li>
			<li><input type="file" name="file2" /></li>
			<li><label for="review_Password">Password</label> 
			<input type="password" name="review_Password" /></li>
			<li>
			<Button style="margin-left:25%;">등록</Button>
			<button type="button" onclick="Cancel();">취소</button></li>
		</ul>
	</form>
</div>
</div>
<script type="text/javascript">
	function Cancel() {
		window.history.go(-1);
	}
</script>
