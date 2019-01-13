package org.web.boardcommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boarddao.ReviewDAO;
import org.web.boarddto.BoardReview;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;
import org.web.pagination.Paging;

public class SearchReviewListCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW BOARD RETRIEVE(SEARCH) LISTS");

		String review_Subject = request.getParameter("review_Subject");

		ReviewDAO review_dao = ReviewDAO.getInstance();

		ArrayList<BoardReview> searchList = null;
		int totalCount = review_dao.getTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalCount);

		page = (page - 1) * 8;
		searchList = review_dao.searchReviewList(review_Subject, page, paging.getPageSize());

		String memberId = request.getParameter("memberId");
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO member = null;
		member = mdao.memberId(memberId);

		if (member != null && searchList != null) {
			request.setAttribute("member", member);
			request.setAttribute("paging", paging);
			request.setAttribute("reviewList", searchList);
			request.setAttribute("url", "/reviewList.jsp");

		} else {
			request.setAttribute("paging", paging);
			request.setAttribute("reviewList", searchList);
			request.setAttribute("url", "/reviewList.jsp");
		}
	}
}
