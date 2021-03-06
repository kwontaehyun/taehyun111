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
		request.setCharacterEncoding("utf-8");
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
			request.setAttribute("error", "로그인 이후 이용해주세요");
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
			return ;
		}
		
		if (isMulti) { // 멀티요청

			email = (String) session.getAttribute("email");
			int prodNum = Integer.parseInt(multi.getParameter("prodNum"));
			String content = multi.getParameter("content");
			String gradecheck = multi.getParameter("grade");
			int grade = 0;
			if(gradecheck != null) {
				grade = Integer.parseInt(multi.getParameter("grade"));

				String pf = multi.getFilesystemName("profile");

				reviewVO vo = new reviewVO();
				vo.setEmail(email);
				vo.setContent(content);
				vo.setProDuctNum(prodNum);
				
				if(grade != 0) {
					vo.setGrade(grade);
				}
				
				vo.setRImg(pf);

				reviewService service = new reviewService();
				service.reviewInsert(vo);
				//request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
				response.sendRedirect("/middleProject/detailProduct.do?proDuctNum=" + prodNum);
			}else {
				request.setAttribute("error", "평점을 입력하세요");
				request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
			}
			
		} else {

			email = (String) session.getAttribute("email");
			int prodNum = Integer.parseInt(request.getParameter("prodNum"));
			String content = request.getParameter("content");
			String gradecheck = request.getParameter("grade");
			int grade = 0;
			if(gradecheck != null) {
				grade = Integer.parseInt(request.getParameter("grade"));
				reviewVO vo = new reviewVO();
				vo.setEmail(email);
				vo.setContent(content);
				vo.setProDuctNum(prodNum);
				vo.setGrade(grade);

				reviewService service = new reviewService();
				service.reviewInsert(vo);
				response.sendRedirect("/middleProject/detailProduct.do?proDuctNum=" + prodNum);
			}else {
				request.setAttribute("error", "평점을 입력하세요");
				request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
			}
		}

	}

}
