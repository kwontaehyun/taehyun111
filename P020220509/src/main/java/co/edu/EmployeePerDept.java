package co.edu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/EmployeePerDept")
public class EmployeePerDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeePerDept() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "select e.department_id, d.department_name, count(1) as cnt from employees e, departments d \r\n"
				+ "where e.department_id = d.department_id\r\n"
				+ "group by e.department_id, d.department_name";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			Map<String, Integer> map = new HashMap<String, Integer>();
			while(rs.next()) {
				// department_name, cnt
				map.put(rs.getString("department_name"), rs.getInt("cnt"));
			}
			Gson gson = new GsonBuilder().create();
			response.getWriter().println(gson.toJson(map)); // toJson 생성.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// {"err":"에러발생"}
			response.getWriter().print("{\"err\":\"에러발생\"}");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
