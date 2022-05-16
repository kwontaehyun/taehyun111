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

import co.basket.web.basketControl;
import co.basket.web.basketDeleteControl;
import co.basket.web.shoppingBasketControl;
import co.prod.web.detailControl;
import co.prod.web.prodMenuControl;
import co.prod.web.productControl;
import co.prod.web.productMenuListControl;
import co.review.web.reviewControl;

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
		map.put("/logout.do", new logoutControl());

		map.put("/productMain.do", new productControl());
		map.put("/detailProduct.do", new detailControl());
		map.put("/review.do", new reviewControl());
		map.put("/Productmenu.do", new prodMenuControl());
		map.put("/categoryList.do", new productMenuListControl());
		map.put("/shoppingBasket.do", new shoppingBasketControl());
		map.put("/basketDelete.do", new basketDeleteControl());
		map.put("/cartCntCheck.do", new basketControl());
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
