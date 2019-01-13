package org.web.memberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutCommand implements MemberQueryCommand {

	@Override
	public void memberQuery(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("LOGOUT COMMAND");
		String url = "";
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();
			url = "index.jsp";
		}
		
		request.setAttribute("url", url);
	}
}
