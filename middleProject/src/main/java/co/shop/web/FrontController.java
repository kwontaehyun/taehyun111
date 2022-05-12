package co.shop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.web2.productControl;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map=null;
	String enc;
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config)
			throws ServletException {

		
		enc = config.getInitParameter("encoding");
		map = new HashMap<String, Controller>();
		map.put("/Insert.do", new InsertControl());
		map.put("/login.do", new loginControl());

		map.put("/productMain.do", new productControl());
		
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Controller controller = map.get(path);
		controller.execute(request, response);
		
	}
}
