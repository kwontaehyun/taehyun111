package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.shop.vo.ShopVO;

public class ShopDAO extends DAO {

	// 회원가입
	public void insertMember(ShopVO members) {
		conn();
		String sql = "insert into membership(email, pw, gender, idcardnumber, address, class, tel, loginway)\r\n"
				+ "values (?, ?, ?, ?, ? ,0, ?, 'site')";
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
	
	public void kakoInsertMember(ShopVO members) {
		conn();
		String sql = "insert into membership(email,gender, idcardnumber, class, loginway)\r\n"
				+ "values (?, ?, ?, 0, 'kakao')";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, members.getEmail());
			psmt.setString(2, members.getGender());
			psmt.setString(3, members.getJumin());

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

	public Map<String, Integer> genderChart() {
		conn();
		String sql = "select gender, count(*) as cnt\r\n" + "from membership\r\n" + "group by gender";
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// department_name, cnt
				map.put(rs.getString("gender"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return map;

	}

	// 회원정보 수정
	public void update(ShopVO vo) {
		conn();
		String sql = "update membership set pw=?, gender=?, idcardnumber=?, address=?, tel=? where email=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPw());
			psmt.setString(2, vo.getGender());
			psmt.setString(3, vo.getJumin());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getPhone());
			psmt.setString(6, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	// 한 건 조회
	public ShopVO search(String email) {
		conn();
		String sql = "select * from membership where email=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			if (rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setEmail(rs.getString("email"));
				vo.setPw(rs.getString("pw"));
				vo.setGender(rs.getString("gender"));
				vo.setJumin(rs.getString("idcardnumber"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("tel"));
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	// 리스트
	public List<ShopVO> listShop() {
		conn();
		List<ShopVO> list = new ArrayList<ShopVO>();
		String sql = "select * from membership";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setEmail(rs.getString("email"));
				vo.setPw(rs.getString("pw"));
				vo.setGender(rs.getString("gender"));
				vo.setJumin(rs.getString("idcardnumber"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("tel"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;

	}

	// 탈퇴
	public void delete(String email) {
		conn();
		String sql = "delete from membership where email=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

	}
}
