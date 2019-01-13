package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberSignInCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("SIGN IN COMMAND");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		// addr += postNum + post + postInfo ;
		String postcode = request.getParameter("postcode");
		String road = request.getParameter("road");
		String jibun = request.getParameter("jibun");

		String roadAddr = postcode + " " + road;
		String jibunAddr = postcode + " " + jibun;
		String[] arrMobile1 = request.getParameterValues("mobile1");
		String[] arrMobile2 = request.getParameterValues("mobile2");

		String smsOk = request.getParameter("smsOk");
		// id @ email domain.
		String[] arrmemberEmail = request.getParameterValues("memberEmail");
		String directEmail = request.getParameter("emailBox");
		System.out.println(directEmail);
		String emailOk = request.getParameter("emailOk");

		// 입력 된 값의 배열 처리 입니다.

		String mobile1 = "";
		for (String sMobile : arrMobile1) {
			mobile1 += sMobile + "-";
		}
		mobile1 = mobile1.substring(0, mobile1.length() - 1);

		String mobile2 = "";
		for (String sMobile2 : arrMobile2) {
			mobile2 += sMobile2 + "-";
		}
		mobile2 = mobile2.substring(0, mobile2.length() - 1);
		String memberEmail = "";

		if (directEmail != null) {
			for (String sEmail : arrmemberEmail) {
				memberEmail += sEmail + "@" + directEmail;
			}
			memberEmail = memberEmail.substring(0, memberEmail.length() - 1 - directEmail.length());
		} else {
			for (String sEmail : arrmemberEmail) {
				memberEmail += sEmail + "@";
			}
			memberEmail = memberEmail.substring(0, memberEmail.length() - 1);
		}
		MemberDTO member = null;
		member = new MemberDTO(memberId, memberPw, memberName, roadAddr, jibunAddr, mobile1, mobile2, smsOk,
				memberEmail, emailOk);
		MemberDAO dao = MemberDAO.getInstance();

		int result = dao.memberSignIn(member);
	
		if (result == 1 && member != null) {
			System.out.println("회원가입 성공");
			request.setAttribute("url", "/main.mo");
		} else {
			System.out.println("회원가입 실패");
			request.setAttribute("url", "/join.jsp");
		}

		
	}
}
