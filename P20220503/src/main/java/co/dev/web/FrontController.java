package co.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Control> list = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		
		list = new HashMap<String,Control>();
		list.put("/memberInsert.do", new MemberInsertControl());
		list.put("/memberUpdate.do", new MemberUpdateControl());
		list.put("/memberList.do", new MemberListControl());
		list.put("/memberSearch.do", new MemberSearchControl());
		list.put("/memberDelete.do", new MemberDeleteControl());
		
		//Json관련
		list.put("/memberListJson.do", new MemberListJson());
		list.put("/memberInsertJson.do", new MemberInsertJson());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length());
		Control exeCon = list.get(path);
		exeCon.execute(req, resp);
		
		System.out.println("요청서블릿: " + list.get(path));
	
	}
}
