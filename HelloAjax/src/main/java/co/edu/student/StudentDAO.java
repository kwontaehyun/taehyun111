package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO{

	public boolean modefyStudent(Student stud) {
		
		conn = getConnect();
		String sql = "update student_info set student_name =?, student_eng =?, student_kor =? where student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,stud.getStuName());
			psmt.setInt(2, stud.getEngScore());
			psmt.setInt(3, stud.getKorScore());
			psmt.setInt(4, stud.getStuNo());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정완료");
			if(r>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	
	public boolean deleteStudent(String id) {
		conn = getConnect();
		String sql = "delete from student_info where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r +"건 삭제완료");
			if(r>0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	public boolean addStudent(Student stud){
		conn = getConnect();
		String sql = "insert into student_info values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stud.getStuNo());
			psmt.setString(2, stud.getStuName());
			psmt.setInt(3, stud.getEngScore());
			psmt.setInt(4, stud.getKorScore());
			int r = psmt.executeUpdate();
			System.out.println(r + "입력.");
			if(r>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	public List<Student> studentList(){
		
		conn = getConnect();
		List<Student> list = new ArrayList<Student>();;
		try {
			psmt = conn.prepareStatement("select* from student_info order by student_no");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Student student = new Student();
				student.setStuNo(rs.getInt("student_no"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("student_eng"));
				student.setKorScore(rs.getInt("student_kor"));
				list.add(student);
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
