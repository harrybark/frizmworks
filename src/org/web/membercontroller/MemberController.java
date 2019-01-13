package org.web.membercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberCommand.MainCommand;
import org.web.memberCommand.MemberFindIdUsingEmailCommand;
import org.web.memberCommand.MemberFindIdUsingMobileCommand;
import org.web.memberCommand.MemberFindPwUsingEmailCommand;
import org.web.memberCommand.MemberFindPwUsingMobileCommand;
import org.web.memberCommand.MemberIdCheckCommand;
import org.web.memberCommand.MemberInfoCommand;
import org.web.memberCommand.MemberLoginCommand;
import org.web.memberCommand.MemberLogoutCommand;
import org.web.memberCommand.MemberModificationCommand;
import org.web.memberCommand.MemberQueryCommand;
import org.web.memberCommand.MemberRemovalCommand;
import org.web.memberCommand.MemberSignInCommand;

@WebServlet("*.mo")
public class MemberController extends HttpServlet {

	// dopost, doget
	// doget으로 받아 데이터를 처리합니다.

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
		// String includeUrl = "";
		MemberQueryCommand action = null;
		if (conPath.equals("/main.mo")) {
			action = new MainCommand();
			action.memberQuery(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/logout.mo")) {
			action = new MemberLogoutCommand();
			action.memberQuery(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/sign.mo")) {
			action = new MemberSignInCommand();
			action.memberQuery(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/loginAction.mo")) {
			action = new MemberLoginCommand();
			action.memberQuery(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/myInfo.mo")) {
			action = new MemberInfoCommand();
			action.memberQuery(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/idcheck.mo")) {
			action = new MemberIdCheckCommand();
			action.memberQuery(request, response);
			return;
		} else if (conPath.equals("/findIdUsingEmail.mo")) {
			action = new MemberFindIdUsingEmailCommand();
			action.memberQuery(request, response);
			return;
		} else if (conPath.equals("/findIdUsingMobile.mo")) {
			action = new MemberFindIdUsingMobileCommand();
			action.memberQuery(request, response);
			return;
		} else if (conPath.equals("/findPwUsingEmail.mo")) {
			action = new MemberFindPwUsingEmailCommand();
			action.memberQuery(request, response);
			return;
		} else if (conPath.equals("/findPwUsingMobile.mo")) {
			action = new MemberFindPwUsingMobileCommand();
			action.memberQuery(request, response);
			return;
		}else if (conPath.equals("/removalAccount.mo")) {
			action = new MemberRemovalCommand();
			action.memberQuery(request, response);
			return;
		} else if (conPath.equals("/modAccount.mo")) {
			action = new MemberModificationCommand();
			action.memberQuery(request, response);
			return;
		}

		// RequestDispatcher dispatcherInclude =
		// request.getRequestDispatcher(includeUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);

		// dispatcherInclude.include(request, response);

		dispatcher.forward(request, response);
	}
}
