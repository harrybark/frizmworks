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
import org.web.reply.ReplyDTO;

public class ReReplyCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("RE-REPLY WRITE COMMAND");

		// reply
		int review_No = Integer.parseInt(request.getParameter("review_No"));
		int reply_No = Integer.parseInt(request.getParameter("reply_No"));

		ReplyDTO reply = null;
		ReviewDAO rDao = ReviewDAO.getInstance();
		reply = rDao.replyRemovalList(review_No, reply_No);
		
		// member

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO member = null;
		member = mDao.memberLogin(memberId, memberPw);
		
		if(member != null) {
			request.setAttribute("member", member);
			request.setAttribute("reply", reply);
		} else{
			request.setAttribute("reply", reply);
		}
		
		request.setAttribute("url", "/resReplyWriteform.jsp");
	}
}
