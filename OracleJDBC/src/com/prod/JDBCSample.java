package com.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// db조회
// ojdbc 라이브러리, 오라클 DB 연결 (DB접속 주소, hr계정, hr 비번), 
// Connection 객체로 query실행(Statement, PreparedStatement) 
public class JDBCSample {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement psmt = null;

	public static Connection getConnect() {
		// DriverManager
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("연결성공!!");

		return conn;
	}

	public static void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		getConnect();

		// Statement 객체 생성.
		try {
			//stmt = conn.createStatement();

			// 조회
			// 입력. 사원번호, last_name, 입사일자, 이메일, job_id

			int emp_id = 301;
			String last_name = "hong";
			String hire_date = "2020-03-05";
			String email = "kdong@email.com";
			String job_id = "IT_PROG";

			String fn = "길동입니다.";
			String pn = "010-1234-5678";
			int salary = 6000;

			// psmt로 호출방법
			String sql = "DELETE FROM EMP_JAVA WHERE EMPLOYEE_ID = ?";
			// sql = "UPDATE EMP_JAVA SET first_name = ?, phone_number = ?, salary = ? where employee_id = ?";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, fn);
//			psmt.setString(2, pn);
//			psmt.setInt(3, salary);
			psmt.setInt(1, emp_id);

			// stmt로 호출방법
//			sql = "update emp_java \r\n"
//			          + "set first_name = '"+fn+"', "
//			          + "   phone_number='"+pn+"', "
//			          + "   email = '"+email+"', "
//			          + "   salary = "+salary+" \r\n"
//			          + "where employee_id = "+emp_id+"";

			System.out.println(sql);

			// 입력
			// sql = "INSERT INTO EMP_JAVA (EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE,
			// JOB_ID) VALUES (" + emp_id + ",'" + last_name+ "','" +email + "','" +
			// hire_date+ "','" + job_id + "')";
			int r = psmt.executeUpdate();
			//int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 삭제완료.");

//			rs = stmt.executeQuery("select * from emp_java order by employee_id");
			// next 메소드 = 데이터를 10번가지고오면 set컬렉션에 10번의 데이터를 가르키는 지시작업
			// 한건을 가지고올게 있으면 가지고오고(true), 없으면 종료.(false)
//			while (rs.next()) {
//				System.out.print("사원번호 : " + rs.getInt("employee_id"));
//				System.out.println("  이름 : " + rs.getString("first_name"));
//
//			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		disconnect();

	}

}
