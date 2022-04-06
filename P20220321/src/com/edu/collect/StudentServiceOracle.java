package com.edu.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public void insertStudent(Student student) {
		conn = getConnect();
		String sql = "insert into student_info(student_no, student_name, student_eng, student_kor)\r\n"
				+ " values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getNumber());
			psmt.setString(2, student.getName());
			psmt.setInt(3, student.getEngScore());
			psmt.setInt(4, student.getKorScore());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public Student getStudent(int sno) {
		conn = getConnect();
		Student student = null;
		String sql = "select * from student_info where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);
			rs = psmt.executeQuery();
			while (rs.next()) {
				student = new Student();
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("student_eng"));
				student.setKorScore(rs.getInt("student_kor"));
			}
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		String sql = "select* from student_info order by student_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 실행 건수만큼 반복자.
			while (rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크, 있으면 하나 가지고옴.
				Student student = new Student();
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("student_eng"));
				student.setKorScore(rs.getInt("student_kor"));
				list.add(student);
			}
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void modifyStudent(Student student) {
		conn = getConnect();
		String sql = "update student_info set student_eng = ?, student_kor = ? where student_no  = ?";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, student.getEngScore());
			psmt.setInt(2, student.getKorScore());
			psmt.setInt(3, student.getNumber());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void removeStudent(int sno) {
		conn = getConnect();
		String sql = "DELETE FROM student_info WHERE student_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		String sql = "select * from student_info\r\n" + "where student_name like '%'||?||'%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery(); // 실행 건수만큼 반복자.
			while (rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크, 있으면 하나 가지고옴.
				Student student = new Student();
				student.setNumber(rs.getInt("student_no"));
				student.setName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("student_eng"));
				student.setKorScore(rs.getInt("student_kor"));
				list.add(student);
			}
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void saveToFile() {
		// TODO Auto-generated method stub

	}

}