package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServ
 */
@WebServlet("/request1.do")
public class RequestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RequestServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		
		StudentDAO dao = new StudentDAO();
		Student result = dao.oneCheck(id);
		request.setAttribute("result", result);
		
		// response.jsp
		request.getRequestDispatcher("response.jsp").forward(request, response);
		//페이지에 값을 넣으면, 다른페이지로 요청정보를 보냄.
		
		//response.sendRedirect("response.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
