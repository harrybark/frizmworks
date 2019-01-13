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
import org.web.reply.ReplyDTO;

public class SelectedListViewCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW BOARD RETRIEVE SELECTED LISTS");

		int review_No = Integer.parseInt(request.getParameter("review_No"));
		System.out.println(review_No);

		ReviewDAO review_dao = ReviewDAO.getInstance();
		ArrayList<BoardReview> review_list = review_dao.selectedListView(review_No);

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO member_Dao = MemberDAO.getInstance();
		member = member_Dao.memberLogin(memberId, memberPw);

		ReviewDAO rDao = ReviewDAO.getInstance();
		ArrayList<ReplyDTO> replyList = null;
		
		replyList = rDao.replyRetrieve(review_No);

		if (member != null && replyList != null) {
			request.setAttribute("member", member);
			request.setAttribute("review_list", review_list);
			request.setAttribute("replyList", replyList);
			request.setAttribute("url", "/selectedList.jsp");

		} else {
			request.setAttribute("review_list", review_list);
			request.setAttribute("replyList", replyList);
			request.setAttribute("url", "/selectedList.jsp");
		}
	}
}
