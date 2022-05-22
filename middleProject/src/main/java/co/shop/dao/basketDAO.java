package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.shop.vo.basketVO;

public class basketDAO extends DAO{
	public List<basketVO> shoppingBasketList(String email){
		conn();
		String sql = "select DISTINCT * from shoppingbasket where email = ?";
		List<basketVO> list = new ArrayList<basketVO>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			while(rs.next()) {
				basketVO vo = new basketVO();
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setProDuctName(rs.getString("productname"));
				vo.setProDuctPrice(rs.getInt("productprice"));
				vo.setComment(rs.getString("coment"));
				vo.setSale(rs.getInt("sale"));
				vo.setpImg(rs.getString("pimg"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
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
	
	public void shoppingBasketInsert(basketVO vo) {
		conn();
		String sql = "insert into shoppingbasket(productnum,productname, productprice, coment, sale, pimg, gender, email) values(?,?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProDuctNum());
			psmt.setString(2, vo.getProDuctName());
			psmt.setInt(3, vo.getProDuctPrice());
			psmt.setString(4, vo.getComment());
			psmt.setInt(5, vo.getSale());
			psmt.setString(6, vo.getpImg());
			psmt.setString(7, vo.getGender());
			psmt.setString(8, vo.getEmail());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	public basketVO basketProductList(String proDuctNum){
		conn();
		String sql = "select* from product where productnum = ?";
		basketVO vo = new basketVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setProDuctName(rs.getString("productname"));
				vo.setProDuctPrice(rs.getInt("productprice"));
				vo.setComment(rs.getString("coment"));
				vo.setSale(rs.getInt("sale"));
				vo.setpImg(rs.getString("pimg"));
				vo.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return vo;
	}
	
	public void shoppingBasketDelete(int proDuctNum) {
		conn();
		String sql = "delete from shoppingbasket where productnum = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, proDuctNum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
	public boolean check(int proDuctNum, String email) {
		conn();
		String sql = "select* from shoppingbasket where productnum = ? and email = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, proDuctNum);
			psmt.setString(2, email);
			psmt.executeQuery();
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			} else {
				return false;
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
