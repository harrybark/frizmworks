package org.web.boardcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.boardcommand.BoardReviewListAllCommand;
import org.web.boardcommand.BoardReviewModificationCompleteCommand;
import org.web.boardcommand.BoardReviewQuery;
import org.web.boardcommand.BoardReviewRemovalCompleteCommand;
import org.web.boardcommand.ModReplyPageCommand;
import org.web.boardcommand.ReReplyCommand;
import org.web.boardcommand.ReReplyCompleteCommand;
import org.web.boardcommand.RemovalReplyPageCommand;
import org.web.boardcommand.ReplyCommand;
import org.web.boardcommand.ReplyModificationCommand;
import org.web.boardcommand.ReplyRemovalCommand;
import org.web.boardcommand.ReviewListModifyCommand;
import org.web.boardcommand.ReviewListRemovalCommand;
import org.web.boardcommand.ReviewWriteCommand;
import org.web.boardcommand.ReviewWriteCompleteCommand;
import org.web.boardcommand.SearchReviewListCommand;
import org.web.boardcommand.SelectedListViewCommand;

@WebServlet("*.bo")
public class ReviewBoardController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방치를 위한 characterEncoding
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String conPath = uri.substring(path.length());

		String url = "";
		BoardReviewQuery action = null;

		// 글 전체 목록
		if (conPath.equals("/reviewList.bo")) {
			action = new BoardReviewListAllCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 게시글 작성페이지 이동
		else if (conPath.equals("/review_Write.bo")) {
			action = new ReviewWriteCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 게시글 작성 완료
		else if (conPath.equals("/reviewComplete.bo")) {
			action = new ReviewWriteCompleteCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 특정(선택한) 게시글 보기입다.
		else if (conPath.equals("/selectedReviewList.bo")) {
			action = new SelectedListViewCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 동기 방식 검색 기능입니다.
		else if (conPath.equals("/searchReviewList.bo")) {
			action = new SearchReviewListCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 선택한 게시글 수정입니다.
		else if (conPath.equals("/reviewmodify.bo")) {
			action = new ReviewListModifyCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 선택한 게시글의 데이터 수정 (form 에서 받아 처리)
		else if (conPath.equals("/modificationComplete.bo")) {
			action = new BoardReviewModificationCompleteCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 선택한 게시글의 데이터 삭제입니다.
		else if (conPath.equals("/reviewDelete.bo")) {
			action = new ReviewListRemovalCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/removalComplete.bo")) {
			action = new BoardReviewRemovalCompleteCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 댓글 추가
		else if (conPath.equals("/reply.bo")) {
			action = new ReplyCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 댓글 삭제 페이지입니다.
		else if (conPath.equals("/removalReplyPage.bo")) {
			action = new RemovalReplyPageCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 댓글 삭제 쿼리 실행 페이지입니다.
		else if (conPath.equals("/deleteReply.bo")) {
			action = new ReplyRemovalCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 댓글 수정 페이지입니다.
		else if (conPath.equals("/modReplyPage.bo")) {
			action = new ModReplyPageCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		// 댓글 수정 쿼리 실행 페이지입니다.
		else if (conPath.equals("/modReply.bo")) {
			action = new ReplyModificationCommand();
			action.boardReviewCommand(request, response);
			return;
		}
		else if (conPath.equals("/resReplyWriteform.bo")) {
			action = new ReReplyCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		//덧글의 덧글 추가 입니다.
		else if (conPath.equals("/reReply.bo")) {
			action = new ReReplyCompleteCommand();
			action.boardReviewCommand(request, response);
			url = (String) request.getAttribute("url");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
