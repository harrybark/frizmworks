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
<c:if test="${sessionScope.sessionId ne null }">
	<c:if test="${loginNum ne null }">
		<script>
			alert('로그인 되었습니다.');
		</script>
	</c:if>
</c:if>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FrizmWORKS PORTFOLIO</title>
<meta name="author" content="Alvaro Trigo Lopez" />
<meta name="description"
	content="fullPage full-screen navigation and sections control menu." />
<meta name="keywords"
	content="fullpage,jquery,demo,screen,fullscreen,navigation,control arrows, dots" />
<meta name="Resource-type" content="Document" />

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/fullpage.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/index.css" />
<style>

/* Bottom menu
	* --------------------------------------- */
#infoMenu li a {
	color: #fff;
}

/* Backgrounds will cover all the section
	* --------------------------------------- */
#section0, #section1, #section2, #section3, #slide1, #slide2 {
	background-size: cover;
	background-attachment: fixed;
}

/* Defining each sectino background and styles
	* --------------------------------------- */
#section0 {
	background-image: url(img/main01.jpg);
	font-weight: 300;
}

#section0 h1 {
	top: 50%;
	transform: translateY(-50%);
	position: relative;
}

#section1 {
	background: url(img/main02.jpg);
	background-size: cover;
	font-weight: 300;
}

#section2 {
	background: url(img/main03.jpg);
	background-size: cover;
	font-weight: 300;
}

#section3 h1 {
	color: #000;
}
</style>

<!--[if IE]>
		<script type="text/javascript">
			 var console = { log: function() {} };
		</script>
	<![endif]-->
</head>
<body>

	<div id="main">
		<%-- header start ::index logo --%>
		<div id="header">
			<div class="logo">
					<c:choose>
			<c:when test="${member eq null }">
				<a href="main.mo"><img src="img/logo_png_white.png" alt="mainlogo" /></a>
			</c:when>
			<c:otherwise>
			<a href="main.mo?memberId=${member.memberId }&memberPw=${member.memberPw}">
					<img src="img/logo_png_white.png" alt="mainlogo"/></a>
			</c:otherwise>
			</c:choose>
			</div>
		</div>

		<%-- header end--%>


		<%-- category part :: left && right --%>
		<div id="categories">
			<div class="category_left">
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
				<script>
					$(document).ready(
							function() {
								jQuery(".shop_Contents").hide();

								$('.shop').click(
										function() {
											$('.shop_Contents').not(
													$(this).next(
															'.shop_Contents')
															.slideToggle(500))
													.slideUp();
										});

							});
				</script>

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

			<div class="right_contents">
				<ul>

					<c:choose>
						<c:when test="${sessionScope.sessionId == null }">
							<li><a href="login.jsp">LOGIN</a></li>
							<li><a href="join.jsp">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="logout.mo">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>

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
		</div>


		<div id="fullpage">
			<div class="section " id="section0">
				<div class="intro"></div>
			</div>

			<div class="section" id="section1">
				<div class="intro">
					<h3>FrizmWORKS X Hummel®</h3>
					<h1>SYNERGY</h1>
					<a href="#">VIEW MORE</a>
				</div>

			</div>
			<div class="section" id="section2">
				<div class="intro"></div>
			</div>
			<div class="section fp-auto-height" id="section-footer">
				<div class="intro">
					<div class="subintro">
						<div class="left_footer">
							<ul>
								<li><a href="">HOME</a></li>
								<li><a href="">AGREEMENT</a></li>
								<li><a href="">PRIVACY</a></li>
								<li><a href="">GUIDE</a></li>
								<li class="follow"><span>FOLLOW</span> 
								<span><a href="#"><img src="<%=request.getContextPath()%>/img/facebook.png" width="13px"/></a></span>
								<span><a href="#"><img src="<%=request.getContextPath()%>/img/instagram.png" width="13px" /></a></span>
								<span><a href="#"><img src="<%=request.getContextPath()%>/img/blog.png" width="13px"/></a>  </span>
								</li>
								<li>Copyright 2010-2017. FrizmWORKS ALL right reserved.</li>
							</ul>

						</div>

						<div class="center_footer">
							<ul>
								<li><span>CS CENTER</span></li>
								<li>070 4063 4692</li>
								<li>MON-FRI 11:00 - 18:00</li>
								<li>LUNCH TIME 12:00 - 13:00</li>
								<li>WEEKEND/HOLIDAY OFF</li>
								<li>BANK INFO <span>신한은행 110 345 578132 안종혁(프리즘웍스)</span></li>
							</ul>
						</div>

						<div class="right_footer">
							<ul>
								<li><span>COMPANY INFO</span></li>
								<li>company<span>프리즘웍스&nbsp;|&nbsp;</span> OWNER <span>황호준
										안종혁</span></li>
								<li>BUSINESS LICENSE <span>123 34 48675</span></li>
								<li>ADDRESS <span>경기도 안양시 동안구 동편로 188 네이쳐빌딩 101,102호</span></li>
								<li>MAIL ORDER LICENSE <span>2010-경기안양-170</span></li>
								<li>CPO <span>안종혁&nbsp;|&nbsp;</span> E-MAIL<span>&nbsp;frizmworks@naver.com</span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/fullpage.min.js"></script>

	<script type="text/javascript">
		var myFullpage = new fullpage('#fullpage', {
			anchors : [ 'firstPage', 'secondPage', '3rdPage', 'footer' ],
			/* 	sectionsColor : [ '#C63D0F', '#1BBC9B', '#7E8F7C' ], */
			navigation : true,
			navigationPosition : 'right',
			navigationTooltips : [ 'First page', 'Second page', 'Third page' ]

		});
	</script>
</body>
</html>