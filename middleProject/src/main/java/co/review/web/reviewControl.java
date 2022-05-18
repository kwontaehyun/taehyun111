package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class reviewControl implements Controller {

//	@RequestMapping(value = "/review.do", method = RequestMethod.POST)
//	public String review(reviewVO re, HttpSession session) throws Exception {
//		reviewService service = new reviewService();
//		loginVO vo = (loginVO) session.getAttribute("email");
//		re.setEmail(vo.getEmail());
//
//		service.reviewInsert(re);
//
//		return "redirect:/prodDetailPage?n=" + re.getProDuctNum();
//
//	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글입력");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if (isMulti) { // 멀티요청
			String saveDir = "upload";
			saveDir = request.getServletContext().getRealPath(saveDir);
			int maxSize = 1024 * 1024 * 10;
			String encoding = "UTF-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String email = (String) session.getAttribute("email");
			System.out.println(email);
			int prodNum = Integer.parseInt(request.getParameter("prodNum"));
			String content = multi.getParameter("content");
			int grade = Integer.parseInt(multi.getParameter("grade"));
			String pf = multi.getFilesystemName("profile");

			reviewVO vo = new reviewVO();
			vo.setEmail(email);
			vo.setContent(content);
			vo.setProDuctNum(prodNum);
			vo.setGrade(grade);
			vo.setRImg(pf);

			reviewService service = new reviewService();
			service.reviewInsert(vo);
			request.getRequestDispatcher("../prodDetailpage.jsp").forward(request, response);

		} else {

		String email = (String) session.getAttribute("email");
		System.out.println(email);
		int prodNum = Integer.parseInt(request.getParameter("prodNum"));
		System.out.println(prodNum);
		String content = request.getParameter("content");
		System.out.println(content);
		int grade = Integer.parseInt(request.getParameter("grade"));
		System.out.println(grade);
//		
		reviewVO vo = new reviewVO();
//		
		vo.setEmail(email);
		vo.setContent(content);
		vo.setProDuctNum(prodNum);
		vo.setGrade(grade);

		reviewService service = new reviewService();
		service.reviewInsert(vo);
		}
		
		Gson gson=new GsonBuilder().create();
		request.getRequestDispatcher("../prodDetailpage.jsp").forward(request, response);
		
		
//		
//		
//		MultiparRequest muti = new MultipartRequest(request);
//		
//		
//		
//		service.reviewInsert(vo);
//		
//		
//
//		request.getRequestDispatcher("../prodDetailpage.jsp").forward(request, response);

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
