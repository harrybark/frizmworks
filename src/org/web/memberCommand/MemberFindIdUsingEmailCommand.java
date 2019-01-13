package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberFindIdUsingEmailCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("FIND ID INFO USING EMAIL");

		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String directEmail = request.getParameter("emailBox");

		System.out.println(directEmail + "<< directEmail");

		memberEmail = memberEmail + "@" + directEmail;

		System.out.println(memberName);
		System.out.println(memberEmail + "<< memberEmail");

		MemberDAO mDao = MemberDAO.getInstance();
		String memberId  = (String)mDao.findIdUsingEmail(memberName, memberEmail);
		
		PrintWriter out = response.getWriter();
		System.out.println(memberId + "<< command memberId");
		if (memberId != null) {
			out.print(memberId);
		} else {
			out.print("");
		}
		out.close();
	}
}
