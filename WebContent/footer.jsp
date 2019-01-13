<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="footer-tr">
		<div class="sub-footer">
			<div class="left_footer">
				<ul>
					<li>
					<c:choose>
					<c:when test="${sessionScope.sessionId == null }">
					<a href="main.mo">HOME</a>
					</c:when>
					<c:otherwise>
					<a href="main.mo?memberId=${member.memberId}&memberPw=${member.memberPw}">HOME</a>
					</c:otherwise>
					</c:choose>
					</li>
					<li><a href="#">AGREEMENT</a></li>
					<li><a href="#">PRIVACY</a></li>
					<li><a href="#">GUIDE</a></li>
					<li class="follow">
							<span>FOLLOW</span> 
							<span><a href="#"><img src="<%=request.getContextPath()%>/img/facebook.png" width="13px" alt="facebook"/></a></span>
							<span><a href="#"><img src="<%=request.getContextPath()%>/img/instagram.png" width="13px" alt="instagram"/></a></span>
							<span><a href="#"><img src="<%=request.getContextPath()%>/img/blog.png" width="13px" alt="blog"/></a></span></li>
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
