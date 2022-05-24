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
import co.chart.web.genderChartControl;
import co.chart.web.prodGenderChartControl;
import co.kakao.web.adminPayControl;
import co.kakao.web.basketPay;
import co.kakao.web.kakaoLoginControl;
import co.kakao.web.kakaoPayControl;
import co.kakao.web.kakaoPayInfoControl;
import co.kakao.web.userPayControl;
import co.prod.web.detailControl;
import co.prod.web.prodMenuControl;
import co.prod.web.productControl;
import co.prod.web.productDeleteControl;
import co.prod.web.productInsertControl;
import co.prod.web.productMenuListControl;
import co.prod.web.productModifyControl;
import co.review.web.delReviewControl;
import co.review.web.modiReviewControl;
import co.review.web.reviewControl;
import co.review.web.selReviewControl;

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
		
		//회원가입 관련 
		map.put("/Insert.do", new InsertControl());
		map.put("/update.do", new updateControl());
		map.put("/list.do", new listControl());
		map.put("/delete.do", new deleteControl());
		map.put("/search.do", new searchControl());
		map.put("/delsearch.do", new DelsearchControl());
		map.put("/userList.do", new userInsertControl());
		
		//회원가입 확인 
		map.put("/insertCheck.do", new insertCheckControl());
		map.put("/phoneCheck.do", new insertPhoneCheck());
		map.put("/idphoneCheck.do", new idphoneCheckControl());
		
		//아이디 찾기?
		map.put("/idFind.do", new emailControl());
		map.put("/idFindCheck.do", new keyCheckControl());
		
		//결제
		map.put("/kakaopay.do", new kakaoPayControl());
		map.put("/payInfo.do", new kakaoPayInfoControl());
		map.put("/basketPay.do", new basketPay());
		map.put("/userPay.do", new userPayControl());
		map.put("/adminPay.do", new adminPayControl());
		
		
		map.put("/insertCheck.do", new insertCheckControl());
		map.put("/phoneCheck.do", new insertPhoneCheck());
		map.put("/idphoneCheck.do", new idphoneCheckControl());

		//로그인 관련 
		map.put("/login.do", new loginControl());
		map.put("/logout.do", new logoutControl());
		map.put("/kakaologin.do", new kakaoLoginControl());
		
		
		
		map.put("/productMain.do", new productControl());
		map.put("/detailProduct.do", new detailControl());
		map.put("/Productmenu.do", new prodMenuControl());
		
		//장바구니
		map.put("/shoppingBasket.do", new shoppingBasketControl());
		map.put("/basketDelete.do", new basketDeleteControl());
		map.put("/cartCntCheck.do", new basketControl());
		
		
		//상품 관련 
		map.put("/productInsert.do", new productInsertControl());
		map.put("/productModify.do", new productModifyControl());
		map.put("/productDelete.do", new productDeleteControl());
		map.put("/categoryList.do", new productMenuListControl());
	
		//차트
		map.put("/userChart.do", new genderChartControl());
		map.put("/prodChart.do", new prodGenderChartControl());
		
		//리뷰관련
		map.put("/review.do", new reviewControl());
		map.put("/delReview.do", new delReviewControl());
		map.put("/moReview.do",new modiReviewControl());
		map.put("/select.do",new selReviewControl());
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
