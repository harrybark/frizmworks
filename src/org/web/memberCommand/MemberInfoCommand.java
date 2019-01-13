package org.web.memberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberInfoCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Member Account-Info Command");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.memberLogin(memberId, memberPw);
		HttpSession session = request.getSession();

		request.setAttribute("member", member);
		session.setAttribute("sessionId", session.getAttribute("sessionId"));
		session.setMaxInactiveInterval(60 * 10);
		request.setAttribute("url", "/myAccount.jsp");

	}
}
