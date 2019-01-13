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

<div class="reviewList">
	<!-- POST 방식으로 검색 기능 구현  -->
	<div class="s2">
		<%
			if (session.getAttribute("sessionId") != null) {
		%>
		<form action="searchReviewList.bo?memberId=${member.memberId }" method="post">
			<input type="text" name="review_Subject" size="24"> <input
				type="submit" value="Search" name="search">
		</form>
		<%
			} else {
		%>
		<form action="searchReviewList.bo" method="post">
			<input type="text" name="review_Subject" size="24"> 
			<input type="submit" value="Search" name="search">
		</form>
		<%
			}
		%>
	</div>
	<div class="s1">

		<c:forEach var="list" items="${reviewList}">
			<div class="review-s1">
				<%
					if (session.getAttribute("sessionId") != null) {
				%>
				<a href="selectedReviewList.bo?review_No=${list.review_No }&memberId=${member.memberId}&memberPw=${member.memberPw}">
					<ul>
						<li><span style="width:50%; text-align:left; font-size:11px;">조회수 : ${list.review_Hit }</span><span style="width:50%; text-align:right; font-size:11px;">( ${list.review_Indent } )</span></li>
						<li><img src="upload/${list.review_fileRealName }" src="realImg" /></li>
						<li>작성자 : ${ list.review_Writer}</li>
						<li>제목 : ${list.review_Subject }</li>
						<li>내용 : ${list.review_Contents }</li>
					</ul>
				</a>
				<%
					} else {
				%>
				<a href="selectedReviewList.bo?review_No=${list.review_No }">
					<ul>
						<li><span style="width:50%;  text-align:left; font-size:11px;">조회수 : ${list.review_Hit }</span><span style="width:50%; text-align:right; font-size:11px;">( ${list.review_Indent } )</span></li>
						<li><img src="upload/${list.review_fileRealName }" src="realImg" /></li>
						<li>작성자 : ${ list.review_Writer}</li>
						<li>제목 : ${list.review_Subject }</li>
						<li>내용 : ${list.review_Contents }</li>
					</ul>
				</a>
				<%
					}
				%>
			</div>
		</c:forEach>
	</div>

	<div class="sub-reviewList">
		<%
			if (session.getAttribute("sessionId") != null) {
		%>
		<p>
			<a href="review_Write.bo?memberId=<%=member.getMemberId()%>&memberPw=<%=member.getMemberPw()%>"><button>글쓰기</button></a>
		</p>
		<div class="list">
			<ul>
				<li><a
					href="reviewList.bo?page=${paging.firstPageNo}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">맨앞으로</a></li>
				<li><a
					href="reviewList.bo?page=${paging.prevPageNo}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">앞으로</a></li>

				<c:forEach var="i" begin="${paging.startPageNo}"
					end="${paging.endPageNo}" step="1">
					<c:choose>
						<c:when test="${i eq paging.pageNo}">
							<li class="active"><a
								href="reviewList.bo?page=${i}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a
								href="reviewList.bo?page=${i}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li><a
					href="reviewList.bo?page=${paging.nextPageNo}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">뒤로</a></li>
				<li><a
					href="reviewList.bo?page=${paging.finalPageNo}&memberId=${ member.memberId}&memberPw=${ member.memberPw}">맨뒤로</a></li>
			</ul>
		</div>

		<script>
			function PageMove(page, memberId, memberPw) {

				location.href = "reviewList.bo?page=" + page + "&memberId="
						+ memberId + "&memberPw=" + memberPw;
			}
		</script>


		<%
			} else {
		%>
		<div class="list" style="overflow: hidden;">
			<ul>
				<li><a href="javascript:PageMove(${paging.firstPageNo})">맨앞으로</a></li>
				<li><a href="javascript:PageMove(${paging.prevPageNo})">앞으로</a></li>

				<c:forEach var="i" begin="${paging.startPageNo}"
					end="${paging.endPageNo}" step="1">
					<c:choose>
						<c:when test="${i eq paging.pageNo}">
							<li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:PageMove(${i})">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li><a href="javascript:PageMove(${paging.nextPageNo})">뒤로</a></li>
				<li><a href="javascript:PageMove(${paging.finalPageNo})">맨뒤로</a></li>
			</ul>
		</div>


		<script>
			function PageMove(page) {
				location.href = "reviewList.bo?page=" + page;
			}
		</script>
		<%
			}
		%>

	</div>
</div>






