<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	MemberDTO member = null;
	if (session.getAttribute("sessionId") != null) {
		member = (MemberDTO) request.getAttribute("member");
		session.getAttribute("sessionId");
	}
%>
<script type="text/javascript">
	$(function() {

		$('#replyshowbtn').click(function() {
			$('.reply-contents').slideToggle();
			if ($(this).text() == 'Show reply list') {
				$(this).text('Hide reply list');

			} else if ($(this).text() == 'Hide reply list') {
				$(this).text('Show reply list');
			} else {
				return false;
			}
		});
	});
</script>


<div class="selectedListPage">
	<div class="sub-selectedListPage">
		<h2>게시글 보기</h2>
		<c:forEach var="list" items="${review_list }">
			<ul>
				<li>Writer : ${list.review_Writer } 님 <input type="hidden"
					name="review_Writer" value="${list.review_Writer }" /></li>
				<li><label for="review_Subject">Subject : </label>
					${list.review_Subject } <input type="hidden" name="review_Subject"
					value="${list.review_Subject }" /></li>


				<li contentEditable="false"
					style="overflow-x: auto; width: 100%; height: auto;"><img
					src="upload/${list.review_fileRealName}" width="100%"> 내용 <br>${list.review_Contents }
					<textarea rows="" cols="" style="visibility: hidden;">
					<img src="upload/${list.review_fileRealName}"></textarea><input
					type=hidden name="review_Contents" value="${list.review_Contents }" />
				</li>
				<li><c:if test="${member.memberId eq list.review_Writer }">
						<a
							href="reviewmodify.bo?review_No=${list.review_No }&memberId=${member.memberId}&memberPw=${member.memberPw}"><button
								type="button" name="modBtn" style="margin-left: 1%;">게시글
								수정</button></a>
						<a
							href="reviewDelete.bo?review_No=${list.review_No }&memberId=${member.memberId}&memberPw=${member.memberPw}"><button
								type="button" style="margin: 0 10px">게시글 삭제</button></a>
						<button type="button" name="replyBtn" style="margin-right: 10px;">댓글쓰기</button>
						<button type="button" onclick="goback()">뒤로 가기</button>
					</c:if> <c:if test="${member.memberId ne list.review_Writer }">
						<a
							href="reviewmodify.bo?review_No=${list.review_No }&memberId=${member.memberId}&memberPw=${member.memberPw}"><button
								type="button" style="margin-left: 1%;" disabled>게시글 수정</button></a>
						<a
							href="reviewDelete.bo?review_No=${list.review_No }&memberId=${member.memberId}&memberPw=${member.memberPw}"><button
								type="button" style="margin: 0 10px;" disabled>게시글 삭제</button></a>
						<button type="button" name="replyBtn" style="margin-right: 10px;">댓글쓰기</button>
						<button type="button" onclick="goback()">뒤로 가기</button>
					</c:if></li>


				<c:if test="${fn:length(replyList) gt 0}">



					<li style="text-align: center;">
						<button id="replyshowbtn" style="width: 98%; margin: 0 1%;">Show reply list</button>
					</li>
				</c:if>
			</ul>


		</c:forEach>

	</div>

	<div class="reply-contents" style="display:none">
		<div style="text-align: center;">
			<h3>[ REPLY LIST ]</h3>
			<c:choose>

				<c:when test="${fn:length(replyList) gt 0}">
					<table border="1px" class="replyList"
						style="text-align: center; background: #efefef; table-layout: fixed;">
						<thead>
							<tr>
								<th>작성자</th>
								<th>제목</th>
								<th>내용</th>
								<th>답글</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<c:forEach var="re" items="${replyList }">
							<tbody style="text-align: center;">
								<tr>
									<td width="150"><c:forEach begin="1" step="1" end="${re.reply_Indent }">
											<img src="img/commentimg.png" width="12" />
										</c:forEach>${re.reply_Writer }
										<input type="hidden"class="reply_Writer" value="${re.reply_Writer }">
										<input type="hidden"class="reply_No" value="${re.reply_No }">
										<input type="hidden"class="review_No" value="${re.review_No }">
										<c:if test="${member.memberId ne null }">
										<input type="hidden" class="memberId" value="${member.memberId }">
										<input type="hidden" class="memberPw" value="${member.memberPw }">
										</c:if>
										</td>
									<td width="200">
										<div class="text-ellipsis">
											<p>${re.reply_Subject }</p>
										</div>
									</td>
									<td class="reply_contents" id="reply_contents" width="300"><div
											class="text-ellipsis">
											<p>${re.reply_Contents }</p>
										</div></td>
									<td width="100"><button type="button" class="reBtn">답글
											달기</button></td>

									<c:if test="${member.memberId eq null }">
										<td width="60"><a
											href="modReplyPage.bo?review_No=${re.review_No }&reply_No=${re.reply_No}"><button
													type="button" class="modBtn">수정</button></a></td>
									</c:if>
									<c:if test="${member.memberId ne null}">
										<td width="60"><a
											href="modReplyPage.bo?review_No=${re.review_No }&reply_No=${re.reply_No}&memberId=${member.memberId}&memberPw=${member.memberPw}"><button
													type="button" class="modBtn">수정</button> </a></td>
									</c:if>
									<c:if test="${member.memberId eq null }">
										<td width="60"><a
											href="removalReplyPage.bo?review_No=${re.review_No }&reply_No=${re.reply_No}">
												<button type="button" class="removalBtn">삭제</button>
										</a></td>
									</c:if>
									<c:if test="${member.memberId ne null}">
										<td width="60"><a
											href="removalReplyPage.bo?review_No=${re.review_No }&reply_No=${re.reply_No}&memberId=${member.memberId}&memberPw=${member.memberPw}">
												<button type="button" class="removalBtn">삭제</button>
										</a></td>
									</c:if>

								</tr>
							</tbody>
						</c:forEach>
					</table>

				</c:when>

				<c:otherwise>
					<h5>댓글이 존재하지 않습니다.</h5>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<script>
		$('.reBtn').each(function(i) {

			$('.reBtn').eq(i).click(function() {
				console.log(i + "번째");
				var $re =  $('.reBtn').parents('tr');
				var review_No = $re.find('input.review_No').eq(i).val()
				var reply_No = $re.find('input.reply_No').eq(i).val()
				var memberId = $re.find('input.memberId').eq(i).val();
				var memberPw = $re.find('input.memberPw').eq(i).val();
				console.log(reply_No);
				 if (memberId != null) {
					location.href = "resReplyWriteform.bo?review_No="+review_No+"&reply_No="+reply_No+"&memberId="+memberId+"&memberPw="+memberPw;
				} else {	
					location.href = "resReplyWriteform.bo?review_No="+review_No+"&reply_No="+reply_No;
				} 

			});

		});
	</script>
	<div class="reply-header">
		<h3>댓글 쓰기</h3>
		<form action="reply.bo" method="post" name="replyform">
			<c:if test="${member ne null }">
				<input type="hidden" class="memberId" name="memberId"
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
				<input type="text" name="reply_Subject" class="reply_Subject"
					style="width: 230px;">
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
				<button type="button" name="reply">댓글 작성</button>
			</div>
			<div
				style="text-align: center; width: 100%; padding-top: 5px; padding-bottom: 10px;">
				<button type="button" name="replyCancelBtn">작성 취소</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function goback() {

		var memberId = $('input[name=memberId');
		var memberPw = $('input[name=memberPw');

		if (memberId.val()) {
			location.href = "reviewList.bo?memberId=" + memberId.val()
					+ "&memberPw=" + memberPw.val();
		} else {
			location.href = "reviewList.bo";
		}
	}

	$('button[name=replyBtn]').click(function() {
		$('.sub-selectedListPage').css('display', 'none');
		$('.sub-selectedListPage').fadeOut();
		$('.reply-contents').css('display', 'none');
		$('.reply-contents').fadeOut();
		$('.reply-header').fadeIn();
		$('.reply-header').css('display', 'block');

	});

	$('button[name=replyCancelBtn]').click(function() {
		location.reload();
		$('.reply-header').fadeOut();
		$('.reply-header').css('display', 'none');
		$('.sub-selectedListPage').css('display', 'block');
		$('.sub-selectedListPage').fadeIn();

	});

	$('button[name=reply]').click(function() {
		var $reply = $(this).parents('form[name=replyform]');
		var reply_Writer = $reply.find('input.reply_Writer').val();
		var reply_Subject = $reply.find('input.reply_Subject').val();
		var reply_Contents = $reply.find('textarea.reply_Contents').val();
		var reply_Password = $reply.find('input.reply_Password').val();
		var memberId = $reply.find('input.memberId').val();
		var memberPw = $reply.find('input.memberPw').val();
		var review_No = $reply.find('input.review_No').val();

		document.replyform.submit();
	})
	$('button[name=reply]').click(function() {
		var $reply = $(this).parents('form[name=replyform]');
		var reply_Writer = $reply.find('input.reply_Writer').val();
		var reply_Subject = $reply.find('input.reply_Subject').val();
		var reply_Contents = $reply.find('textarea.reply_Contents').val();
		var reply_Password = $reply.find('input.reply_Password').val();
		var memberId = $reply.find('input.memberId').val();
		var memberPw = $reply.find('input.memberPw').val();
		var review_No = $reply.find('input.review_No').val();

		document.replyform.submit();
	})
</script>