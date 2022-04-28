package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/addStudentServlet")
public class AddStudentServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String stuNo = req.getParameter("sno");
		String stuName = req.getParameter("sname");
		String engScore = req.getParameter("seng");
		String korScore = req.getParameter("skor");
		
		Student stud = new Student();
		stud.setStuNo(Integer.parseInt(stuNo));
		stud.setStuName(stuName);
		stud.setEngScore(Integer.parseInt(engScore));
		stud.setKorScore(Integer.parseInt(korScore));
		
		
		StudentDAO dao = new StudentDAO();
		
		boolean success = dao.addStudent(stud);
		if(success) {
			//{"retCode":"Success", "stuNo":studentNo, "stuName":"studentName", "engScore":engScore, "korScore":korScore}
			resp.getWriter().print("{\"retCode\":\"Success\", \"stuNo\":"+ stuNo +", \"stuName\":\""+stuName+"\", \"engScore\":"+engScore+", \"korScore\":"+korScore+"}");
		}else {
			//{"retCode":"Fail"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
		
	} 
}
