package org.web.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.web.boardcontroller.ReviewBoardController;
import org.web.boarddto.BoardReview;
import org.web.dbconnect.DBConnect;
import org.web.reply.ReplyDTO;

public class ReviewDAO {

	public ReviewDAO() {
		// TODO Auto-generated constructor stub
	}

	private static class singleton {
		private static final ReviewDAO INSTANCE = new ReviewDAO();
	}

	public static ReviewDAO getInstance() {
		return singleton.INSTANCE;
	}

	// Retrieve all lists for reviews in a board.

	public ArrayList<BoardReview> allRetrieve(int StartRow, int EndRow) {
		ArrayList<BoardReview> review_lists = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "";
		// String variable for a sql experession

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM reviewboard ORDER BY review_No desc LIMIT " + StartRow + ", " + EndRow;
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();

			if (rs != null)
				while (rs.next()) {
					BoardReview boardreview = new BoardReview();
					boardreview.setReview_No(rs.getInt(1));
					boardreview.setReview_Group(rs.getInt(2));
					boardreview.setReview_Indent(rs.getInt(3));
					boardreview.setReview_Step(rs.getInt(4));
					boardreview.setReview_Hit(rs.getInt(5));

					boardreview.setReview_Subject(rs.getString(6));
					boardreview.setReview_Writer(rs.getString(7));
					boardreview.setReview_date(rs.getTimestamp(8));
					boardreview.setReview_fileDBName(rs.getString(9));
					boardreview.setReview_fileRealName(rs.getString(10));
					boardreview.setReview_fileDBName2(rs.getString(11));
					boardreview.setReview_fileRealName2(rs.getString(12));
					boardreview.setReview_Contents(rs.getString(13));
					boardreview.setReview_Password(rs.getString(14));
					// 후기 게시판의 인덱스 비밀번호 입니다.
					review_lists.add(boardreview);

				}
		} catch (Exception e) {
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
		return review_lists;
	}

	public int getTotalCount() {
		int total = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from reviewboard";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {

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

		return total;
	}

	public int review_create(String review_Writer, String review_Subject, String review_fileDBName,
			String review_fileRealName, String review_fileDBName2, String review_fileRealName2, String review_Contents,
			String review_Password) {
		/*
		 * review_Writer review_Writer는 memberName의 Value입니다.
		 */
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into reviewboard(review_Group, review_Indent, review_Step, review_Hit, review_Subject, review_Writer, review_date, review_fileDBName, review_fileRealName, review_fileDBName2, review_fileRealName2, review_Contents, review_Password) VALUES((SELECT CASE COUNT(*) WHEN 0 THEN 1 ELSE MAX(review_Group) +1 END FROM reviewboard b),0,0,0, ?,?, now(), ?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, review_Subject);
			pstm.setString(2, review_Writer);
			pstm.setString(3, review_fileDBName);
			pstm.setString(4, review_fileRealName);
			pstm.setString(5, review_fileDBName2);
			pstm.setString(6, review_fileRealName2);
			pstm.setString(7, review_Contents);
			pstm.setString(8, review_Password);

			result = pstm.executeUpdate();

		} catch (Exception e) {
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

	public ArrayList<BoardReview> selectedListView(int review_No) {
		ArrayList<BoardReview> review_list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "";
		// String variable for a sql experession

		int result = upHit(review_No);
		if (result == 1) {
			System.out.println("HIT 1 증가");
		}
		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM reviewboard where review_No=? ORDER BY review_No desc";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);
			rs = pstm.executeQuery();

			if (rs != null)
				while (rs.next()) {
					BoardReview boardreview = new BoardReview();
					boardreview.setReview_No(rs.getInt(1));
					boardreview.setReview_Group(rs.getInt(2));
					boardreview.setReview_Indent(rs.getInt(3));
					boardreview.setReview_Step(rs.getInt(4));
					boardreview.setReview_Hit(rs.getInt(5));

					boardreview.setReview_Subject(rs.getString(6));
					boardreview.setReview_Writer(rs.getString(7));
					boardreview.setReview_date(rs.getTimestamp(8));
					boardreview.setReview_fileDBName(rs.getString(9));
					boardreview.setReview_fileRealName(rs.getString(10));
					boardreview.setReview_fileDBName2(rs.getString(11));
					boardreview.setReview_fileRealName2(rs.getString(12));
					boardreview.setReview_Contents(rs.getString(13));
					boardreview.setReview_Password(rs.getString(14));
					// 후기 게시판의 인덱스 비밀번호 입니다.
					review_list.add(boardreview);

				}
		} catch (Exception e) {
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

		return review_list;
	}

	// 조회수를 위한 DAO 클래스
	public int upHit(int review_No) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update reviewboard set review_Hit = review_Hit + 1 where review_No = ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);

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

	public ArrayList<BoardReview> searchReviewList(String review_Subject, int StartRow, int EndRow) {
		ArrayList<BoardReview> searchList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query = "";
		// String variable for a sql experession

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM reviewboard where review_Subject like + '%" + review_Subject + "%'"
					+ "ORDER BY review_No desc LIMIT " + StartRow + ", " + EndRow;
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();

			if (rs != null)
				while (rs.next()) {
					BoardReview boardreview = new BoardReview();
					boardreview.setReview_No(rs.getInt(1));
					boardreview.setReview_Group(rs.getInt(2));
					boardreview.setReview_Indent(rs.getInt(3));
					boardreview.setReview_Step(rs.getInt(4));
					boardreview.setReview_Hit(rs.getInt(5));

					boardreview.setReview_Subject(rs.getString(6));
					boardreview.setReview_Writer(rs.getString(7));
					boardreview.setReview_date(rs.getTimestamp(8));
					boardreview.setReview_fileDBName(rs.getString(9));
					boardreview.setReview_fileRealName(rs.getString(10));
					boardreview.setReview_fileDBName2(rs.getString(11));
					boardreview.setReview_fileRealName2(rs.getString(12));
					boardreview.setReview_Contents(rs.getString(13));
					boardreview.setReview_Password(rs.getString(14));
					// 후기 게시판의 인덱스 비밀번호 입니다.
					searchList.add(boardreview);

				}
		} catch (Exception e) {
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

		return searchList;
	}

	// 게시글 수정
	public int modification(int review_No, String review_Writer, String review_Subject, String review_Contents,
			String review_fileRealName, String review_fileDBName, String review_fileRealName2,
			String review_fileDBName2, String review_Password) {
		BoardReview list = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		// String variable for a sql experession
		int result = 0;
		try {
			conn = DBConnect.getConnection();
			query = "update reviewboard set review_Subject=?, review_fileDBName=?, review_fileRealName=?, review_fileDBName2=?, review_fileRealName2=?, review_Contents=? where review_No = ? and review_Writer = ? and review_Password = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, review_Subject);
			pstm.setString(2, review_fileDBName);
			pstm.setString(3, review_fileRealName);
			pstm.setString(4, review_fileDBName2);
			pstm.setString(5, review_fileRealName2);
			pstm.setString(6, review_Contents);
			pstm.setInt(7, review_No);
			pstm.setString(8, review_Writer);
			pstm.setString(9, review_Password);

			result = pstm.executeUpdate();

		} catch (Exception e) {
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

	// 게시글 삭제
	public int removalBoardList(int review_No, String review_Writer, String review_Password) {
		BoardReview list = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		// String variable for a sql experession
		int result = 0;
		try {
			conn = DBConnect.getConnection();
			query = "delete from reviewboard where review_No =? and review_Writer =? and review_Password = ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);
			pstm.setString(2, review_Writer);
			pstm.setString(3, review_Password);

			result = pstm.executeUpdate();

		} catch (Exception e) {
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

	public int reply(int review_No, String reply_Subject, String reply_Writer, String reply_Contents,
			String reply_Password) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into reply(review_No, reply_Group, reply_Indent, reply_Step, reply_Subject, reply_Writer, reply_date, reply_Contents, reply_Password) VALUES(?,(SELECT CASE COUNT(*) WHEN 0 THEN 1 ELSE MAX(reply_Group) +1 END FROM reply b),0,0, ?,?, now(), ?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);
			pstm.setString(2, reply_Subject);
			pstm.setString(3, reply_Writer);
			pstm.setString(4, reply_Contents);
			pstm.setString(5, reply_Password);

			result = pstm.executeUpdate();
			if (result == 1) {
				int res = upReply(review_No);
				if (res == 1) {
					System.out.println("review_Group, review_Indent 1증가");
				}
			}
		} catch (Exception e) {
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

	// 댓글에 따른 group & indent 1 증가 위한 DAO 클래스
	public int upReply(int review_No) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update reviewboard set review_Group = review_Group + 1, review_Indent = review_Indent + 1 where review_No = ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);

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

	// 댓글 목록입니다.
	public ArrayList<ReplyDTO> replyRetrieve(int review_No) {
		ArrayList<ReplyDTO> reply = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		ReplyDTO dto = null;
		try {
			conn = DBConnect.getConnection();
			query = "select * from reply where review_No = ? order by reply_Group desc, reply_Step asc";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					dto = new ReplyDTO();
					dto.setReply_No(rs.getInt(1));
					dto.setReview_No(rs.getInt(2));
					dto.setReply_Group(rs.getInt(3));
					dto.setReply_Indent(rs.getInt(4));
					dto.setReply_Step(rs.getInt(5));
					dto.setReply_Subject(rs.getString(6));
					dto.setReply_Writer(rs.getString(7));
					dto.setReply_Date(rs.getTimestamp(8));
					dto.setReply_Contents(rs.getString(9));
					dto.setReply_Password(rs.getString(10));

					reply.add(dto);
				}
			}

		} catch (SQLException e) {
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
		return reply;
	}

	public ReplyDTO replyRemovalList(int review_No, int reply_No) {
		ReplyDTO reply = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from reply where  reply_No = ? and review_No = ? order by review_No desc";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, reply_No);
			pstm.setInt(2, review_No);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					int reply_No2 = rs.getInt(1);
					int review_No2 = rs.getInt(2);
					int reply_Group = rs.getInt(3);
					int reply_Indent = rs.getInt(4);
					int reply_Step = rs.getInt(5);
					String reply_Subject = rs.getString(6);
					String reply_Writer = rs.getString(7);
					Timestamp reply_Date = rs.getTimestamp(8);
					String reply_Contents = rs.getString(9);
					String reply_Password = rs.getString(10);

					reply = new ReplyDTO(reply_No2, review_No2, reply_Group, reply_Indent, reply_Step, reply_Subject,
							reply_Writer, reply_Date, reply_Contents, reply_Password);
				}
			}

		} catch (SQLException e) {
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
		return reply;
	}

	public int removalReply(int review_No, int reply_No, String reply_Writer, String reply_Password) {
		int result = 0;
		int minusReplyRes = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "delete from reply where reply_No = ? and review_No=? and reply_Writer =? and reply_Password = ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, reply_No);
			pstm.setInt(2, review_No);
			pstm.setString(3, reply_Writer);
			pstm.setString(4, reply_Password);

			result = pstm.executeUpdate();

			if (result == 1) {
				minusReply(review_No);

				if (minusReplyRes == 1) {
					System.out.println("삭제 후 그룹과 인덴트 1감소 성공");
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

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {

			}
		}

		return result;
	}

	// 댓글에 따른 group & indent 1 감소 위한 DAO 클래스
	public int minusReply(int review_No) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update reviewboard set review_Group = review_Group - 1, review_Indent = review_Indent - 1 where review_No = ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);

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

	// 댓글 수정입니다.
	public int modReply(int reply_No, int review_No, String reply_Writer, String reply_Subject, String reply_Contents,
			String reply_Password) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update reply set reply_Subject = ?, reply_Contents =? where reply_No = ? and review_No = ? and reply_Writer = ? and reply_Password = ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, reply_Subject);
			pstm.setString(2, reply_Contents);

			pstm.setInt(3, reply_No);
			pstm.setInt(4, review_No);
			pstm.setString(5, reply_Writer);
			pstm.setString(6, reply_Password);

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

	public int replyShape(int reply_Group, int reply_Step) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update reply set reply_Step = reply_Step +1 where reply_Group = ? and reply_Step > ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, reply_Group);
			pstm.setInt(2, reply_Step);

			result = pstm.executeUpdate();

		} catch (SQLException e) {

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

	public int replysReply(int reply_Group, int reply_Indent, int reply_Step, int review_No, String reply_Subject,
			String reply_Writer, String reply_Contents, String reply_Password) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into reply(review_No, reply_Group, reply_Indent, reply_Step, reply_Subject, reply_Writer, reply_date, reply_Contents, reply_Password) VALUES(?,?,?,?, ?,?, now(), ?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, review_No);
			pstm.setInt(2, reply_Group);
			pstm.setInt(3, reply_Indent + 1);
			pstm.setInt(4, reply_Step + 1);
			pstm.setString(5, reply_Subject);
			pstm.setString(6, reply_Writer);
			pstm.setString(7, reply_Contents);
			pstm.setString(8, reply_Password);

			result = pstm.executeUpdate();

			if (result == 1) {
				int res = replyShape(reply_Group, reply_Step);
				int upReply = upReply(review_No);
				System.out.println(res + upReply);
			}
		} catch (Exception e) {
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
