package co.shop.dao;

import java.sql.SQLException;

import co.shop.vo.ShopVO;

public class ShopDAO extends DAO {

	
	//회원가입
	public void insertMember(ShopVO members) {
		conn();
		String sql ="insert into membership(email, pw, gender, idcardnumber, address, class)\r\n"
				+ "values (?, ?, ?, ?, ? ,0)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, members.getEmail());
			psmt.setString(2, members.getPw());
			psmt.setString(3, members.getGender());
			psmt.setString(4, members.getPhone());
			psmt.setString(5, members.getAddress());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}
}
