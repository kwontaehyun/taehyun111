package co.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.shop.vo.reviewVO;

public class reviewDAO extends DAO {

	
	
	public List<reviewVO> reviewPage(String proDuctNum, int firstPage, int lastPage) {
		conn();
		String sql = "select* from (select rownum as rn, review.* from review where productnum = ? ) where rn between ? and ? order by reviewnum desc";
		List<reviewVO> list = new ArrayList<reviewVO>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			psmt.setInt(2, firstPage);
			psmt.setInt(3, lastPage);
			rs = psmt.executeQuery();
			while (rs.next()) {
				reviewVO vo = new reviewVO();
				vo.setReviewNum(rs.getInt("reviewnum"));
				vo.setRImg(rs.getString("rimg"));
				vo.setContent(rs.getString("content"));
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setEmail(rs.getString("email"));
				vo.setGrade(rs.getInt("grade"));
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
	
	public int count(String proDuctNum) {
		conn();
		String sql = "select count(*) from review where productnum = ?";
		int count = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return count;
		
	}

	public int avgGrade(String proDuctNum) {
		conn();
		int avgGrade = 0;
		String sql = "select ROUND(avg(grade)) as grade from review where productnum = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, proDuctNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				avgGrade = rs.getInt("grade");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return avgGrade;
	}

	// ?????? ??????
	public void reviewInsert(reviewVO review) {
		conn();
		String sql1 = "select * from product where  PRODUCTNUM= ?";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, review.getProDuctNum());
			rs = psmt.executeQuery();
			while (rs.next()) {
				String sql2 = "insert into review values(review_num_seq.nextval,?,?,?,?,? ) ";
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, review.getRImg());
				psmt.setString(2, review.getContent());
				psmt.setInt(3, review.getProDuctNum());
				psmt.setString(4, review.getEmail());
				psmt.setInt(5, review.getGrade());
				int r = psmt.executeUpdate();
				System.out.println(r + "??? ??????");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	// ????????????
	public void reviewDelete(int reviewNum, String email) {
		conn();
		String sql = "delete from review where REVIEWNUM=?AND email=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNum);
			psmt.setString(2, email);
			int r = psmt.executeUpdate();
			System.out.println(r + " ??? ?????? ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

	}
	
	public void adminReviewDelete(int reviewNum) {
		conn();
		String sql = "delete from review where REVIEWNUM=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNum);
			int r = psmt.executeUpdate();
			System.out.println(r + " ??? ?????? ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

	}
	

	public reviewVO selReview(int reviewNum) {
		conn();
		String sql = "select * from review where reviewnum=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				reviewVO vo = new reviewVO();
				vo.setReviewNum(rs.getInt("reviewnum"));
				vo.setEmail(rs.getString("email"));
				vo.setRImg(rs.getString("rimg"));
				vo.setContent(rs.getString("content"));
				vo.setProDuctNum(rs.getInt("productnum"));
				vo.setGrade(rs.getInt("grade"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	// ????????????
	public void reviewUpdate(reviewVO vo) {
		conn();
		String sql = "update review set rimg=?,content=?,grade=? where reviewnum=?AND email=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRImg());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getGrade());
			psmt.setInt(4, vo.getReviewNum());
			psmt.setString(5, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r + "??? ?????? ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

}
