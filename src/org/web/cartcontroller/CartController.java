package org.web.cartcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.cartcommand.CartInCommand;
import org.web.cartcommand.CartIndexCommand;
import org.web.cartcommand.CartIndexRemoveCommand;
import org.web.cartcommand.CartNumbersChangeCommand;
import org.web.cartcommand.CartQueryCommand;

@WebServlet("*.ca")
public class CartController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; chartset=utf8");
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; chartset=utf8");

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String conPath = uri.substring(path.length());

		String url = "";
		CartQueryCommand action = null;

		if (conPath.equals("/addCart.ca")) {
			action = new CartInCommand();
			action.CartCommand(request, response);
			return;
		}
		else	if (conPath.equals("/cartNumberChange.ca")) {
			action = new CartNumbersChangeCommand();
			action.CartCommand(request, response);
			return;
		}
		else	if (conPath.equals("/cartIndexRemove.ca")) {
			action = new CartIndexRemoveCommand();
			action.CartCommand(request, response);
			return;
		}
		else	if (conPath.equals("/cartList.ca")) {
			action = new CartIndexCommand();
			action.CartCommand(request, response);
			url = (String) request.getAttribute("url");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
