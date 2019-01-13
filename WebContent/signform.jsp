<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="signform">

	<div class="sign">
		<h1 class="signform-title">JOIN</h1>
		<form action="sign.mo" method="post" name="signform" id="signform" onsubmit="return joinBtn()">
			<div class="sign-left">
				<ul>
					<li class="s1">
					<label for="memberId">아이디</label> 
					<input type="text" name="memberId" id="memberId" />
					<button type="button" name="idcheckBtn" id="idcheckBtn"	onclick="openIdChk()">아이디 체크</button> 
					<input type="hidden" value="uncheck" id="completedidcheck" name="completedidcheck" /></li>
					<li><label for="memberPw">비밀번호</label> 
					<input type="password" name="memberPw" id="memberPw" /> 
					<span>영문 대소문자, 특수문자를 포함한 8~16자</span></li>
					<li><label for="memberPw">비밀번호 확인</label> 
					<input type="password" name="memberPw2" id="memberPw2" onKeyUp="passwordCheck()" /> <span id="pwcheck"></span></li>
					<li><label for="memberName">이름</label> 
					<input type="text" name="memberName" id="memberName" /></li>
					<li><label for="postcode">주소</label> 
					<input type="text" id="sample4_postcode" name="postcode" placeholder="우편번호">
					<button type="button" onclick="sample4_execDaumPostcode()">우편번호 찾기</button></li>
					<li>
					<input type="text" placeholder="도로명주소" name="road" id="sample4_roadAddress"> 
					<input type="text" placeholder="지번주소" name="jibun" id="sample4_jibunAddress">
					</li>
					<li><span id="guide" style="height: 40px; color: #999;"></span></li>
				</ul>
			</div>

			<div class="sign-right">
				<ul>
					<li><label for="mobile1">일반전화</label> <select name="mobile1">
							<option value="" selected>::전화번호::</option>
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="033">033</option>
							<option value="041">041</option>
							<option value="042">042</option>
							<option value="043">043</option>
							<option value="044">044</option>
							<option value="051">051</option>
							<option value="052">052</option>
							<option value="053">053</option>
							<option value="054">054</option>
							<option value="055">055</option>
							<option value="061">061</option>
							<option value="062">062</option>
							<option value="063">063</option>
							<option value="064">064</option>
					</select> -&nbsp;
					<input type="text" name="mobile1" id="mobile1" maxlength="4" size="10" /> -&nbsp;
					<input type="text" name="mobile1" id="mobile1" maxlength="4" size="10" /></li>
					<li><label for="mobile2">휴대전화</label> 
					<select name="mobile2" id="mobile2">
							<option value="" selected>::전화번호::</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select> -&nbsp;
					<input type="text" name="mobile2" id="mobile2" maxlength="4" size="10" /> -&nbsp;
					<input type="text" name="mobile2" id="mobile2" maxlength="4" size="10" /></li>
					<li><label for="memberEmail">이메일</label> 
					<input type="text" name="memberEmail" id="memberEmail" maxlength="20" />@ 
					<input type="text" id="emailBox" name="emailBox" disabled /> 
					<select name="memberEmail" id="selectMail">
							<option value="none">--이메일 선택--</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="yahoo.com">yahoo.com</option>
							<option value="empas.com">empas.com</option>
							<option value="korea.com">korea.com</option>
							<option value="dreamwiz.com">dreamwiz.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="">직접 입력</option>
					</select></li>
					<li><label for="smsOk">SMS 수신여부</label> 
					<input type="radio" name="smsOk" id="smsOk" value="yes" />&nbsp;YES 
					<input type="radio" name="smsOk" id="smsOk" value="no" />&nbsp;NO</li>

					<li><label for="emailOk">이메일 수신여부</label> 
					<input 	type="radio" name="emailOk" id="emailOk" value="yes" />&nbsp;YES
					<input type="radio" name="emailOk" id="emailOk" value="no" />&nbsp;NO
						<p>
							<span>**쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.</span>
						</p></li>
				</ul>
			</div>
			<div class="submitBtn">
				<button>회원가입</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
