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

		<h2>덧글 수정</h2>
		<form name="modform">
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
				<li><img src="img/closebox.png" height="10px" alt="xicon"><label for="reply_Subject">제목</label></li>
				<li><input type="text" name="reply_Subject" value="${reply.reply_Subject }"></li>
			
				<li><img src="img/closebox.png" height="10px" alt="xicon"><label for="reply_Contents">내용</label></li>
				<li >
				<textarea id="reply_Cotents" name="reply_Contents">${reply.reply_Contents }</textarea>
				</li>
			
				<li><img src="img/closebox.png" height="10px" alt="xicon"><label for="reply_Password">비밀번호</label></li>
				<li style="text-align:center;"><input type="password" name="reply_Password" placeholder="비밀번호를 입력하십시오.	"></li>
				<li style="text-align:center;">
				<button type="button" onclick="modBtn()">수정</button>
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
						+ review_No.val() + "&memberId=" + memberId.val()
						+ "&memberPw=" + memberPw.val();
			} else {
				location.href = "selectedReviewList.bo?review_No="
						+ review_No.val();
			}
		}

		function modBtn() {

			var memberId = $('input[name=memberId');
			var memberPw = $('input[name=memberPw');
			var reply_No = $('input[name=reply_No');
			var review_No = $('input[name=review_No]');
			var reply_Writer = $('input[name=reply_Writer]');
			var reply_Subject = $('input[name=reply_Subject]');
			var reply_Contents = $('textarea[name=reply_Contents]');
			var reply_Password = $('input[name=reply_Password]');

			var data;

			if (memberId.val()) {
				data = "reply_No=" + reply_No.val() + "&review_No=" + review_No.val() + "&reply_Writer=" + reply_Writer.val() + "&reply_Subject=" + reply_Subject.val() 
 				+ "&reply_Contents=" + reply_Contents.val() + "&reply_Password=" + reply_Password.val() + "&memberId=" + memberId.val() + "&memberPw=" + memberPw.val();
			} else {
 				data = "reply_No=" + reply_No.val() + "&review_No=" + review_No.val() + "&reply_Writer=" + reply_Writer.val() + "&reply_Subject=" + reply_Subject.val() 
 				+ "&reply_Contents=" + reply_Contents.val() + "&reply_Password=" + reply_Password.val();
			}
			
			console.log(data);
			$.ajax({
				url : "modReply.bo",
				type : "post",
				data : data,
				success : function(result) {
					console.log(result);
					if(result == 2){
						alert('덧글 수정을 성공했습니다.');
						location.href="selectedReviewList.bo?review_No=" + review_No.val() + "&memberId=" + memberId.val() + "&memberPw=" + memberPw.val();
					} else if(result == -2){
						alert('덧글의 암호가 일치하지 않습니다.');
						location.href="modReplyPage.bo?review_No=" + review_No.val() + "&reply_No="+ reply_No.val() + "&memberId=" + memberId.val() + "&memberPw=" + memberPw.val();
					} else if(result == 1){
						alert('덧글 수정을 성공했습니다.');
						location.href="selectedReviewList.bo?review_No=" + review_No.val();
					} else if(result == -1){
						alert('덧글의 암호가 일치하지 않습니다.');
						location.href="modReplyPage.bo?review_No=" + review_No.val() + "&reply_No="+ reply_No.val();
					} else{
						alert('에러입니다.');
						location.href="selectedReviewList.bo?review_No=" + review_No.val();
					}
				}
			});
			document.modform.submit();
		}
	</script>
</div>