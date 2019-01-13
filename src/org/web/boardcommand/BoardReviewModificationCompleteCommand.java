package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.boarddao.ReviewDAO;
import org.web.boarddto.BoardReview;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardReviewModificationCompleteCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW BOARD MODIFICATION COMPLETETION COMMAND");

		int result = 0;
		// file upload 처리
//		String directory = "/Users/harry/Desktop/upload/";
		String directory = "/Users/harry/eclipse-workspace/Portfolio_PMW/WebContent/upload/";
//		cafe 24 upload 할 경우 path 변경 해주어야 함.!!

		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";

		MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());

		int review_No = Integer.parseInt(multipartRequest.getParameter("review_No"));
		String review_Subject = multipartRequest.getParameter("review_Subject");
		String review_Writer = multipartRequest.getParameter("review_Writer");
		String review_Contents = multipartRequest.getParameter("review_Contents");
		String review_Password = multipartRequest.getParameter("review_Password");
		String review_fileDBName = null;
		String review_fileRealName = null;
		String review_fileDBName2 = null;
		String review_fileRealName2 = null;
		String memberId = multipartRequest.getParameter("memberId");
		System.out.println(review_No + "<< command review_No22");
		System.out.println(review_Subject + " << command review_Subject22");
		System.out.println(review_Contents + " << command review_Contents22");
		System.out.println(review_Writer + " << command review_Writer22");
		System.out.println(review_Password + " << command review_Password22");
		MemberDTO member = null;
		MemberDAO member_dao = MemberDAO.getInstance();

		member = member_dao.memberId(memberId);

		review_fileDBName = multipartRequest.getOriginalFileName("file3");
		review_fileRealName = multipartRequest.getOriginalFileName("file3");
		review_fileDBName2 = multipartRequest.getOriginalFileName("file4");
		review_fileRealName2 = multipartRequest.getOriginalFileName("file4");

		HttpSession session = request.getSession();
		ReviewDAO review_dao = ReviewDAO.getInstance();
		int review = review_dao.modification(review_No, review_Writer, review_Subject, review_Contents,
				review_fileRealName, review_fileDBName, review_fileRealName2, review_fileDBName2, review_Password);
		if (member != null && review == 1) {
			System.out.println("수정 성공");
			session.setAttribute("sessionid", session.getAttribute("sessionId"));
			session.setMaxInactiveInterval(60 * 10);
			request.setAttribute("member", member);
			request.setAttribute("list", review);
			request.setAttribute("modResult", 1);
			request.setAttribute("url", "/reviewList.bo");
		} else {
			System.out.println("수정실패");
			session.setAttribute("sessionid", session.getAttribute("sessionId"));
			session.setMaxInactiveInterval(60 * 10);
			request.setAttribute("member", member);
			request.setAttribute("list", review);
			request.setAttribute("modResult", 0);
			request.setAttribute("url", "/reviewList.bo");
		}
	}
}
