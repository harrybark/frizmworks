/**
 * 
 */

// 우편 번호
// 본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample4_postcode').value = data.zonecode; // 5자리
					// 새우편번호
					// 사용
					document.getElementById('sample4_roadAddress').value = fullRoadAddr;
					document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

					// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						// 예상되는 도로명 주소에 조합형 주소를 추가한다.
						var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
						document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
								+ expRoadAddr + ')';

					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
								+ expJibunAddr + ')';

					} else {
						document.getElementById('guide').innerHTML = '';
					}
				}
			}).open();

}
function postcodeCheck() {
	// postcode validation check
	// 숫자만 가능한 정규식
	var regexp = /^[0-9]*$/
	// 한글만 가능한 정규식
	var regex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

	var postcode = document.getElementById('sample4_postcode');
	var road = document.getElementById('sample4_roadAddress');
	var jibun = document.getElementById('sample4_jibunAddress');

	if (!regexp.test(postcode.value)) {
		alert('우편번호는 숫자만 입력해야 합니다.');
		return false;
	}
	if (regexp.test(road.value)) {
		alert('도로명 주소 입력 오류 입니다.	');
		return false;
	}
	if (regexp.test(jibun.value)) {
		alert('지번 주소 입력 오류 입니다.	');
		return false;
	}

	if (regexp.test(postcode.value)) {
		if (postcode.value.length > 4 && postcode.value.length < 7
				&& postcode.value != null && postcode.value != '') {
			return true;
		} else {
			alert('우편번호가 검색 후 올바른 값이 입력되지 않았습니다.	');
			return false;
		}
	}
	if (road.value != null && road.value != '' && !regexp.test(road.value)
			&& !regex.test(road.value)) {
		return true;
	} else {
		alert('도로명 주소가 검색 후 올바른 값이 입력되지 않았습니다.	');
		return false;
	}
	if (jibun.value != null && road.value != '' && !regexp.test(jibun.value)
			&& !regex.test(jibun.value)) {
		return true;
	} else {
		alert('지번 주소가 검색 후 올바른 값이 입력되지 않았습니다.	');
		return false;
	}
}

// 아이디 중복 검사 창을 새롭게 열기 위한 함수입니다.
function openIdChk() {

	window.name = "parentForm";
	window.open("IdCheckForm.jsp", "chkForm",
			"width=500, height=300, resizable = no, scrollbars = no");
}

// 이메일 주소 입력 또는 선택 값 전환 함수입니다.
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

// 비밀번호 확인 함수입니다.
function passwordCheck() {
	var memberPw = $('#memberPw');
	var memberPw2 = $('#memberPw2');

	// 비밀번호 8자 이상 16자리 미만. 대소문자 특수문자.
	var regex = /^.*(?=.{8,16})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

	if (memberPw.val() != memberPw2.val()) {
		document.getElementById("pwcheck").innerHTML = "비밀번호 불일치";
		document.getElementById("pwcheck").style = "color:red; font-size:12px;";
		return false;
	} else {
		if (!regex.test(memberPw.val())) {
			document.getElementById("pwcheck").innerHTML = "비밀번호 일치 및 사용 불가능";
			document.getElementById("pwcheck").style = "color:blue; font-size:12px;";
			return true;
		} else {
			document.getElementById("pwcheck").innerHTML = "비밀번호 일치 및 사용 가능";
			document.getElementById("pwcheck").style = "color:blue; font-size:12px;";
			return true;
		}

	}
}

// 회원가입 submit 하기 전 유효성 확인함수입니다.
function joinBtn() {
	var memberId = $('#memberId');
	var memberPw = $('#memberPw');
	var memberPw2 = $('#memberPw2');
	var completedidcheck = $('#completedidcheck');
	var memberName = $('#memberName');
	var sample4_postcode = $('#sample4_postcode');
	var mobile2 = $("input[name='mobile2']");
	var mobile1 = $("#mobile1");
	var memberEmail = $('#memberEmail');
	var emailBox = $('#emailBox');
	var selectMail = $('#selectMail');
	var smsOk = $('#smsOk');
	var emailOk = $('#emailOk');
	// 비밀번호 8자 이상 16자리 미만. 대소문자 특수문자.
	var regex = /^.*(?=.{8,16})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var regExp1 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*/i;
	var regExp2 = /^[0-9a-zA-Z][0-9a-zA-Z\_\-]*[0-9a-zA-Z](\.[a-zA-Z]{2,6}){1,2}$/i;
	var regexKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	// 숫자만
	var regexNum = /^[0-9]*$/;

	if (memberId.val() == null || memberId.val() == "") {
		alert('아이디를 입력하십시오.');
		memberId.focus();
		return false;
	}
	if (completedidcheck.val() != "check") {

		document.getElementById('idcheckBtn').style.WebkitAnimation = "shake-horizontal 0.8s cubic-bezier(0.455, 0.030, 0.515, 0.955) both";
		return false;
	}
	if (memberPw.val() == null || memberPw.val() == "") {
		alert('비밀번호를 입력하십시오.');
		memberPw.focus();
		return false;
	}
	if (passwordCheck() != true) {
		alert("비밀번호 확인하세요.");
		memberPw2.val('');
		memberPw2.focus();
		return false;
	}
	if (passwordCheck() == true) {
		if (!regex.test(memberPw.val())) {
			alert('비밀번호의 조건이 부적합합니다.');
			memberPw.val('');
			memberPw.focus();
			return false;
		}
	}
	if (memberName.val() == null || memberName.val() == "") {
		alert("이름을 입력하십시오.");
		memberName.focus();
		return false;
	}
	if ($.trim(memberName.val()) != '' && !regexKorean.test(memberName.val())) {

		alert('한글 성명을 입력하십시오.');
		return false;

	}

	if (sample4_postcode.val() == null || sample4_postcode.val() == "") {
		alert("주소를 입력하십시오.");
		sample4_postcode.focus();
		return false;
	}
	if (postcodeCheck() != true) {
		alert('주소를 검색하십시오.');
		return false;
	}
	if (regexKorean.test(mobile1.val())) {
		return false;
	}

	if (mobile2.val() == null || $.trim(memberName.val()) == '') {
		alert("전화번호를 입력하십시오.");
		mobile2.eq(0).focus();
		return false;
	}
	if (regexKorean.test(mobile2.val())) {
		alert('한글은 사용 할 수 없습니다.');
		return false;
	}
	if (!regexNum.test(mobile2.val())) {
		alert('숫자를 입력하지 않았습니다.');
		return false;
	}
	if (mobile2.eq(0).val().length < 3) {
		console.log(mobile2.eq(0).val().length);
		alert('첫번째 전화번호는 3자리, 4자리만 입력 가능합니다.');
		return false;
	}
	if (mobile2.eq(1).val().length < 3) {
		console.log(mobile2.eq(1).val().length);
		alert('두번째 전화번호는 3자리, 4자리만 입력 가능합니다.');
		return false;
	}

	if (memberEmail.val() == null || memberEmail.val() == "") {
		alert('이메일을 입력하십시오.');
		memberEmail.focus();
		return false;
	}
	if ($('#selectMail option:selected').val() == 'none') {
		alert('이메일 주소를 선택하세요.');
		return false;
	}
	if ($('#selectMail option:selected').val() == ""
			&& ($('#emailBox').val() == null || $('#emailBox').val() == "")) {
		alert("이메일 주소를 입력하세요.");
		$('#emailBox').focus();
		return false;
	}
	if (!regExp1.test(memberEmail.val())) {
		alert('이메일이 부적합합니다.');
		valid = false;
	}
	if (!regExp2.test(emailBox.val())) {
		alert('도메인이 부적합합니다.');
		valid = false;
	}
	if (!regExp1.test(memberEmail.val()) && !regExp2.test(emailBox.val())) {
		alert('사용이 불가능합니다.');
		valid = false;
	}
	if (regExp1.test(memberEmail.val()) && !regExp2.test(emailBox.val())) {
		alert('사용이 불가능합니다.');
		valid = false;
	}
	if (!regExp1.test(memberEmail.val()) && regExp2.test(emailBox.val())) {
		alert('사용이 불가능합니다.');
		valid = false;
	}

	if ($("input:radio[id='smsOk']").is(":checked") == false) {
		alert('SMS 수신 여부 체크 해주십시오.');
		return false;
	}
	if ($("input:radio[id='emailOk']").is(":checked") == false) {
		alert('이메일 수신 여부 체크 해주십시오.');
		return false;
	}

	alert('회원 가입을 진행합니다.');
	document.signform.submit();
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
