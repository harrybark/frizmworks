package org.web.productcommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.productdao.ProductDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductUploadCommand implements ProductQueryCommand {

	@Override
	public void productCommand(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("PRODUCT UPLOAD COMMAND");
		int result = 0;
		String directory = "/Users/harry/eclipse-workspace/Portfolio_PMW/WebContent/upload/";
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
		String memberId = multipartRequest.getParameter("memberId");
		String product_Name = multipartRequest.getParameter("product_Name");
		String product_Categories = multipartRequest.getParameter("product_Categories");
		String product_Explanation = multipartRequest.getParameter("product_Explanation");
		int product_Price = Integer.parseInt(multipartRequest.getParameter("product_Price"));
		int product_Inventory = Integer.parseInt(multipartRequest.getParameter("product_Inventory"));

		String product_fileDBName = null;
		String product_fileRealName = null;
		product_fileDBName = multipartRequest.getOriginalFileName("file1");
		product_fileRealName = multipartRequest.getOriginalFileName("file1");

		System.out.println("MEMBERID : "+  memberId);
		System.out.println("product_Name : " + product_Name);
		System.out.println("product_Categories : " + product_Categories);
		System.out.println("product_Explanation : " + product_Explanation);
		System.out.println("product_Price : " + product_Price);
		System.out.println("product_Inventory : " + product_Inventory);
		
		ProductDAO pDao = ProductDAO.getInstance();
		result = pDao.uploadProduct(memberId, product_Name, product_Categories, product_Explanation, product_Price, product_Inventory, product_fileDBName, product_fileRealName);
		
		PrintWriter out = response.getWriter();
		if(result == 1) {
			System.out.println("업로드 성공");
			out.write(result + "");
		} else {
			System.out.println("업로드 실패");
			out.write(result + "");
		}
		
		out.close();
	}
}
