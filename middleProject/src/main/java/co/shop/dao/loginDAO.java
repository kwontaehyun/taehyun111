package co.shop.dao;

import java.sql.SQLException;

import co.shop.vo.loginVO;

public class loginDAO extends DAO {

	public boolean login(String email, String pw) {
		conn();
		String sql = "select* from membership where email= ? and pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
	
	public int selectRole(String email, String pw) {
		conn();
		int role = -1;
		String sql = "select* from membership where email = ? and pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				role = rs.getInt("class");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return role;
	}
	
	public boolean idCheck(String email) {
		conn();
		String sql = "select* from membership where email= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}
	public boolean pwCheck(String pw) {
		conn();
		String sql = "select* from membership where pw= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}

}
