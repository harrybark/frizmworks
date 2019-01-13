package org.web.cartcommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.cartdao.CartDAO;

public class CartIndexRemoveCommand implements CartQueryCommand {

	@Override
	public void CartCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("CART INDEX REMOVE COMMAND");

		int cart_No = Integer.parseInt(request.getParameter("cart_No"));
		String memberId = request.getParameter("memberId");
		int product_No = Integer.parseInt(request.getParameter("product_No"));

		int result = 0;
		CartDAO cdao = CartDAO.getInstance();
		result = cdao.cartDelete(cart_No, memberId, product_No);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.write(result + "");
		} else {
			out.write(result + "");
		}

		out.close();
	}
}
