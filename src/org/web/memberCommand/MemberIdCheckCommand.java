package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberIdCheckCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("ID DUPLICATION CHECK");

		String memberId = request.getParameter("userId");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO member = mdao.memberId(memberId);

		PrintWriter out = response.getWriter();

		if (member != null) {
			out.write(member + "");
		} else {
			out.write(member + "");
		}
		out.close();
	}
}
