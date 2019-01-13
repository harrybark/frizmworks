<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% response.setContentType("text/html; charset=utf8"); %>
<div class="login">
	<h1 class="login-title">회원 로그인</h1>
<form action="loginAction.mo" method="post" name="loginform">
		<ul>
			<li>
			<input type="text" name="memberId" id="memberId" placeholder="아이디 입력" />
			</li>
			<li>
			<input type="password" name="memberPw" id="memberPw" placeholder="비밀번호 입력" />
			</li>
			<li>
				<!-- <button class ="loginBtn" type="button" onclick="loginBtn()">로그인</button> -->
				<button type="button" class="loginBtn" onClick="loginBtn()">로그인</button>
			</li>
		</ul>
</form>
	<div class="sub_login">
	<ul>
	<li>
	<a href="findId.jsp">> 아이디 찾기</a>
	<a class="sub1" href="findPw.jsp">> 비밀번호 찾기</a>
	</li>
	
	
	<li>** 회원가입을 하시면 다양하고 특별한 혜택이 준비되어 있습니다.
	</li>
	
	</ul>
	</div>
	<a class="ext" href="join.jsp"><button type="button" >회원 가입</button></a>
</div>
