<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myAccount">
		<div class="subAccount">
			<div class="myInfo">
				<h3>회원 정보</h3>
				<ul>
					<c:set var="member" value="${member }" />
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 아이디 : ${member.memberId }님</li>
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 이름 : ${member.memberName }</li>
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 전화번호 : ${member.mobile2 }</li>
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 지번 주소 : ${member.roadAddr }</li>
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 도로명 주소 : ${member.jibunAddr }</li>
					<li><img src="img/closebox.png" height="10px" alt="xicon"> 이메일 주소 : ${member.memberEmail }</li>
					<li>
					<button type="button" onclick="modInfo()">정보 수정</button>
					<button type="button" onclick="deleteInfo()" style="margin-left:10px;">계정 삭제</button>
					</li>
				</ul>
			</div>
		</div>

		<div class="modiInfo" style="display: none;">
		<div class="modformInfo" >
				<h3>회원 수정</h3>
				<form name="modform">
					<ul>
						<li>
						<img src="img/closebox.png" height="10px" alt="xicon"> 아이디 : ${member.memberId }
						<input type="hidden" name="memberId" class="memberId" value="${member.memberId }"/></li>
						<li><input type="password" name="memberPw" class="memberPw" placeholder="비밀번호를 입력하십시오.	" /></li>
						<li><input type="text" name="memberName" class="memberName" placeholder="이름을 입력하십시오.	" value="${member.memberName }"/></li>
						<li><input type="email" name="memberEmail" value="${member.memberEmail }"></li>					
						<li>
						<c:set var="mobile2" value="${member.mobile2 }"/>
						<input type="text" name="mobile2" value="${fn:substring(mobile2, 0, 3) }" maxlength="3" style="text-indent:0px; width:22%;text-align:center;"/>
						-&nbsp;<input type="text" name="mobile2" value="${fn:substring(mobile2, 4, 8) }" maxlength="4" style="text-indent:0px ;width:30%;text-align:center;"/>
						-&nbsp;<input type="text" name="mobile2" value="${fn:substring(mobile2, 9, 13) }" maxlength="4" style="text-indent:0px;width:30%;text-align:center;"/>
						</li>
						<li><input type="text" name="roadAddr" value="${member.roadAddr }"></li>
						<li><input type="text" name="jibunAddr" value="${member.jibunAddr }"></li>
						<li>
						<img src="img/closebox.png" height="10px" alt="xicon"><label for="smsOk" style="margin-right:35px;">SMS 수신</label>
						<input type="radio" name="smsOk" id="smsOk1" value="${member.smsOk }" /><span>&nbsp;YES</span>
					    <input type="radio" name="smsOk" id="smsOk2" value="${member.smsOk }" /><span>&nbsp;NO</span>
						</li>
						<li>
						<img src="img/closebox.png" height="10px" alt="xicon"><label for="emailOk" style="margin-right:25px;">Email 수신</label>
						<input type="radio" name="emailOk" id="emailOk" value="${member.emailOk }" hidden/><span>&nbsp;YES</span>
					    <input type="radio" name="emailOk" id="emailOk" value="${member.emailOk }" hidden/><span>&nbsp;NO</span>
						</li>
					</ul>
				<button type="button" class="modiBtn" onclick="mod()">회원 수정</button>
				<button type="button" onclick="cancelMod()">취소</button>
					</form>
			</div>
		</div>
		
		<div class="removalInfo" style="display: none;">
			<div class="removalform">
				<h3>회원 탈퇴</h3>
				<form name="removalform">
					<ul>
						<li><img src="img/closebox.png" height="10px" alt="xicon"> 아이디 : ${member.memberId }
						<input type="hidden" name="memberId" class="memberId" value="${member.memberId }"/></li>
						<li><input type="password" name="memberPw" class="memberPw" placeholder="비밀번호를 입력하십시오.	" /></li>
					</ul>
				<button type="button" class="removeBtn" onclick="removal()">회원 탈퇴</button>
				<button type="button" onclick="cancel()">취소</button>
					</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function deleteInfo() {

			$('.subAccount').css('display', 'none');
			$('.removalInfo').fadeIn();
			$('.removalInfo').css('display', 'block');

		}
		function modInfo() {

			$('.subAccount').css('display', 'none');
			$('.modiInfo').fadeIn();
			$('.modiInfo').css('display', 'block');
			
			var $modform = $('form[name=modform]');
			var smsOk = $modform.find('input[name=smsOk]');
			var emailOk = $modform.find('input[name=emailOk]');
			$("input:radio[name='smsOk']:radio[value='yes']").prop('checked', true); 
			$("input:radio[name='smsOk']:radio[value='no']").prop('checked', true); 
			
			console.log(emailOk.val());
			$("input:radio[name='emailOk']:radio[value='yes']").prop('checked', true); 
			$("input:radio[name='emailOk']:radio[value='no']").prop('checked', true); 
		}

		$('button.modiBtn').click(function(){
			
			var $mod = $(this).parents("form[name='modform']");
			var memberId = $mod.find("input[name=memberId]");
			var memberPw = $mod.find("input[name=memberPw]");
			var memberName = $mod.find("input[name=memberName]");
			var memberEmail = $mod.find("input[name=memberEmail]");
			var mobile = $mod.find("input[name=mobile2]");
			var mobile2 = mobile.eq(0).val() + "-" + mobile.eq(1).val() + "-" + mobile.eq(2).val();
			var roadAddr = $mod.find("input[name=roadAddr]");
			var jibunAddr = $mod.find("input[name=jibunAddr]");
			var smsOk = $mod.find("input[name=smsOk]");
			
			var selectedSms = $mod.find('input:radio[name=smsOk]:checked').val();
			
			if(selectedSms == smsOk.eq(0).val()){
				smsOk.val('yes');
			} else{
				smsOk.val('no');
			}
			var selectedEmail = $mod.find('input:radio[name=emailOk]:checked').val();
			var emailOk = $mod.find("input[name=emailOk]");
			if(selectedEmail == emailOk.eq(0).val()){
				emailOk.val('yes');
			} else{
				emailOk.val('no');
			}
			var data =  "memberId=" + memberId.val() + "&memberPw="
			+ memberPw.val() + "&memberName=" + memberName.val() + "&memberEmail=" + memberEmail.val()
			+ "&mobile2=" + mobile2 + "&roadAddr=" + roadAddr.val() + "&jibunAddr=" + jibunAddr.val() 
			+ "&smsOk=" + smsOk.val() + "&emailOk=" + emailOk.val();
			
			if(memberPw.val() == null || $.trim(memberPw.val())== ''){
				alert('비밀번호를 입력하십시오.');
				memberPw.focus();
				return false;
			}
			
			
			$.ajax({
				url : "modAccount.mo",
				data : data,
				type : "post",
				dataType : 'text',
				success : function(data){
					console.log(data);
					alert('개인 정보 수정을 성공했습니다.');
					location.href="myInfo.mo?memberId="+memberId.val()+"&memberPw="+memberPw.val();
				}, error : function(data){
					console.log(data);
					alert('개인정보 수정을 실패했습니다.');
				}
			})
		});

		$('button.removeBtn').click(
				function() {
					var $remove = $(this).parents("form[name='removalform']");
					var memberId = $remove.find('input[name=memberId]');
					var memberPw = $remove.find('input[name=memberPw]');

					var data = "memberId=" + memberId.val() + "&memberPw="
							+ memberPw.val();

					$.ajax({
						url : "removalAccount.mo",
						data : data,
						type : "post",
						dataType : "text",
						success : function(data) {
							alert('회원 탈퇴가 되었습니다. 메인 페이지로 이동합니다.');
							location.href = "index.jsp";
						},
						error : function(data) {
							alert('회원 탈퇴를 올바르게 실행하지 못했습니다.	');
						}
					});
				});

		function cancel() {
			$('.removalInfo').css('display', 'none');
			$('.subAccount').fadeIn();
			$('.subAccount').css('display', 'block');
		}
		function cancelMod() {
			location.reload();
			$('.modiInfo').css('display', 'none');
			$('.subAccount').fadeIn();
			$('.subAccount').css('display', 'block');
		}
	</script>

</body>
</html>