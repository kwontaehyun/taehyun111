package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.shop.vo.productVO;

public class productDAO extends DAO{
	
	public List<productVO> proDuctList(){
		conn();
		String sql = "select* from product";
		List<productVO> list = new ArrayList<productVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				productVO vo = new productVO();
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setProDuctName(rs.getString("productname"));
				vo.setProDuctPrice(rs.getInt("productprice"));
				vo.setCateGory(rs.getString("category"));
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
	
	public productVO searchProd(String proDuctNum){
		conn();
		productVO vo = null;
		String sql = "select* from product where productnum = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new productVO();
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setProDuctName(rs.getString("productname"));
				vo.setProDuctPrice(rs.getInt("productprice"));
				vo.setCateGory(rs.getString("category"));
				vo.setComment(rs.getString("coment"));
				vo.setSale(rs.getInt("sale"));
				vo.setpImg(rs.getString("pimg"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return vo;
	}

}
