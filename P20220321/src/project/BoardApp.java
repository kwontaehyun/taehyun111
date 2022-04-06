package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardApp extends DAO implements BoardService {

	public void insertBoard(Board board) {
		conn = getConnect();
		String sql = "insert into board_info(board_num, board_pwd, board_writer, board_title, board_write, board_date)\r\n"
				+ "values(? , ? , ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBoardNum());
			psmt.setString(2, board.getBoardpwd());
			psmt.setString(3, board.getBoardWriter());
			psmt.setString(4, board.getBoardTitle());
			psmt.setString(5, board.getBoardWrite());
			psmt.setString(6, board.getBoardDate());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력완료.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public List<Board> BoardList() {
		conn = getConnect();
		String sql = "select* from board_info";
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
				+ "where board_num  = ? and board_pwd = ? ";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, board.getBoardTitle());
			psmt.setString(2, board.getBoardWrite());
			psmt.setString(3, board.getBoardDate());
			psmt.setInt(4, board.getBoardNum());
			psmt.setString(5, board.getBoardpwd());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public void BoardDelete(String pwd, int no) {

		String sql = "delete from board_info where board_pwd = ? and board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setInt(2, no);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제완료.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	
	public Board CheckNum(int no) {
		conn = getConnect();
		Board board = null;
		String sql = "select* from board_info where board_num = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardpwd(rs.getString("board_pwd"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWrite(rs.getString("board_write"));
				board.setBoardDate(rs.getString("board_date"));
			}
			int r = psmt.executeUpdate();
			System.out.println(r + "건 조회완료.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	public Board CheckPwd(String pwd) {
		Board board = null;
		String sql = "select * from board_info where board_pwd = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardpwd(rs.getString("board_pwd"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWrite(rs.getString("board_write"));
				board.setBoardDate(rs.getString("board_date"));
			}
			int r = psmt.executeUpdate();
			System.out.println(r + "건 조회완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

}
