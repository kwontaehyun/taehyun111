package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.shop.vo.productVO;

public class productDAO extends DAO{
	
	public List<productVO> proDuctList(){
		String sql = "select* from product";
		List<productVO> list = new ArrayList<productVO>();
		conn();
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
				vo.setSale(rs.getInt("sales"));
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

}
