package org.web.cartcommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.cartdao.CartDAO;
import org.web.cartdto.CartDTO;
import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class CartIndexCommand implements CartQueryCommand{

	@Override
	public void CartCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("CART LIST COMMAND");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberDTO member = null;
		MemberDAO mdao = MemberDAO.getInstance();
		member = mdao.memberLogin(memberId, memberPw);
		
		CartDAO cDAO = CartDAO.getInstance();
		ArrayList<CartDTO> cartList = cDAO.cartListAll(memberId);
		
		request.setAttribute("member", member);
		request.setAttribute("cartList", cartList);
		request.setAttribute("url", "/cartList.jsp");
	}
}
