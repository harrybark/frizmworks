package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;

public class MemberRemovalCommand implements MemberQueryCommand{

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Member Account Removal Command");
		response.setContentType("text/html; charset=utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.accountRemoval(memberId, memberPw);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(result == 1) {
			session.invalidate();
			out.write(result+"");
		}else {
			out.write(result+"");
		}
		out.close();
	}
}
