package com.prod;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	
	
	public List<Employee> empList(){
		conn = super.getConnect();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			psmt = conn.prepareStatement("select * from emp_java");
			rs = psmt.executeQuery();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); // employees.employee_id에 있는 값을 읽어오는것.
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").split(" ")[0]);
				emp.setJobId(rs.getString("job_id"));
				
				employees.add(emp);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return employees;
	}
	
	//전체 조회
	//한건 조회
	//입력 처리
	//수정 처리
	//삭제 처리
	
}
