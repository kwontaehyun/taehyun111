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

import co.shop.dao.reviewDAO;
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

		HttpSession session = request.getSession();
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String saveDir = "reviewUpload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy());
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		
		
		if (email == null) {
			request.setAttribute("error", "로그인후이용해주세요");
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
			return ;
		}
		
		if (isMulti) { // 멀티요청

			email = (String) session.getAttribute("email");
			System.out.println(email);
			int prodNum = Integer.parseInt(multi.getParameter("prodNum"));
			System.out.println(prodNum);
			String content = multi.getParameter("content");
			System.out.println(content);
			int grade = Integer.parseInt(multi.getParameter("grade"));
			System.out.println(grade);
			String pf = multi.getFilesystemName("profile");
			System.out.println(pf);

			reviewVO vo = new reviewVO();
			vo.setEmail(email);
			vo.setContent(content);
			vo.setProDuctNum(prodNum);
			vo.setGrade(grade);
			vo.setRImg(pf);

			reviewService service = new reviewService();
			service.reviewInsert(vo);
			request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);

		} else {

			email = (String) session.getAttribute("email");
			System.out.println(email);
			int prodNum = Integer.parseInt(request.getParameter("prodNum"));
			System.out.println(prodNum);
			String content = request.getParameter("content");
			System.out.println(content);
			int grade = Integer.parseInt(request.getParameter("grade"));
			System.out.println(grade);
			reviewVO vo = new reviewVO();
			vo.setEmail(email);
			vo.setContent(content);
			vo.setProDuctNum(prodNum);
			vo.setGrade(grade);

			reviewService service = new reviewService();
			service.reviewInsert(vo);
			request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
		}

	}

	private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
