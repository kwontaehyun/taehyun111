package project;

import java.sql.SQLException;

public class SignUpApp extends DAO {
	public void userSignUp(SignUp signup) {
		conn = getConnect();
		String sql = "insert into user_info(user_num, user_name, user_birth, user_id, user_pwd, user_email)\r\n"
				+ "values( ? , ? , ? , ? , ? , ?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, signup.getUserNum());
			psmt.setString(2, signup.getUserName());
			psmt.setString(3, signup.getUserBirth());
			psmt.setString(4, signup.getUserID());
			psmt.setString(5, signup.getUserPwd());
			psmt.setString(6, signup.getUserEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 회원가입 완료.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public String IDSerach(String name, String birth) {
		conn = getConnect();
		String id = null;
		String sql = "select* from user_info where user_name = ? and user_birth = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, birth);

			rs = psmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("user_id");
			}
			int r = psmt.executeUpdate();
			System.out.println(r + "건 찾기완료.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return id;
	}

	public String pwdSearch(String name, String birth, String ID) {
		conn = getConnect();
		String pwd = null;
		String sql = "select * from user_info where user_name = ? and user_birth = ? and user_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, birth);
			psmt.setString(3, ID);
			rs = psmt.executeQuery();

			while (rs.next()) {
				pwd = rs.getString("user_pwd");
			}
			int r = psmt.executeUpdate();
			System.out.println(r + "건 찾기완료.");
			return pwd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public boolean userLogin(String ID, String pwd) {
		conn = getConnect();
		String sql = "select * from user_info where user_id = ? and user_pwd = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ID);
			psmt.setString(2, pwd);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 검색완료.");
			
			if(r == 1)
				return true;
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
	}

}
