package org.web.memberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberFindIdUsingMobileCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("FIND ID INFO USING MOBILE");

		String memberName = request.getParameter("memberName");

		String mobile2_0 = request.getParameter("mobile2");
		String mobile2_1 = request.getParameter("mobile2_1");
		String mobile2_2 = request.getParameter("mobile2_2");

		String mobile2 = "";
		mobile2 = mobile2_0.concat("-");
		mobile2 = mobile2.concat(mobile2_1);
		mobile2 = mobile2.concat("-");
		mobile2 = mobile2.concat(mobile2_2);

		System.out.println(memberName + " < memberName");
		System.out.println(mobile2 + " <  mobile2");

		MemberDAO mDao = MemberDAO.getInstance();
		String memberId = (String) mDao.findIdUsingMobile(memberName, mobile2);
		PrintWriter out = response.getWriter();
		if (memberId != null) {
			out.print(memberId);
		} else {
			out.print("");
		}
		out.close();
	}
}
