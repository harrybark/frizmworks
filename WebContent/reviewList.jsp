<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/reviewListPage.css" media="all" />
<link rel="stylesheet" href="css/fixedMember.css" media="all" />
</head>
<body>
	<c:if test="${modResult ne null}">
		<c:choose>
			<c:when test="${modResult eq 1 }">
				<script>
					alert('게시글 수정을 성공했습니다.');
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert('게시글 수정을 실패했습니다.');
				</script>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<c:if test="${! empty removalResult}">
		<c:choose>
			<c:when test="${removalResult eq 1 }">
				<script>
					alert('덧글 삭제를 성공했습니다.');
				</script>
			</c:when>
			<c:when test="${removalResult eq 0 }">
			<script>
			alert('암호가 틀렸습니다.');
			</script>
			</c:when>
			<c:otherwise>
				<script>
					alert('덧글 삭제 실패했습니다.');
				</script>
			</c:otherwise>
		</c:choose>
	</c:if>
		
	<div id="main">
		<div id="left-main">
			<div class="main-logo">
			
			<c:choose>
			<c:when test="${member eq null }">
				<a href="main.mo"><img src="img/logo_png_black.png" alt="mainlogo" /></a>
			</c:when>
			<c:otherwise>
			<a href="main.mo?memberId=${member.memberId }&memberPw=${member.memberPw}">
					<img src="img/logo_png_black.png" alt="mainlogo"/></a>
			</c:otherwise>
			</c:choose>
			
			</div>

			<div class="left-categories">

				<div>
					<a href="#">about</a>
				</div>
				<div id="shop">
					<div class="shop">
						<p style="font-size: 12px;">shop</p>
					</div>
					<div class="shop_Contents">
						<ul>
							<li><c:choose>
									<c:when test="${sessionScope.sessionId == null }">
										<a href="productList.pd">all (new arrival)</a>
									</c:when>
									<c:otherwise>
										<a href="productList.pd?memberId=${member.memberId }">all
											(new arrival)</a>
									</c:otherwise>
								</c:choose></li>
							<li><a href="#">outer</a></li>
							<li><a href="#">top (long)</a></li>
							<li><a href="#">top (short)</a></li>
							<li><a href="#">bottom</a></li>
							<li><a href="#">acc</a></li>
							<li><a href="#">sale</a></li>
						</ul>
					</div>
				</div>
				<div>
					<a href="#">lookbook</a>
				</div>
				<div>
					<a href="#">dealershop</a>
				</div>
				<div>
					<a href="#">notice</a>
				</div>
			</div>
		</div>


		<div id="right-main">

			<div class="right_contents">
				<ul>
					<li><c:choose>
							<c:when test="${sessionScope.sessionId == null }">
								<a href="login.jsp">LOGIN</a>
								<li><a href="join.jsp">JOIN</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="logout.mo">LOGOUT</a></li>
							</c:otherwise>
						</c:choose></li>

					<li><a href="cartList.ca?memberId=${member.memberId }&memberPw=${member.memberPw}">CART</a></li>
					<li><a href="myInfo.mo?memberId=${member.memberId }&memberPw=${member.memberPw}">MY PAGE</a></li>
						<c:choose>
						<c:when test="${sessionScope.sessionId == null }">
							<li><a href="reviewList.bo">REVIEW</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="reviewList.bo?memberId=${member.memberId }&memberPw=${member.memberPw}">REVIEW</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="#">Q&A</a></li>
				</ul>

			</div>

			<div class="contents">
				<jsp:include page="reviewListPage.jsp"></jsp:include>
			</div>

			<script type="text/javascript">
				$(document).ready(
						function() {
							jQuery(".shop_Contents").hide();

							$('.shop').click(
									function() {
										$('.shop_Contents').not(
												$(this).next('.shop_Contents')
														.slideToggle(500))
												.slideUp();
									});

						});
			</script>

		</div>
		<div id="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>