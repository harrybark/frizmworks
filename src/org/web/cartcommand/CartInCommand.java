package org.web.cartcommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.cartdao.CartDAO;

public class CartInCommand implements CartQueryCommand {

	@Override
	public void CartCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("COMMAND FOR ADDING PRODUCT IN CART");

		String memberId = request.getParameter("memberId");
		int product_No = Integer.parseInt(request.getParameter("product_No"));
		int numbers = Integer.parseInt(request.getParameter("numbers"));
		String product_Name = request.getParameter("product_Name");
		int product_Price = Integer.parseInt(request.getParameter("product_Price"));
		int totalPrice = numbers * product_Price;
		System.out.println(totalPrice);
		CartDAO cdao = CartDAO.getInstance();
		int result = cdao.cartin(product_No, product_Name, memberId, numbers, product_Price, totalPrice);

		PrintWriter out = response.getWriter();

		out.write(result + "");
		out.close();
	}
}
