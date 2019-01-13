package org.web.boardcommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boarddao.ReviewDAO;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;
import org.web.reply.ReplyDTO;

public class ReplyModificationCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Reply-mod action command");
		int reply_No = Integer.parseInt(request.getParameter("reply_No"));
		System.out.println(reply_No + " << reply_No");
		int review_No = Integer.parseInt(request.getParameter("review_No"));
		String reply_Writer = request.getParameter("reply_Writer");
		String reply_Subject = request.getParameter("reply_Subject");
		String reply_Contents = request.getParameter("reply_Contents");
		String reply_Password = request.getParameter("reply_Password");
		System.out.println(reply_Password + " reply_Password");
		ReviewDAO rDao = ReviewDAO.getInstance();
		
		int reply = rDao.modReply(reply_No, review_No, reply_Writer, reply_Subject, reply_Contents, reply_Password);
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberDTO member = null;
		MemberDAO member_Dao = MemberDAO.getInstance();
		member = member_Dao.memberLogin(memberId, memberPw);

		PrintWriter out = response.getWriter();
		System.out.println(reply + " == reply");
		if (member != null && reply == 1) {
			reply = 2;
		} else if (member != null && reply == 0) {
			reply = -2;
		} else if (member == null && reply == 1) {
			reply = 1;
		} else if (member == null && reply == 0) {
			reply = -1;
		} else {
			reply = 0;
		}
		out.write(reply + "");
		out.close();
	}
}
