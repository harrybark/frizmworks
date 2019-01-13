/**
 * 
 */

function loginBtn() {

	var memberId = $('#memberId');
	var memberPw = $('#memberPw');
	
	if(memberId.val() == null || memberId.val() == ""){
		alert('아이디가 입력되지 않았습니다.');
		memberId.focus();
		return false;
	}
	if(memberPw.val() == null || memberPw.val() == ""){
		alert('비밀번호가 입력되지 않았습니다.');
		memberPw.focus();
		return false;
	}
	
	alert('로그인을 진행합니다.');
	document.loginform.submit();
	afterLoginProgress();
}

function afterLoginProgress(){
	
}

$(document).ready(
		function() {
			jQuery(".shop_Contents").hide();

			$('.shop').click(
					function() {
						$('.shop_Contents')
								.not(
										$(this).next('.shop_Contents')
												.slideToggle(500)).slideUp();
					});

		});