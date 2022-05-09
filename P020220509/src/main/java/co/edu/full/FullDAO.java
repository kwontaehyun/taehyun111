package co.edu.full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	
	public List<FullVO> getList(){
		String sql = "select* from full_calendar";
		getConnect();
		List<FullVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				FullVO vo = new FullVO(rs.getString("title"), rs.getString("start_date"), rs.getString("end_date"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	public void insertSchedule(FullVO vo) {
		String sql = "insert into full_calendar(title, start_date, end_date) values(?,?,?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void deleteSchedule(String title) {
		String sql = "delete from full_calendar where Title = ?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public Connection getConnect() {
		// DriverManager
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
