<%@page import="org.web.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="btn">
	<button class="btn1" onclick="emailFind()">이메일 주소로 찾기</button>
	<button class="btn2" onclick="mobileFind()">전화번호로 찾기</button>
</div>

<div class="findId_s1">
	<h1 class="find-title">아이디 찾기</h1>
	<span class="close1"><img src="img/closebox.png" alt="xImg" width="20px;"></span>
	<ul>
		<li><input type="text" name="memberName" class="memberName"
			id="memberName" placeholder="이름을 입력하십시오."></li>
		<li><input type="text" name="memberEmail" class="memberEmail"
			id="memberEmail" maxlength="20" placeholder="이메일을 입력하십시오." />&nbsp;@
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
		<li>
			<button class="findIdBtn1">아이디 찾기</button>
		</li>
	</ul>
</div>
<script>
	$(document).ready(function() {
		// 이메일 주소
		$('#selectMail').change(function() {
			$('#selectMail option:selected').each(function() {
				if ($(this).val() == "") {
					$('#emailBox').val('');
					$('#emailBox').attr('disabled', false);
				} else {
					$("#emailBox").val($(this).text()); // 선택값 입력
					$("#emailBox").attr("disabled", true);
				}
			});
		});
	});
</script>

<script type="text/javascript">
	
	
	$('.findIdBtn1').click(
			function() {
				var memberName = $('#memberName').val();
				var memberEmail = $('#memberEmail').val();
				var emailBox = $('#emailBox').val();
				console.log(memberName);
				console.log(memberEmail);
				console.log(emailBox);
				var dataString = "memberName=" + memberName + "&memberEmail="
						+ memberEmail + "&emailBox=" + emailBox;
				var regex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
				var regExp1 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*/i;
				var regExp2 = /^[0-9a-zA-Z][0-9a-zA-Z\_\-]*[0-9a-zA-Z](\.[a-zA-Z]{2,6}){1,2}$/i;
				
				if (!regex.test(memberName)) {
					alert('이름은 한글만 입력 가능합니다.');
					$('#memberName').focus();
					return false;
				} 
				if (!regExp1.test(memberEmail)) {
					alert('이메일이 부적합합니다.');
					return false;
				}
				if (!regExp2.test(emailBox)) {
					alert('도메인이 부적합합니다.');
					return false;
				}
				else {
					$.ajax({
						url : "findIdUsingEmail.mo",
						data : dataString,
						type : "post",
						success : function(data) {
							  if (!$.trim(data) || !data || data == '' || $.trim(data) == '' || $.trim(data) == null || data == null) {
			                	   alert("일치하는 정보가 없습니다.");
								} else {
									alert("아이디는 " + data + "입니다.");
									alert("로그인 페이지로 이동합니다.");
									location.href = "login.jsp";
									
								}
						},
						error : function() {
							alert("일치하는 정보가 없습니다.");
						}
					});
				}
			});
</script>
<div class="findId_s2">
	<h1 class="find-title">아이디 찾기</h1>
	<span class="close2"><img src="img/closebox.png" alt="xImg" width="20px;"></span>
	<form action="" method="post" name="idBtn2">
		<ul>
			<li><input type="text" name="memberName" class="memberName2"
				placeholder="이름을 입력하십시오."></li>
			<li>
			<select name="mobile2" id="mobile2">
					<option value="" selected>::전화번호::</option>
					<option value="010" >010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					</select>
					-&nbsp;<input type = "text" name="mobile2" id="mobile2_1" maxlength="4" size="10"/>
					-&nbsp;<input type = "text" name="mobile2" id="mobile2_2"  maxlength="4" size="10"/>
			<li>
				<button class="findIdBtn2">아이디 찾기</button>
			</li>
		</ul>
	</form>
</div>

<script>
	
	$('.findIdBtn2').click(
			function() {
				var $btn2 = $(this).parents('form[name=idBtn2]');
				var memberName = $btn2.find('.memberName2').val();
				var mobile2 = $btn2.find('#mobile2').val();
				var mobile2_1 = $btn2.find('#mobile2_1').val();
				var mobile2_2 = $btn2.find('#mobile2_2').val();
				console.log(memberName);
				console.log(mobile2);
				var dataString = "memberName=" + memberName + "&mobile2="
						+ mobile2 + "&mobile2_1=" + mobile2_1 + "&mobile2_2="
						+ mobile2_2;
				var regex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
				var regexNum = /^[0-9]*$/;
				if (!regex.test(memberName)) {
					alert('이름은 한글만 입력하여야 합니다.');
					$('#memberName').focus();
					return false;
				}
				if(mobile2 == ""){
					alert('전화번호를 선택하십시오.');
					return false;
				}
				if (mobile2_1.length < 3) {
					alert('전화번호는 3자리 이상 4자리 미만입니다.');
					$btn2.find('#mobile2_1').focus();
					return false;
				}
				if (mobile2_2.length < 3) {
					alert('전화번호는 3자리 이상 4자리 미만입니다.');
					$btn2.find('#mobile2_2').focus();
					return false;
				}
				if (!regexNum.test(mobile2_1) || !regexNum.test(mobile2_2)) {
					alert('전화번호는 숫자만 입력 가능합니다.');
					$btn2.find('#mobile2_1').focus();
					return false;
				} else {
					$.ajax({
						url : "findIdUsingMobile.mo",
						data : dataString,
						type : "post",
						success : function(data) {
							if (!$.trim(data) || !data || data == ''
									|| $.trim(data) == ''
									|| $.trim(data) == null || data == null) {
								alert("일치하는 정보가 없습니다.");
							} else {
								alert("아이디는 " + data + "입니다.");
								alert("로그인 페이지로 이동합니다.");
								location.href = "login.jsp";

							}
						},
						error : function() {
							alert("올바르게 실행되지 않았습니다.");
						}
					});
				}
			});
</script>
<script>
	
	function emailFind() {

		if ($('.findId_s2').fadeOut() != true) {
			$('.findId_s2').fadeOut();
			$('.findId_s1').fadeIn(1000);
		} else {
			$('.findId_s1').fadeIn(1000);
		}
		$('.close1').click(function() {
			$('.findId_s1').fadeOut(500);
		});
	}

	function mobileFind() {

		if ($('.findId_s1').fadeOut() != true) {
			$('.findId_s1').fadeOut();
			$('.findId_s2').fadeIn(1000);
		} else {
			$('.findId_s2').fadeIn(1000);
		}
		$('.close2').click(function() {
			$('.findId_s2').fadeOut(500);
		});

	}
</script>
