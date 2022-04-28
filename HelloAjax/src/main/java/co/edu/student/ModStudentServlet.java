package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModStudentServlet
 */
@WebServlet("/ajax/modStudentServlet")
public class ModStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ModStudentServlet() {
        super();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html;charset=utf-8");
    	
    	String no = req.getParameter("sno");
    	String name = req.getParameter("sname");
    	String eng = req.getParameter("seng");
    	String kor = req.getParameter("skor");
    	
    	StudentDAO dao = new StudentDAO();
    	Student std = new Student();
    	std.setStuNo(Integer.parseInt(no));
    	std.setStuName(name);
    	std.setEngScore(Integer.parseInt(eng));
    	std.setKorScore(Integer.parseInt(kor));
    	boolean modify = dao.modefyStudent(std);
    	
    	if(modify) {// {"retCode":"OK", , "stuNo":no, "stuName":"name", "engScore":eng, "korScore":kor} 
    		resp.getWriter().println("{\"retCode\":\"OK\",\"stuNo\":"+no+", \"stuName\":\""+name+"\", \"engScore\":"+eng+", \"korScore\":"+kor+"} ");
    	}
    	else {
    		resp.getWriter().println("{\"retCode\":\"NG\"}");
    	}
    	
    }
}
