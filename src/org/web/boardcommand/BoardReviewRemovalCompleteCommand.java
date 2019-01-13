package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.boardcontroller.ReviewBoardController;
import org.web.boarddao.ReviewDAO;
import org.web.boarddto.BoardReview;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardReviewRemovalCompleteCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW BOARD REMOVAL COMPLETETION COMMAND");

		String memberId = request.getParameter("memberId");
		
		int review_No = Integer.parseInt(request.getParameter("review_No"));
		String review_Writer = request.getParameter("review_Writer");
		String review_Password = request.getParameter("review_Password");
		
		ReviewDAO rDao = ReviewDAO.getInstance();
		int result = rDao.removalBoardList(review_No, review_Writer, review_Password);
		
		MemberDTO member = null;
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.memberId(memberId);
		if(result == 1) {
			System.out.println("게시글 삭제 성공");
			request.setAttribute("member", member);
			request.setAttribute("url", "/reviewList.bo");
		} else {
			System.out.println("게시글 삭제 실패");
			request.setAttribute("url", "/reviewList.bo");
		}
	}
}
