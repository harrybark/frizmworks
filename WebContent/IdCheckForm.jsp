<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/reset.css" media="all" />
</head>
<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: hidden;
}
</style>
<script>
	function DuplicationCheck() {
		var userId = $('#userId').val();
		var completedidcheck = $('#completedidcheck').val();
		var data = "userId=" + userId;

		var regType = /^[A-za-z0-9]{4,12}$/g;

		if (!userId) {
			$("#msg").html("아이디를 입력하십시오.");
			return false;
		} else {
			if (!regType.test(userId)) {
				$("#msg").html("아이디는 4~12자리의 대소문자와 숫자가 결합된 아이디만 가능합니다.	");
				$('#userId').val('');
				$('#userId').focus();
				return false;
			} else {

				$.ajax({
					url : "idcheck.mo",
					data : data,
					dataType : "json",
					type : "post",
					success : function() {
						$('#cancelBtn').attr('style','visibility:hidden');
						$('#useBtn').attr('style','visibility:visible');
						$("#msg").html("사용 가능한 아이디입니다.");
						opener.document.signform.completedidcheck.value = 'check';
					},
					error : function() {
						$('#cancelBtn').attr('style','visibility:visible');
						$('#useBtn').attr('style','visibility:hidden');
						$("#msg").html("중복 또는 사용할 수 없는 아이디입니다.");
						$('#userId').val('');
						$('#userId').focus();
						opener.document.signform.completedidcheck.value = 'uncheck';
					}
				});
			}
		}

	}
	function pValue() {
		document.getElementById("userId").value=opener.document.signform.memberId.value;
	}
		// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue() {
			// 중복체크 결과인 idCheck 값을 전달한다.
			opener.document.signform.completedidcheck.value = "check";
			// 회원가입 화면의 ID입력란에 값을 전달
			opener.document.signform.memberId.value = document.getElementById("userId").value;

			if (opener != null) {
				opener.checkForm = null;
				self.close();
			}
		}
	
</script>
<body onload="pValue()">
	<div id="wrap">
		<br><br><font size="4" color="gray">아이디 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="idinput" id="userId"> <input
					type="button" value="중복확인" onclick="DuplicationCheck()">
			</form>
			<div id="msg"></div>
			<br> 
			<input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br> 
			<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
	</div>
</body>
</html>


