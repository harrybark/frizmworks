package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class ReviewWriteCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW WRITE SENDING COMMAND");

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
			url = "/review_Write.jsp";
		} else {
			url = "/reviewList.jsp";
		}

		request.setAttribute("url", url);

	}

}
