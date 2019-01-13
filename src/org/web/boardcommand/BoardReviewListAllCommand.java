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
import org.web.pagination.Paging;

public class BoardReviewListAllCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW BOARD RETRIEVE ALL LISTS");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO member_dao = MemberDAO.getInstance();
		member = member_dao.memberLogin(memberId, memberPw);
		
		ReviewDAO review_dao = ReviewDAO.getInstance();
		ArrayList<BoardReview> review = null;
		int totalCount = review_dao.getTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalCount);
		
		page = (page-1) * 8;
		review = review_dao.allRetrieve(page, paging.getPageSize());
		if (member != null) {
			request.setAttribute("member", member);
			request.setAttribute("reviewList", review);
			request.setAttribute("paging", paging);
			request.setAttribute("url", "/reviewList.jsp");
		} else {
			request.setAttribute("reviewList", review);
			request.setAttribute("paging", paging);
			request.setAttribute("url", "/reviewList.jsp");
		}

	}
}
