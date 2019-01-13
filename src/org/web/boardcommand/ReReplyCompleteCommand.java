package org.web.boardcommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boarddao.ReviewDAO;
import org.web.boarddto.BoardReview;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class ReReplyCompleteCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Re-REPLY WRITE COMMAND 22");

		// member data
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberDTO member = null;
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.memberLogin(memberId, memberPw);
		// reviewboard

		int review_No = Integer.parseInt(request.getParameter("review_No"));
		ArrayList<BoardReview> review_List = new ArrayList<BoardReview>();
		ReviewDAO rDao = ReviewDAO.getInstance();
		review_List = rDao.selectedListView(review_No);

		// reply
		String reply_Writer = request.getParameter("reply_Writer");
		int reply_Group = Integer.parseInt(request.getParameter("reply_Group"));
		int reply_Indent = Integer.parseInt(request.getParameter("reply_Indent"));
		int reply_Step = Integer.parseInt(request.getParameter("reply_Step"));

		String reply_Subject = request.getParameter("reply_Subject");
		String reply_Contents = request.getParameter("reply_Contents");
		String reply_Password = request.getParameter("reply_Password");

		int result = rDao.replysReply(reply_Group, reply_Indent, reply_Step, review_No, reply_Subject, reply_Writer,
				reply_Contents, reply_Password);

		if (member != null && review_List != null && result == 1) {
			// 로그인 덧글 작성
			request.setAttribute("member", member);
			request.setAttribute("review_list", review_List);
			request.setAttribute("url", "/selectedReviewList.bo");
		} else if (member != null && review_List != null && result == 0) {
			// 로그인 덧글 작성
			request.setAttribute("member", member);
			request.setAttribute("review_list", review_List);
			request.setAttribute("url", "/selectedReviewList.bo");
		} else if (member == null && review_List != null && result == 1) {
			// 비로그인 덧글 작성
			request.setAttribute("review_list", review_List);
			request.setAttribute("url", "/selectedReviewList.bo");
		} else if (member == null && review_List != null && result == 0) {
			// 비로그인 덧글 작성
			request.setAttribute("review_list", review_List);
			request.setAttribute("url", "/selectedReviewList.bo");
		} else {

			System.out.println("실패");

		}

	}
}
