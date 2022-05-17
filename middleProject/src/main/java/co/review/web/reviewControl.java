package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class reviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글입력");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		reviewService service = new reviewService();

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		int prodNum = Integer.parseInt((String) session.getAttribute("productnum"));
		String content = request.getParameter("content");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		reviewVO vo = new reviewVO();
		
		vo.setEmail(email);
		vo.setContent(content);
		vo.setProDuctNum(prodNum);
		vo.setGrade(grade);
		
		
		
		String saveDir ="upload";
//		saveDir=
//		MultiparRequest muti = new MultipartRequest(request);
		
		
		
		service.reviewInsert(vo);
		
		

		request.getRequestDispatcher("../prodDetailpage.jsp").forward(request, response);

//		reviewService service = new reviewService();
//		List<reviewVO> list = service.detailPagelist("productNum");
//		Gson gson = new GsonBuilder().create();
//		response.getWriter().print(gson.toJson(list));
//		HttpSession session = request.getSession();
//		
//		String content=request.getParameter("content");
//		
//		int num=Integer.parseInt(request.getParameter("productNum"));
//		reviewVO vo=new reviewVO();
//		
//		int prodNum=(int) session.getAttribute("productNum");
//		String email=(String) session.getAttribute("email");
//
//		reviewVO vo = new reviewVO();
//		HttpSession session = request.getSession();
//		vo =(reviewVO) session.getAttribute("email");
//		vo.setContent(request.getParameter("content"));
//		vo.setGrade(Integer.parseInt(request.getParameter("평점")));
//		
//		reviewDAO dao = new reviewDAO();
//		dao.reviewInsert(vo);

//		reviewVO vo = new reviewVO();
//		String content = request.getParameter("content");
//		HttpSession session = request.getSession();
//		String email = (String) session.getAttribute("email");

//		vo.setReviewNum(dao.getSeq(0));
//		vo.setEmail(email);
//		vo.setContent(content);
//		vo.setRImg(profile);
//		vo.setProDuctNum(0);
//		vo.setGrade(0);

	}

	private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
