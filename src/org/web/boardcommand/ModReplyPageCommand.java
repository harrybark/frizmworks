package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boarddao.ReviewDAO;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;
import org.web.reply.ReplyDTO;

public class ModReplyPageCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Reply mod Command");
		int review_No = Integer.parseInt(request.getParameter("review_No"));
		int reply_No = Integer.parseInt(request.getParameter("reply_No"));

		ReviewDAO rDao = ReviewDAO.getInstance();
		ReplyDTO reply = null;
		reply = rDao.replyRemovalList(review_No, reply_No);

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO member_Dao = MemberDAO.getInstance();
		member = member_Dao.memberLogin(memberId, memberPw);

		if (member != null && reply != null) {
			request.setAttribute("member", member);
			request.setAttribute("reply", reply);
			request.setAttribute("url", "/modReply.jsp");
		} else {
			request.setAttribute("reply", reply);
			request.setAttribute("url", "/modReply.jsp");
		}
	}
}
