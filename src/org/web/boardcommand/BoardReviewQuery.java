package org.web.boardcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardReviewQuery {

	void boardReviewCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
