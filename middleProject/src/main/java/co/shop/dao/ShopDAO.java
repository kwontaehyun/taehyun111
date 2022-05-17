package co.shop.dao;

import java.sql.SQLException;

import co.shop.vo.ShopVO;

public class ShopDAO extends DAO {

	// 회원가입
	public void insertMember(ShopVO members) {
		conn();
		String sql = "insert into membership(email, pw, gender, idcardnumber, address, class, tel)\r\n"
				+ "values (?, ?, ?, ?, ? ,0, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, members.getEmail());
			psmt.setString(2, members.getPw());
			psmt.setString(3, members.getGender());
			psmt.setString(4, members.getJumin());
			psmt.setString(5, members.getAddress());
			psmt.setString(6, members.getPhone());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

	}

	// 아이디 중복체크
	public boolean idcheck(String email) {
		conn();
		String sql = "select * from membership where email=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
}
