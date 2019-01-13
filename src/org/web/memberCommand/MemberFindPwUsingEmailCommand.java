package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberFindPwUsingEmailCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("FIND PW INFO USING EMAIL");

		String memberId = request.getParameter("memberId");
		String memberEmail = request.getParameter("memberEmail");
		String directEmail = request.getParameter("emailBox");

		System.out.println(directEmail + "<< directEmail");

		memberEmail = memberEmail + "@" + directEmail;

		System.out.println(memberId);
		System.out.println(memberEmail + "<< memberEmail");

		MemberDAO mDao = MemberDAO.getInstance();
		String memberPw = (String) mDao.findPwUsingEmail(memberId, memberEmail);

		PrintWriter out = response.getWriter();
		System.out.println(memberPw + "<< command memberPw");
		if (memberPw != null) {
			out.print(memberPw);
		}else {
			out.print("");
		}
		out.close();
	}
}
