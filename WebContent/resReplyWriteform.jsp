<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.reply-header {
	width: 250px;
	height: 400px;
	margin: 0 auto;
}

h3 {
	width: 250px;
}

form[name=replyform]>input, h3 {
	text-align: center;
}

button {
	width: 100px;
	height: 30px;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="reply-header">
		<h3>댓글 쓰기</h3>
		<form
			action="reReply.bo?review_No=${reply.review_No }&reply_No=${reply.reply_No }&reply_Group=${reply.reply_Group }&reply_Indent=${reply.reply_Indent}&reply_Step=${reply.reply_Step}"
			method="post" name="replyform">
			<input type="hidden" name="reply_Group" value="${reply.reply_Group }">
			<input type="hidden" name="review_No" class="review_No2" value="${reply.review_No }">
			<c:if test="${member ne null }">
				<input type="hidden" class="memberId" name="memberId" id="memberId"
					value="${member.memberId }">
				<input type="hidden" class="memberPw" name="memberPw"
					value="${member.memberPw }">
			</c:if>
			<c:forEach var="list2" items="${review_list }">
				<input type="hidden" class="review_No" name="review_No"
					value="${list2.review_No}">
			</c:forEach>
			<div style="padding: 5px 0;">
				<img src="img/closebox.png" alt="xicon" style="width: 10px;">
				<label for="reply_Writer">작성자</label>
			</div>
			<c:if test="${member eq null }">
				<div style="text-align: center;">
					<input type="text" name="reply_Writer" class="reply_Writer"
						style="width: 230px;">
				</div>
			</c:if>
			<c:if test="${member ne null }">
				<div>
					<span style="margin-left: 10px;">${member.memberId } 님</span> <input
						type="hidden" name="reply_Writer" class="reply_Writer"
						value="${member.memberId }" style="width: 230px;">
				</div>
			</c:if>
			<div style="padding: 5px 0;">
				<img src="img/closebox.png" alt="xicon" style="width: 10px;">
				<label for="reply_Subject">제목</label>
			</div>
			<div style="text-align: center;">
				<input type="text" name="reply_Subject" id="reply_Subject"
					class="reply_Subject" style="width: 230px;">
			</div>
			<div style="padding: 5px 0;">
				<img src="img/closebox.png" alt="xicon" style="width: 10px;">
				<label for="reply_Contents">내용</label>
			</div>
			<div style="text-align: center;">
				<textarea rows="5" cols="30" name="reply_Contents"
					class="reply_Contents" style="width: 230px;"></textarea>
			</div>
			<div style="padding: 5px 0;">
				<img src="img/closebox.png" alt="xicon" style="width: 10px;">
				<label for="reply_Password">비밀번호</label>
			</div>
			<div style="text-align: center;">
				<input type="password" name="reply_Password" class="reply_Password"
					style="width: 230px;">
			</div>
			<div style="text-align: center; width: 100%; padding-top: 10px;">
				<button name="reply">댓글 작성</button>
			</div>
			<div
				style="text-align: center; width: 100%; padding-top: 5px; padding-bottom: 10px;">
				<button type="button" name="replyCancelBtn">작성 취소</button>
			</div>
		</form>
	</div>
	<script>
		$('button[name=replyCancelBtn]').click(function() {

			var memberId = $('input[name=memberId]').val();
			var memberPw = $('input[name=memberPw]').val();
			var review_No = $('input.review_No2').val();
			
			if (memberId != null) {
				location.href = "selectedReviewList.bo?memberId="+memberId + "&memberPw="+memberPw +"&review_No=" + review_No;
			} else {
				location.href = "selectedReviewList.bo?review_No=" + review_No;
			}
		});
	</script>
</body>
</html>