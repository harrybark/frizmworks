package org.web.boardcommand;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.boarddao.ReviewDAO;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteCompleteCommand implements BoardReviewQuery {

	@Override
	public void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("REVIEW WIRTE COMMAND");
		int result = 0;
		// file upload 처리
//		String directory = "/Users/harry/Desktop/upload/";
		String directory = "/Users/harry/eclipse-workspace/Portfolio_PMW/WebContent/upload/";
//		cafe 24 upload 할 경우 path 변경 해주어야 함.!!
		
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";

		MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
//		Enumeration fileNames = multipartRequest.getFileNames();
//		Enumeration fileNames2 = multipartRequest.getFileNames();

		String review_fileDBName = null;
		String review_fileRealName = null;
		String review_fileDBName2 = null;
		String review_fileRealName2 = null;
		String review_Writer = multipartRequest.getParameter("review_Writer");
		String review_Subject = multipartRequest.getParameter("review_Subject");
		String review_Contents = multipartRequest.getParameter("review_Contents");
		String review_Password = multipartRequest.getParameter("review_Password");
		String memberId = review_Writer;
		System.out.println(review_Subject + " << command review_Subject");
		System.out.println(review_Contents + " << command review_Contents");
		System.out.println(review_Writer + " << command review_Writer");
		System.out.println(review_Password + " << command review_Password");
		MemberDTO member = null;
		MemberDAO member_dao = MemberDAO.getInstance();
		member = member_dao.memberId(memberId);

		review_fileDBName = multipartRequest.getOriginalFileName("file1");
		review_fileRealName = multipartRequest.getOriginalFileName("file1");
		review_fileDBName2 = multipartRequest.getOriginalFileName("file2");
		review_fileRealName2 = multipartRequest.getOriginalFileName("file2");

		String url = "";
		ReviewDAO review_dao = ReviewDAO.getInstance();
		result = review_dao.review_create(review_Writer, review_Subject, review_fileDBName, review_fileRealName,
				review_fileDBName2, review_fileRealName2, review_Contents, review_Password);
		
		HttpSession session = request.getSession();
		request.setAttribute("member", member);
		
		if (result == 1) {
			System.out.println("Complete to upload process");
			session.setAttribute("sessionId", session.getAttribute("sessionId"));
			session.setMaxInactiveInterval(60*10);
			request.setAttribute("url", "/reviewList.bo");
		} else {
			System.out.println("fail to upload");
			request.setAttribute("url", "/review_Write.bo");
		}

	}
}
