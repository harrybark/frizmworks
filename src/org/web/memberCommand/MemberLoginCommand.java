package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberLoginCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("LOGIN COMMAND");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId);
		System.out.println(memberPw);
		MemberDAO member_Dao = MemberDAO.getInstance();
		MemberDTO member = new MemberDTO();
		member = member_Dao.memberLogin(memberId, memberPw);
		HttpSession session = request.getSession();

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String url = "";
		
		if (member != null) {

			request.setAttribute("member", member);
			request.setAttribute("loginNum", 1);
			session.setAttribute("sessionId", request.getAttribute("member"));
			session.setMaxInactiveInterval(60 * 10);
			url = "/index.jsp";
//			out.println("<script language='javascript'>");
//			out.println("alert('로그인 되었습니다.');");
//			out.println("</script>");
			
		} else {
			url = "/login.jsp";
			request.setAttribute("loginNum", 0);
//			out.println("<script language='javascript'>");
//			out.println("alert('로그인 정보가 일치하지 않습니다. 다시 시도하십시오.');");
//			out.println("</script>");
			
		}

	//	out.flush();
		request.setAttribute("url", url);
	}
}
