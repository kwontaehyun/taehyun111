package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.shop.vo.productVO;

public class productDAO extends DAO {

	public List<productVO> proDuctList() {
		conn();
		String sql = "select* from product";
		List<productVO> list = new ArrayList<productVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
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
		} finally {
			disconn();
		}
		return list;
	}

	public List<String> menuList() {
		conn();
		String sql = "select category from product group by category";
		List<String> list = new ArrayList<String>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String vo = rs.getString("category");
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public List<productVO> menuClickEvent(String category) {
		conn();
		String sql = "select* from product where category = ?";
		List<productVO> list = new ArrayList<productVO>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, category);
			rs = psmt.executeQuery();
			while (rs.next()) {
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
		} finally {
			disconn();
		}
		return list;
	}

	public productVO searchProd(String proDuctNum) {
		conn();
		productVO vo = null;
		String sql = "select* from product where productnum = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
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
		} finally {
			disconn();
		}
		return vo;
	}

	public void adminInsertProduct(productVO vo) {
		conn();
		String sql = "insert into product(productnum, productname, productprice, category, coment, sale, pimg, gender, email) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProDuctNum());
			psmt.setString(2, vo.getProDuctName());
			psmt.setInt(3, vo.getProDuctPrice());
			psmt.setString(4, vo.getCateGory());
			psmt.setString(5, vo.getComment());
			psmt.setInt(6, vo.getSale());
			psmt.setString(7, vo.getpImg());
			psmt.setString(8, vo.getGender());
			psmt.setString(9, vo.getEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	public boolean modifyMember(productVO vo) {
		conn();
		String sql = "update product set productname=?, productprice=?, category=?, coment=?, sale=?, pimg=?, gender=?, email=? where productnum=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProDuctName());
			psmt.setInt(2, vo.getProDuctPrice());
			psmt.setString(3, vo.getCateGory());
			psmt.setString(4, vo.getComment());
			psmt.setInt(5, vo.getSale());
			psmt.setString(6, vo.getpImg());
			psmt.setString(7, vo.getGender());
			psmt.setString(8, vo.getEmail());
			psmt.setInt(9, vo.getProDuctNum());
			
			int r = psmt.executeUpdate();			
			System.out.println(r + "건 변경.");
			if(r>0) {
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	public void deleteMember(int proDuctNum) {
		conn();
		String sql = "delete from product where productnum=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, proDuctNum);
			psmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	public void placeMember(productVO vo) {
		conn();
		String sql = "select* from product where productnum = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProDuctNum());
			psmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	

	public Map<String, Integer> genderChart(){
		conn();
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select gender, count(*) as cnt\r\n"
				+ "from product\r\n"
				+ "group by gender";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("gender"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return map;
	}

	
}