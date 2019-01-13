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

		<h2>덧글 삭제</h2>
		<form action="deleteReply.bo" method="post" name="removalform">
			<ul>
			     <c:if test="${member ne null }">
			     <input type="hidden" name="memberId" value="${member.memberId }">
			     <input type="hidden" name="memberPw" value="${member.memberPw }">
			     </c:if>
				<li>
				<input type="hidden" name="reply_No" value="${reply.reply_No }">
				<input type="hidden" name="review_No" value="${reply.review_No }">
				</li>
				<li><img src="img/closebox.png" height="10px" alt="xicon"><label for="reply_Writer">작성자</label></li>
				<li><span style="font-size:15px; margin-left:10px;">${reply.reply_Writer }</span><input type="hidden" name="reply_Writer" value="${reply.reply_Writer }"></li>
				<li><img src="img/closebox.png" height="10px" alt="xicon"><label for="reply_Password">비밀번호</label></li>
				<li style="text-align:center;"><input type="password" name="reply_Password" placeholder="비밀번호를 입력하십시오.	"></li>
				<li style="text-align:center;"><button type="button" onclick="removalBtn()">삭제</button>
				<button type="button" onclick="Cancel();">취소</button></li>
			</ul>
		</form>
	</div>


	<script type="text/javascript">
	
		
		function Cancel() {
			var memberId = $('input[name=memberId');
			var memberPw = $('input[name=memberPw');
			var review_No = $('input[name=review_No]');
			if (memberId.val()) {
				location.href = "selectedReviewList.bo?review_No="
					+ review_No.val()+"&memberId=" + memberId.val() + "&memberPw="+memberPw.val();
			} else {
				location.href = "selectedReviewList.bo?review_No="
						+ review_No.val();
			}
		}

		function removalBtn() {
			
			
			document.removalform.submit();
		}
	</script>
</div>