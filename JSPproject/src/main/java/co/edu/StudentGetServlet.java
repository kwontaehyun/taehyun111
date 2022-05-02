package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class StudentGetServlet
 */
@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET : cmd = search, cmd = null -> JSON반환

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String cmd = request.getParameter("cmd");

		if (cmd != null && cmd.equals("search")) {
			String id = request.getParameter("user_id");

			StudentDAO dao = new StudentDAO();
			Student check = dao.oneCheck(id);
			
			if(check != null) {
				response.getWriter().println("<h3>학생번호: " + check.getStuNo() + "</h3>");
				response.getWriter().println("<h3>이름: " + check.getStuName() + "</h3>");
				response.getWriter().println("<h3>영어: " + check.getEngScore() + "</h3>");
				response.getWriter().println("<form name=\"frm\" action=\"StudentGetServlet\" method=\"get\"> <input type=\"hidden\" name=\"cmd\" value=\"search\"> ");
				response.getWriter().println("<input type = number name = eng_score id = eng_score>");
				response.getWriter().println("<input id = engBtn type = button value = 수정>");
				response.getWriter().println("<h3>국어: " + check.getKorScore() + "</h3>");
//				response.getWriter().println("<script>let engString = document.querySelector('#engBtn'); "
//						+ "						engString.addEventListener('click', function(){"
//						+ "						"+"let engValue = document.querySelector('#eng_score').value;"
//						+ "})</script>");
				response.getWriter().println("<script>let btn = document.querySelector('#engBtn');\r\n"
						+ "		btn.addEventListener('click', function(){\r\n"
						+ "			let frm = document.forms.frm;\r\n let engScore = document.querySelector('#eng_score').value" 
						+ "		})</script>");
				
				String eng_score = request.getParameter("eng_score");
				dao.engModefy(eng_score);
				response.getWriter().println("<input type = number id = kor_score>");
				response.getWriter().println("<input id = korBtn type = button value = 수정><br>");
				response.getWriter().println("</form>");
				response.getWriter().println("<a href = StudentList.jsp>목록으로 이동</a>");
				
				
				
			}
			else {
				response.getWriter().println("<script>alert('조회된데이터가없습니다.')</script>");
			}

			
		} else if (cmd != null && cmd.equals("list")) {
			StudentDAO dao = new StudentDAO();
			Student stud = new Student();
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");

			stud.setStuNo(Integer.parseInt(id));
			stud.setStuName(name);
			dao.addStudent(stud);
			response.getWriter().print("입력성공");
		} else {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.studentList();
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String cmd = request.getParameter("cmd");
		if (cmd != null && cmd.equals("add")) {
			StudentDAO dao = new StudentDAO();
			Student stud = new Student();
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("student_eng");
			String kor = request.getParameter("student_kor");
									
			stud.setStuNo(Integer.parseInt(id));
			stud.setStuName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			dao.addStudent(stud);
			response.getWriter().print("입력성공");
		} else if (cmd != null && cmd.equals("del")) {
			StudentDAO dao = new StudentDAO();
			String id = request.getParameter("user_id");

			if (dao.deleteStudent(id) == true) {
				response.getWriter().print("<script>alert('삭제성공')</script>");
			} else {
				response.getWriter().print("<script>alert('삭제실패')</script>");
			}
		}
		else if( cmd != null && cmd.equals("mod")) {
			StudentDAO dao = new StudentDAO();
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("student_eng");
			String kor = request.getParameter("student_kor");
			Student stud = new Student();
			stud.setStuNo(Integer.parseInt(id));
			stud.setStuName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			if(dao.modefyStudent(stud)) {
				response.getWriter().print("<script>alert('수정성공')</script>");
			}else {
				response.getWriter().print("<script>alert('수정실패')</script>");
			}
		}
		response.sendRedirect("StudentList.jsp");
	}

}
