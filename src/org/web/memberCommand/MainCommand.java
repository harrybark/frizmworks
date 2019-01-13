package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MainCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("MAIN COMMAND");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId);
		System.out.println(memberPw);
		MemberDAO member_Dao = MemberDAO.getInstance();
		MemberDTO member = new MemberDTO();
		member = member_Dao.memberLogin(memberId, memberPw);
		HttpSession session = request.getSession();

		String url = "";
		if (member != null) {
			request.setAttribute("member", member);
			session.setAttribute("sessionId", session.getAttribute("sessionId"));
			session.setMaxInactiveInterval(60 * 10);

			url = "/index.jsp";
		} else {
			url = "/index.jsp";
		}

		request.setAttribute("url", url);

	}
}
