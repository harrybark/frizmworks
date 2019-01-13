package org.web.productcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class ProductUploadDirectionCommand implements ProductQueryCommand{

	@Override
	public void productCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("PRODUCT UPLOAD DIRECTION COMMAND");
		String memberId = request.getParameter("memberId");
		MemberDAO memberdao = MemberDAO.getInstance();
		MemberDTO member = memberdao.memberId(memberId);
		
		if(member != null) {
			request.setAttribute("member", member);
			request.setAttribute("url", "/productUploadform.jsp");	
		}
	}
}
