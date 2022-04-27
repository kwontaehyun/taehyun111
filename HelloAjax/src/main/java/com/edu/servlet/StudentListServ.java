package com.edu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.student.Student;
import co.edu.student.StudentDAO;

@WebServlet("/studentList.json")
public class StudentListServ extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// [{"StuNo": ?, "StuName": ?, "EngScore": ?, "KorScore" : ?}]
		
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.studentList();
		
		String jsonString = "[";
		int i = 0;
		for(Student stu : list) {
			jsonString += "{\"StuNo\": "+stu.getStuNo()+", \"StuName\": \""+stu.getStuName()+"\", \"EngScore\": "+stu.getEngScore()+", \"KorScore\" : "+stu.getKorScore()+"}";
			i++;
			if(list.size() != i) {
				jsonString += ",";
			}
		}
		jsonString += "]";
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print(jsonString);
		
	}
	
}
