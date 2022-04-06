package project;

import java.sql.SQLException;

public class LoginApp extends DAO {
	
	//2.회원정보수정 3.회원탈퇴
	public void userDelete(int no) {
		conn = getConnect();
		String sql = "delete from user_info where user_num = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void userModify(Login login) {
		conn = getConnect();
		String sql = "update user_info set user_pwd = ?, user_email = ? where user_no = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.getUserPwd());
			psmt.setString(2, login.getUserEmail());
			psmt.setInt(3, login.getUserNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정 완료.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
