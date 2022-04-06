package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginApp extends DAO implements LoginService {
	
	public List<Board> boardInfo(int userNum){
		conn = getConnect();
		List<Board> list = new ArrayList<Board>();
		String sql = "select u.user_num, b.user_num, b.board_num, b.board_title, b.board_write\r\n"
				+ "from user_info u join board_info b\r\n"
				+ "on(u.user_num = b.user_num)\r\n"
				+ "where u.user_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userNum);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardTitle(rs.getString("board_title"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
	
	public List<Board> comMentInfo(int userNum){
		conn = getConnect();
		List<Board> list = new ArrayList<Board>();
		String sql = "select u.user_num, b.board_num, c.comment_write, c.user_name, b.board_title, c.comment_num\r\n"
				+ "from user_info u join comment_info c\r\n"
				+ "on(u.user_num = c.user_num)\r\n"
				+ "join board_info b\r\n"
				+ "on(c.user_num = b.user_num and c.board_num = b.board_num)\r\n"
				+ "where u.user_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userNum);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setComment(rs.getString("comment_write"));
				board.setCommentNum(rs.getInt("comment_num"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	// 2.회원정보수정 3.회원탈퇴
	public void userDelete(String pwd) {
		conn = getConnect();
		String sql = "delete from user_info where user_pwd = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void userModify(String pwd) {
		conn = getConnect();
		String sql = "update user_info set user_pwd = ? where user_num = ?";

		try {
			SignUpExe sux = new SignUpExe();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setInt(2, sux.user.getUserNum());
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void emailModify(String email, String pwd) {
		conn = getConnect();
		String sql = "update user_info set user_email = ? where user_num = ? ";

		try {
			SignUpExe sux = new SignUpExe();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setInt(2, sux.user.getUserNum());
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	
	//패스워드 점검 및 로그인상태확인
	public int userPwdCheck(String pwd) {
		conn = getConnect();
		int sno = 0;
		String sql = "select * from user_info where user_pwd = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.executeUpdate();
			rs = psmt.executeQuery();
			
			if(rs.next())
			{
				sno = rs.getInt("user_num");
				return sno;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return sno;
	
	}
	
	public void commentDelete(int delete) {
		conn = getConnect();
		String sql = "delete from comment_info where comment_num = ? and user_num = ?";
		try {
			SignUpExe sux = new SignUpExe();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, delete);
			psmt.setInt(2, sux.user.getUserNum());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void commentModefy(String modefyComment, int modefy) {
		conn = getConnect();
		String sql = "update comment_info set comment_write = ? where user_num = ? and comment_num = ?";
		try {
			SignUpExe sux = new SignUpExe();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, modefyComment);
			psmt.setInt(2, sux.user.getUserNum());
			psmt.setInt(3, modefy);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public boolean selectComment(int modefy) {
		conn = getConnect();
		String sql = "select comment_num from comment_info where comment_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, modefy);
			psmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	
}