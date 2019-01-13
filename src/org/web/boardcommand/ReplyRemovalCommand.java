package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boarddao.ReviewDAO;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class ReplyRemovalCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Reply Removal Complete Command");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.memberLogin(memberId, memberPw);

		//////////////////// reply parameter /////////////////////////

		int reply_No = Integer.parseInt(request.getParameter("reply_No"));
		int review_No = Integer.parseInt(request.getParameter("review_No"));
		String reply_Writer = request.getParameter("reply_Writer");
		String reply_Password = request.getParameter("reply_Password");

		ReviewDAO rDao = ReviewDAO.getInstance();
		int result = rDao.removalReply(review_No, reply_No, reply_Writer, reply_Password);
		int removalResult = result;
		String url = "";

		if (member != null && result == 1) {
			request.setAttribute("member", member);
			request.setAttribute("removalResult", result);
			url = "reviewList.bo";
		} else if (member != null && result == 0) {
			request.setAttribute("member", member);
			request.setAttribute("removalResult", result);
			url = "reviewList.bo";
		} else if (member == null && result == 1) {
			request.setAttribute("removalResult", result);
			url = "reviewList.bo";
		} else if (member == null && result == 0) {
			request.setAttribute("removalResult", result);
			url = "reviewList.bo";
		} else {
			request.setAttribute("removalResult", result);
			System.out.println("실패");
			url = "reviewList.bo";
		}

		request.setAttribute("url", url);
	}
}
