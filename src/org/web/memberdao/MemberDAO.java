package org.web.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.web.dbconnect.DBConnect;
import org.web.memberdto.MemberDTO;

public class MemberDAO {

	// 싱글톤 패턴을 이용하여 MemberDAO Data Access Object를 생성합니다.
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	private static class singleton {
		private static final MemberDAO INSTANCE = new MemberDAO();
	}

	public static MemberDAO getInstance() {
		return singleton.INSTANCE;
	}

	// 각 각의 member Command DAO를 요청, 응답을 위한 객체입니다.

	// 회원 가입을 위한 DAO객체
	public int memberSignIn(MemberDTO member) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		int result = 0;
		try {
			conn = DBConnect.getConnection();
			query = "insert into memberdb values(?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, member.getMemberId());
			pstm.setString(2, member.getMemberPw());
			pstm.setString(3, member.getMemberName());
			pstm.setString(4, member.getRoadAddr());
			pstm.setString(5, member.getJibunAddr());
			pstm.setString(6, member.getMobile1());
			pstm.setString(7, member.getMobile2());
			pstm.setString(8, member.getSmsOk());
			pstm.setString(9, member.getMemberEmail());
			pstm.setString(10, member.getEmailOk());

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

	public MemberDTO memberLogin(String memberId, String memberPw) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		MemberDTO member = null;

		try {
			conn = DBConnect.getConnection();
			query = "select * from memberdb where memberId = ? and memberPw = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			pstm.setString(2, memberPw);
			System.out.println(memberId);
			System.out.println(memberPw + "<< DAO");
			rs = pstm.executeQuery();

			while (rs.next()) {

				String memberId2 = rs.getString(1);
				String memberPw2 = rs.getString(2);
				String memberName = rs.getString(3);
				String roadAddr = rs.getString(4);
				String jibunAddr = rs.getString(5);
				String mobile1 = rs.getString(6);
				String mobile2 = rs.getString(7);
				String smsOk = rs.getString(8);
				String memberEmail = rs.getString(9);
				String emailOk = rs.getString(10);

				member = new MemberDTO(memberId2, memberPw2, memberName, roadAddr, jibunAddr, mobile1, mobile2, smsOk,
						memberEmail, emailOk);
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
		return member;
	}

	public int idCheck(String memberId) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		int result = 0;

		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from memberdb where memberId = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			System.out.println(memberId);
			rs = pstm.executeQuery();

			while (rs.next()) {

				result = rs.getInt(1);
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
		return result;
	}

	public MemberDTO memberId(String memberId) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		MemberDTO member = null;

		try {
			conn = DBConnect.getConnection();
			query = "select * from memberdb where memberId = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			System.out.println(memberId);
			rs = pstm.executeQuery();

			while (rs.next()) {

				String memberId2 = rs.getString(1);
				String memberPw = rs.getString(2);
				String memberName = rs.getString(3);
				String roadAddr = rs.getString(4);
				String jibunAddr = rs.getString(5);
				String mobile1 = rs.getString(6);
				String mobile2 = rs.getString(7);
				String smsOk = rs.getString(8);
				String memberEmail = rs.getString(9);
				String emailOk = rs.getString(10);

				member = new MemberDTO(memberId2, memberPw, memberName, roadAddr, jibunAddr, mobile1, mobile2, smsOk,
						memberEmail, emailOk);
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
		return member;
	}
// 아이디 찾기(이메일)
	public String findIdUsingEmail(String memberName, String memberEmail) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		String memberId = null;

		try {
			conn = DBConnect.getConnection();
			query = "select memberId from memberdb where memberName = ? and memberEmail = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberName);
			pstm.setString(2, memberEmail);

			rs = pstm.executeQuery();

			while (rs.next()) {
				memberId = rs.getString("memberId");
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
		System.out.println(memberId + "<< DAO memberId");
		return memberId;
	}
// 비밀번호 찾기(이메일)
	public String findPwUsingEmail(String memberId, String memberEmail) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		String memberPw = null;

		try {
			conn = DBConnect.getConnection();
			query = "select memberPw from memberdb where memberId = ? and memberEmail = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			pstm.setString(2, memberEmail);

			rs = pstm.executeQuery();

			while (rs.next()) {
				memberPw = rs.getString("memberPw");
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
		System.out.println(memberPw + "<< DAO memberPw");
		return memberPw;
	}
//아이디찾기(전화번호)	
	public String findIdUsingMobile(String memberName, String mobile2) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		String memberId = null;

		try {
			conn = DBConnect.getConnection();
			query = "select memberId from memberdb where memberName = ? and mobile2 = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberName);
			pstm.setString(2, mobile2);

			rs = pstm.executeQuery();

			while (rs.next()) {
				memberId = rs.getString("memberId");
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
		System.out.println(memberId + "<< DAO memberId");
		return memberId;
	}
//비밀번호찾기(전화번호)	
	public String findPwUsingMobile(String memberId, String mobile2) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		String memberPw = null;

		try {
			conn = DBConnect.getConnection();
			query = "select memberPw from memberdb where memberId = ? and mobile2 = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			pstm.setString(2, mobile2);

			rs = pstm.executeQuery();

			while (rs.next()) {
				memberPw = rs.getString("memberPw");
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
		System.out.println(memberPw + "<< DAO memberPw");
		return memberPw;
	}

	public int accountRemoval(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		int result = 0;

		try {
			conn = DBConnect.getConnection();
			query = "delete from memberdb where memberId = ? and memberPw = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberId);
			pstm.setString(2, memberPw);

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

	public int accountMod(String memberId, String memberPw, String memberName, String memberEmail, String mobile2,
			String roadAddr, String jibunAddr, String smsOk, String emailOk) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		int result = 0;

		try {
			conn = DBConnect.getConnection();
			query = "update memberdb set memberName=?, roadAddr=?, jibunAddr=?, mobile2=?, smsOk=?, memberEmail=?, emailOk=? where memberId=? and memberPw=? ";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, memberName);
			pstm.setString(2, roadAddr);
			pstm.setString(3, jibunAddr);
			pstm.setString(4, mobile2);
			pstm.setString(5, smsOk);
			pstm.setString(6, memberEmail);
			pstm.setString(7, emailOk);
			pstm.setString(8, memberId);
			pstm.setString(9, memberPw);

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
