package co.shop.dao;

import java.sql.SQLException;

import co.shop.vo.loginVO;

public class loginDAO extends DAO {

	// 로그인
	public loginVO login(String email, String pw) {
		loginVO vo = null;
		conn();

		String sql = "select * from membership where email= ? and pw=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(2).equals(pw)) {
					// 로그인성공
					System.out.println("로그인성공");
					vo = new loginVO();
					vo.setEmail(rs.getString(1));
					vo.setPw(rs.getString(2));
					return vo;
				} else {
					// 로그인실패
					System.out.println("계정 미일치");
				}
			}
			// 아이디없음
			System.out.println("아이디없음");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		// 오류
		System.out.println("오류");
		return vo;
	}

}
