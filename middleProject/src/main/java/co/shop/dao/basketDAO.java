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
		String sql = "insert into shoppingbasket(productname, productprice, coment, sale, pimg, gender, email) values(?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProDuctName());
			psmt.setInt(2, vo.getProDuctPrice());
			psmt.setString(3, vo.getComment());
			psmt.setInt(4, vo.getSale());
			psmt.setString(5, vo.getpImg());
			psmt.setString(6, vo.getGender());
			psmt.setString(7, vo.getEmail());
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
	
	public void shoppingBasketDelete(String proDuctName) {
		conn();
		String sql = "delete from shoppingbasket where productname = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctName);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
}
