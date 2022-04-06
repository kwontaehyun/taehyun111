package com.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardApp extends BoardDAO implements BoardService{
	
	
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
	
	public List<Board> BoardList(){
		conn = getConnect();
		String sql = "select* from board_info";
		List<Board> list = new ArrayList<Board>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
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
		} finally{
			disconnect();
		}
		
		return list;
	}
	
	public void modifyBoard(Board board) {
		conn = getConnect();
		String sql = "update board_info set board_title = ?, board_write = ? \r\n"
				+ "where board_pwd  = ? and board_num = ? ";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, board.getBoardTitle());
			psmt.setString(2, board.getBoardWrite());
			psmt.setString(3, board.getBoardpwd());
			psmt.setInt(4, board.getBoardNum());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	
	public void BoardDelete(String pwd){
		
		conn = getConnect();
		String sql = "delete from board_info where board_pwd = ? and board_num = ?";
		try {
			Board board = new Board();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setInt(2, board.getBoardNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제완료.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
}
