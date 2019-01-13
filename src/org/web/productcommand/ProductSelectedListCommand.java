package org.web.productcommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;
import org.web.productdao.ProductDAO;
import org.web.productdto.ProductDTO;

public class ProductSelectedListCommand implements ProductQueryCommand {

	@Override
	public void productCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("SELECTED PRODUCT COMMAND");
		int product_No = Integer.parseInt(request.getParameter("product_No"));
		System.out.println(product_No + "Number!!");
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductDTO> productList = null;
		productList = pDao.productSelectedList(product_No);
		System.out.println("productList : " + productList);
		String memberId = request.getParameter("memberId");
		MemberDTO member = null;
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.memberId(memberId);

		if (member != null & productList != null) {
//			session.setAttribute("sessionId", session.getAttribute("sessionId"));
//			session.setMaxInactiveInterval(60*10);
			request.setAttribute("member", member);
			request.setAttribute("productList", productList);
			request.setAttribute("url", "/selectedProduct.jsp");
		} else {
			request.setAttribute("productList", productList);
			request.setAttribute("url", "/selectedProduct.jsp");
		}

	}
}
