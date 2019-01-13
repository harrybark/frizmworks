package org.web.productcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.productcommand.ProductListCommand;
import org.web.productcommand.ProductQueryCommand;
import org.web.productcommand.ProductSelectedListCommand;
import org.web.productcommand.ProductUploadCommand;
import org.web.productcommand.ProductUploadDirectionCommand;

@WebServlet("*.pd")
public class ProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String conPath = uri.substring(path.length());

		String url = "";
		ProductQueryCommand action = null;

		if (conPath.equals("/productUploadform.pd")) {
			action = new ProductUploadDirectionCommand();
			action.productCommand(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/productList.pd")) {
			action = new ProductListCommand();
			action.productCommand(request, response);
			url = (String) request.getAttribute("url");
		} else if (conPath.equals("/uploadProduct.pd")) {
			action = new ProductUploadCommand();
			action.productCommand(request, response);
			return;
		} else if (conPath.equals("/selectedProduct.pd")) {
			action = new ProductSelectedListCommand();
			action.productCommand(request, response);
			url = (String) request.getAttribute("url");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
