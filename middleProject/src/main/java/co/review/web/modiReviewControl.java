package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class modiReviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정 처리  ");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		int prodNum = Integer.parseInt(request.getParameter("proDuctNum"));
		System.out.println(prodNum);
		int reNum=Integer.parseInt(request.getParameter("reNum"));
		System.out.println(reNum);

		// 이메일이 없을떄 하지못하게 함
		if (email == null) {
			request.setAttribute("error", "로그인후 이용");
			request.getRequestDispatcher("showView/login.jsp").forward(request, response);
			return;
		}
		// update review set rimg='여.안경2.PNG',content='ghfhfhfhf',grade=2 where
		// reviewnum=104;

		String img = request.getParameter("img");
		String content = request.getParameter("content");
		int grade = Integer.parseInt(request.getParameter("grade"));

		reviewVO vo = new reviewVO();
		vo.setRImg(img);
		vo.setContent(content);
		vo.setGrade(grade);
		
		reviewService service= new reviewService();
		service.reviewUpdate(vo);
		
		request.setAttribute("reNum", reNum);
		request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
	}

}
