package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardApp extends DAO implements BoardService {
	SignUpExe sux = new SignUpExe();

	public void insertBoard(Board board) {
		conn = getConnect();
		String sql = "insert into board_info(board_num, board_pwd, board_writer, board_title, board_write, board_date, user_num)\r\n"
				+ "values(? , ? , ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBoardNum());
			psmt.setString(2, board.getBoardpwd());
			psmt.setString(3, board.getBoardWriter());
			psmt.setString(4, board.getBoardTitle());
			psmt.setString(5, board.getBoardWrite());
			psmt.setString(6, board.getBoardDate());
			psmt.setInt(7, sux.user.getUserNum());
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public List<Board> BoardList() {
		conn = getConnect();
		String sql = "select* from board_info order by board_num desc";
		List<Board> list = new ArrayList<Board>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {

				Board board = new Board();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardpwd(rs.getString("board_pwd"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWrite(rs.getString("board_write"));
				board.setBoardDate(rs.getString("board_date"));

				list.add(board);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	@Override
	public void modifyBoard(Board board) {
		String sql = "update board_info set board_title = ?, board_write = ?, board_date = ? \r\n"
				+ "where user_num  = ? and board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBoardTitle());
			psmt.setString(2, board.getBoardWrite());
			psmt.setString(3, board.getBoardDate());
			psmt.setInt(4, sux.user.getUserNum());
			psmt.setInt(5, board.getBoardNum());

			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public boolean BoardDelete(String pwd) {
		conn = getConnect();
		String sql = "delete from board_info where board_pwd = ? and user_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setInt(2, sux.user.getUserNum());
			psmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean PwdCheck(String pwd) {
		conn = getConnect();
		String sql = "select* from board_info where board_pwd = ? and user_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setInt(2, sux.user.getUserNum());

			psmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean CheckNum() {
		conn = getConnect();
		String sql = "select* from board_info where user_num = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sux.user.getUserNum());
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Board boardView(int boardNum) {
		conn = getConnect();
		Board write = null;
		String sql = "select board_title, board_write, board_writer, board_date from board_info where board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			psmt.executeUpdate();

			rs = psmt.executeQuery();
			while (rs.next()) {
				write = new Board();
				write.setBoardTitle(rs.getString("board_title"));
				write.setBoardWrite(rs.getString("board_write"));
				write.setBoardWriter(rs.getString("board_writer"));
				write.setBoardDate(rs.getString("board_date"));
				return write;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public boolean CheckPwd(int writeNum) {
		String sql = "select * from board_info where board_num = ? and user_num = ? ";
		try {
			SignUpExe sux = new SignUpExe();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, writeNum);
			psmt.setInt(2, sux.user.getUserNum());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int writeNum() {
		conn = getConnect();
		int num = 0;
		String sql = "select max(board_num) from board_info";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt("max(board_num)");
				return num;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return num;
	}

	public List<Board> refercence() {
		conn = getConnect();
		String sql = "select board_num, board_title from board_info where user_num = ? ";
		List<Board> list = new ArrayList<Board>();
		;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sux.user.getUserNum());
			psmt.executeUpdate();
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
		}
		return null;
	}

	public void boardCommentInsert(Board board) {
		conn = getConnect();
		String sql = "insert into comment_info(comment_num, comment_write, board_num, user_num, user_name)\r\n"
				+ "values(?, ?, ? , ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, board.getCommentNum());
			psmt.setString(2, board.getComment());
			psmt.setInt(3, board.getBoardNum());
			psmt.setInt(4, sux.user.getUserNum());
			psmt.setString(5, sux.user.getUserName());
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<Board> boardComment(int boardNum) {
		conn = getConnect();
		List<Board> list = new ArrayList<Board>();
		String sql = "select comment_write, user_name from comment_info where board_num = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setComment(rs.getString("comment_write"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public int CommentNum() {
		conn = getConnect();
		int num = 0;
		String sql = "select max(comment_num) from comment_info";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt("max(comment_num)");
				return num;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return num;
	}
	
	public int ToComment(int boardNum) {
		conn = getConnect();
		int num = 0;
		String sql = "select count(*) as count from comment_info group by board_num having board_num = ?"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			
			if(rs.next())
			{
				num = rs.getInt("count");
				return num;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return num;
	}
	
	public int getCommentHits(int boardNum) {
		conn = getConnect();
		String sql = "select comment_hits from board_info where board_num = ? ";
		int num = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			
			if(rs.next())
			{
				num = rs.getInt("comment_hits");
			}
			return num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return num;
	}
	
	public void CommentHits(Board board) {
		conn = getConnect();
		String sql = "update board_info set comment_hits = ? where board_num = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getCommentHits());
			psmt.setInt(2, board.getBoardNum());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		finally {
			disconnect();
		}
	}
}
