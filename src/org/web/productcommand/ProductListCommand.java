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

public class ProductListCommand implements ProductQueryCommand {

	@Override
	public void productCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("PRODUCT LIST COMMAND");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberDTO member = null;
		MemberDAO memberDAO = MemberDAO.getInstance();
		member = memberDAO.memberLogin(memberId, memberPw);
		
		ProductDAO pDAO = ProductDAO.getInstance();
		ArrayList<ProductDTO> pList = pDAO.productListRetrieve();
		
		HttpSession session = request.getSession();
		if (member != null) {
			session.setAttribute("sessionId", session.getAttribute("sessionId"));
			session.setMaxInactiveInterval(60 * 10);
			request.setAttribute("member", member);
			request.setAttribute("pList", pList);
			request.setAttribute("url", "/productList.jsp");
		} else {
			request.setAttribute("member", member);
			request.setAttribute("pList", pList);
			request.setAttribute("url", "/productList.jsp");
		}

	}
}
