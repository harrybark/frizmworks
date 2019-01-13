package org.web.cartcommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.cartdao.CartDAO;

public class CartNumbersChangeCommand implements CartQueryCommand {

	@Override
	public void CartCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("CART NUMBERS CHANGE COMMAND");

		String memberId = request.getParameter("memberId");

		int cart_No = Integer.parseInt(request.getParameter("cart_No"));
		int product_No = Integer.parseInt(request.getParameter("product_No"));
		String product_Name = request.getParameter("product_Name");
		int numbers = Integer.parseInt(request.getParameter("numbers"));
		int product_Price = Integer.parseInt(request.getParameter("product_Price"));

		int totalPrice = numbers * product_Price;
		System.out.println(cart_No);
		PrintWriter out = response.getWriter();
		CartDAO cdao = CartDAO.getInstance();
		int result = cdao.cartNumbersChange(memberId, product_Name, cart_No, product_No, numbers, product_Price, totalPrice);

		if (result == 1) {
			out.write(result + "");
		} else {
			out.write(result + "");
		}

		out.close();
	}
}
