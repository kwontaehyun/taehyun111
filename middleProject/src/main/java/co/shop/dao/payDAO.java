package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.shop.vo.payVO;

public class payDAO extends DAO{
	public void insertPay(payVO vo) {
		conn();
		String sql = "insert into kakaopay(paynum, email, productname, payprice, itemcount, payimg, paydate)\r\n"
				+ "values (pay_num_seq.nextval, ? ,?, ?, 1, ?, sysdate)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmail());
			psmt.setString(2, vo.getProDuctName());
			psmt.setInt(3, vo.getPayPrice());
			psmt.setString(4, vo.getpImg());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	
	public List<payVO> userPaySelect(String email){
		conn();
		String sql = "select* from kakaopay where email = ?";
		List<payVO> list = new ArrayList<payVO>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			while (rs.next()) {
				payVO vo = new payVO();
				vo.setProDuctName(rs.getString("productname"));
				vo.setPayPrice(rs.getInt("payprice"));
				vo.setpImg(rs.getString("payimg"));
				vo.setItemCount(rs.getInt("itemcount"));
				vo.setDate(rs.getString("paydate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public List<payVO> adminPaySelect(){
		conn();
		String sql = "select* from kakaopay";
		List<payVO> list = new ArrayList<payVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				payVO vo = new payVO();
				vo.setEmail(rs.getString("email"));
				vo.setProDuctName(rs.getString("productname"));
				vo.setPayPrice(rs.getInt("payprice"));
				vo.setpImg(rs.getString("payimg"));
				vo.setItemCount(rs.getInt("itemcount"));
				vo.setDate(rs.getString("paydate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int sumPay() {
		conn();
		String sql = "select sum(payprice) as pay from kakaopay";
		int sum = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				sum = rs.getInt("pay");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return sum;
	}
	
	public int MonthsumPay(String month) {
		conn();
		String sql = "select sum(payprice) as pay from kakaopay where TO_CHAR(paydate, 'YYYY-MM') = ?";
		int sum = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, month);
			rs = psmt.executeQuery();
			if(rs.next()) {
				sum = rs.getInt("pay");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return sum;
	}
	
}
