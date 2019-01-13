package org.web.memberdto;

public class MemberDTO {
// DB 칼럼들을 생성하기 위한 클래스입니다.

	private String memberId;
	private String memberPw;
	private String memberName;
	// 지번, 주소, 상세주소를 배열로 합치도록 한다.
	private String roadAddr;
	// 일반 전화 (array)
	private String jibunAddr;
	// 일반 전화 (array)
	private String mobile1;
	// 이동 전화 (array)
	private String mobile2;
	private String smsOk;
	// array
	private String memberEmail;

	private String emailOk;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String memberId, String memberPw, String memberName, String roadAddr, String jibunAddr,
			String mobile1, String mobile2, String smsOk, String memberEmail, String emailOk) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.roadAddr = roadAddr;
		this.jibunAddr = jibunAddr;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.smsOk = smsOk;
		this.memberEmail = memberEmail;
		this.emailOk = emailOk;
	}

	public MemberDTO(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRoadAddr() {
		return roadAddr;
	}

	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}

	public String getJibunAddr() {
		return jibunAddr;
	}

	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getSmsOk() {
		return smsOk;
	}

	public void setSmsOk(String smsOk) {
		this.smsOk = smsOk;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getEmailOk() {
		return emailOk;
	}

	public void setEmailOk(String emailOk) {
		this.emailOk = emailOk;
	}

}
