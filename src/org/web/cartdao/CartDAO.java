package org.web.cartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.cartdto.CartDTO;
import org.web.dbconnect.DBConnect;

public class CartDAO {

	public CartDAO() {
		// TODO Auto-generated constructor stub
	}

	private static class singleTon {
		private static final CartDAO INSTANCE = new CartDAO();
	}

	public static CartDAO getInstance() {
		return singleTon.INSTANCE;
	}

	// 카트 담기 입니다.

	public int cartin(int product_No, String product_Name, String memberId, int numbers, int product_Price,
			int totalPrice) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into cart(memberId, product_No, product_Name, numbers, product_Price, totalPrice) values(?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			pstm.setInt(2, product_No);
			pstm.setString(3, product_Name);
			pstm.setInt(4, numbers);
			pstm.setInt(5, product_Price);
			pstm.setInt(6, totalPrice);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
			}
		}
		return result;
	}

	public ArrayList<CartDTO> cartListAll(String memberId) {
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM CART WHERE memberId=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CartDTO cartDTO = new CartDTO();
					cartDTO.setCart_No(rs.getInt(1));
					cartDTO.setMemberId(rs.getString(2));
					cartDTO.setProduct_No(rs.getInt(3));
					cartDTO.setProduct_Name(rs.getString(4));
					cartDTO.setNumbers(rs.getInt(5));
					cartDTO.setProduct_Price(rs.getInt(6));
					cartDTO.setTotalPrice(rs.getInt(7));

					cartList.add(cartDTO);
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

		return cartList;
	}

	// 카트 장바구니 수량 변경입니다.
	public int cartNumbersChange(String memberId, String product_Name, int cart_No, int product_No, int numbers,
			int product_Price, int totalPrice) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "update cart set numbers=?, totalPrice=? where cart_No=? and memberId=? and product_No=? and product_Name=? and product_Price=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, numbers);
			pstm.setInt(2, totalPrice);
			pstm.setInt(3, cart_No);
			pstm.setString(4, memberId);
			pstm.setInt(5, product_No);
			pstm.setString(6, product_Name);
			pstm.setInt(7, product_Price);

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

	// 카트 목록 삭제입니다.
	public int cartDelete(int cart_No, String memberId, int product_No) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "delete from cart where cart_No=? and memberId=? and product_No=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, cart_No);
			pstm.setString(2, memberId);
			pstm.setInt(3, product_No);
			
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
}
