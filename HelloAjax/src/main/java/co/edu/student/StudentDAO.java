package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO{
	
	public List<Student> studentList(){
		
		conn = getConnect();
		List<Student> list = new ArrayList<Student>();;
		try {
			psmt = conn.prepareStatement("select* from student_info");
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
