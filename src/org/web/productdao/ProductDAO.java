package org.web.productdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.dbconnect.DBConnect;
import org.web.productdto.ProductDTO;

public class ProductDAO {

	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}

	private static class singleTon {
		private static final ProductDAO INSTANCE = new ProductDAO();
	}

	public static ProductDAO getInstance() {
		return singleTon.INSTANCE;
	}

	// 상품 업로드입니다.

	public int uploadProduct(String memberId, String product_Name, String product_Categories,
			String product_Explanation, int product_Price, int product_Inventory, String product_fileDBName,
			String product_fileRealName) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into product(product_Group, product_Indent, product_Step, product_Hit, memberId , product_Name, product_Categories, product_Explanation, product_Price, product_Inventory, product_fileDBName, product_fileRealName) values ((select case count(*) when 0 then 1 else max(product_Group) + 1 end from product a), 0, 0, 0, ? , ?, ?, ?,?,?,?,? )";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, memberId);
			pstm.setString(2, product_Name);
			pstm.setString(3, product_Categories);
			pstm.setString(4, product_Explanation);
			pstm.setInt(5, product_Price);
			pstm.setInt(6, product_Inventory);
			pstm.setString(7, product_fileDBName);
			pstm.setString(8, product_fileRealName);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
			}
		}
		return result;
	}

	// 상품 리스트 입니다.

	public ArrayList<ProductDTO> productListRetrieve() {
		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM PRODUCT ORDER BY PRODUCT_NO DESC";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ProductDTO pDTO = new ProductDTO();
					pDTO.setProduct_No(rs.getInt(1));
					pDTO.setProduct_Group(rs.getInt(2));
					pDTO.setProduct_Indent(rs.getInt(3));
					pDTO.setProduct_Step(rs.getInt(4));
					pDTO.setProduct_Hit(rs.getInt(5));
					pDTO.setMemberId(rs.getString(6));
					pDTO.setProduct_Name(rs.getString(7));
					pDTO.setProduct_Categories(rs.getString(8));
					pDTO.setProduct_Explanation(rs.getString(9));
					pDTO.setProduct_Price(rs.getInt(10));
					pDTO.setProduct_Inventory(rs.getInt(11));
					pDTO.setProduct_fileDBName(rs.getString(12));
					pDTO.setProduct_fileRealName(rs.getString(13));

					productList.add(pDTO);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {

			}
		}

		return productList;
	}

	// 선택한 상품의 리스트 보기 입니다.

	public ArrayList<ProductDTO> productSelectedList(int product_No) {
		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM PRODUCT WHERE product_No = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, product_No);
			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					int product_No2 = rs.getInt(1);
					int product_Group = rs.getInt(2);
					int product_Indent = rs.getInt(3);
					int product_Step = rs.getInt(4);
					int product_Hit = rs.getInt(5);
					String memberId = rs.getString(6);
					String product_Name = rs.getString(7);
					String product_Categories = rs.getString(8);
					String product_Explanation = rs.getString(9);
					int product_Price = rs.getInt(10);
					int product_Inventory = rs.getInt(11);
					String product_fileDBName = rs.getString(12);
					String product_fileRealName = rs.getString(13);
					ProductDTO product = new ProductDTO(product_No2, product_Group, product_Indent, product_Step,
							product_Hit, memberId, product_Name, product_Categories, product_Explanation, product_Price,
							product_Inventory, product_fileDBName, product_fileRealName);
					productList.add(product);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {

			}
		}

		return productList;
	}
}
