package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberModificationCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Member Modification Command");
		response.setContentType("text/html; charset=utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String mobile2 = request.getParameter("mobile2");
		String roadAddr = request.getParameter("roadAddr");
		String jibunAddr = request.getParameter("jibunAddr");
		String smsOk = request.getParameter("smsOk");
		
		String emailOk = request.getParameter("emailOk");

		System.out.println(smsOk);
		System.out.println(emailOk);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = 0;
		result = mDao.accountMod(memberId, memberPw, memberName, memberEmail, mobile2, roadAddr, jibunAddr, smsOk, emailOk);
		PrintWriter out = response.getWriter();
		if (result == 1) {
			System.out.println("수정 성공");
			out.write(result + "");
		} else {
			out.write(result + "");
		}
		out.flush();
	}
}
