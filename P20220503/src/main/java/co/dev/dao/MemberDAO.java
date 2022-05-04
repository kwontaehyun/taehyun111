package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO{
	
	public void updateMember(MemberVO vo) {
		conn = getConnect();
		String sql = "update member set name = ?, passwd = ?, email = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void deleteMember(String id){
		conn = getConnect();
		String sql = "delete from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public MemberVO searchMember(String id){
		conn = getConnect();
		MemberVO mem = null;
		String sql = "select* from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem = new MemberVO();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPasswd(rs.getString("passwd"));
				mem.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return mem;
	}
	
	
	public void insertMember(MemberVO member) {
		conn = getConnect();
		String sql = "insert into member(id,name,passwd,email) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public List<MemberVO> listMember(){
		conn = getConnect();
		String sql = "select* from member";
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPasswd(rs.getString("passwd"));
				mem.setEmail(rs.getString("email"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

}
