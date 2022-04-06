package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUpApp extends DAO implements SignUpService {
	
	public List<SignUp> searchNumber(){
		List<SignUp> list = new ArrayList<SignUp>();
		conn = getConnect();
		
		String sql = "select* from user_info order by user_num";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				SignUp signup = new SignUp();
				signup.setUserNum(rs.getInt("user_num"));
				
				list.add(signup);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
	
	public void userSignUp(SignUp signup) {
		conn = getConnect();
		
		String sql = "insert into user_info(user_num, user_name, user_birth, user_id, user_pwd, user_email, phone_num )\r\n"
				+ "values( ? , ? , ? , ? , ? , ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, signup.getUserNum());
			psmt.setString(2, signup.getUserName());
			psmt.setString(3, signup.getUserBirth());
			psmt.setString(4, signup.getUserID());
			psmt.setString(5, signup.getUserPwd());
			psmt.setString(6, signup.getUserEmail());
			psmt.setString(7, signup.getUserPhoneNumber());
			psmt.executeUpdate();
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
			psmt.executeUpdate();

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
			psmt.executeUpdate();
			return pwd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public SignUp userLogin(String ID, String pwd) {
		conn = getConnect();
		String sql = "select* from user_info \r\n"
				+ "where user_id = ? and user_pwd = ?";
		SignUp signup = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ID);
			psmt.setString(2, pwd);
			
			rs = psmt.executeQuery();
			
			while(rs.next())
			{
				signup = new SignUp();
				signup.setUserNum(rs.getInt("user_num"));
				signup.setUserName(rs.getString("user_name"));
				signup.setUserID(rs.getString("user_id"));
				signup.setUserBirth(rs.getString("user_birth"));
				signup.setUserEmail(rs.getString("user_email"));
				signup.setUserPhoneNumber(rs.getString("phone_num"));
			}
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return signup;
		
		
	}
	
	public String userPhone(String phoneNumber, String name, String id, String birth) {
		conn = getConnect();
		String phoneNumber2 = null;
		String sql = "select phone_num from user_info where phone_num = ? and user_name = ? and user_id = ? and user_birth = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phoneNumber);
			psmt.setString(2, name);
			psmt.setString(3, id);
			psmt.setString(4, birth);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				phoneNumber2 = rs.getString("phone_num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneNumber2;
	}

}