package org.web.boardcommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.boarddao.ReviewDAO;
import org.web.boarddto.BoardReview;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class ReviewListModifyCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Review List Modification Command");

		int review_No = Integer.parseInt(request.getParameter("review_No"));
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO member_Dao = MemberDAO.getInstance();
		ReviewDAO review_dao = ReviewDAO.getInstance();
		ArrayList<BoardReview> review_dto = review_dao.selectedListView(review_No);

		member = member_Dao.memberLogin(memberId, memberPw);
		HttpSession session = request.getSession();

		System.out.println("have to take a modifications");
		session.setAttribute("sessionId", session.getAttribute("sessionId"));
		session.setMaxInactiveInterval(60 * 10);
		
		request.setAttribute("review_dto", review_dto);
		request.setAttribute("member", member);
		request.setAttribute("url", "/modification.jsp");

	}

}
