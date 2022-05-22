package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class modiReviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String saveDir = "reviewUpload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy());

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		int prodNum = Integer.parseInt(multi.getParameter("proNum"));
		int reNum = Integer.parseInt(multi.getParameter("reNum"));
		if (email == null) {
			request.setAttribute("error", "로그인후 이용");
			request.getRequestDispatcher("showView/login.jsp").forward(request, response);
			return;
		}

		
		if(isMulti) {
			
			String pf = multi.getFilesystemName("profile");
			String content =multi.getParameter("content");
			String gradecheck = multi.getParameter("grade");
			int grade = 0;
			if(gradecheck != null) {
				grade = Integer.parseInt(multi.getParameter("grade"));
			}
			reviewVO vo = new reviewVO();
			vo.setRImg(pf);
			vo.setContent(content);
			if(grade != 0) {
				vo.setGrade(grade);
			}
			vo.setReviewNum(reNum);
			vo.setEmail(email);
			
			reviewService service = new reviewService();
			service.reviewUpdate(vo);
			response.sendRedirect("/middleProject/detailProduct.do?proDuctNum=" + prodNum);
		}else {
			String content = request.getParameter("content");
			String gradecheck = multi.getParameter("grade");
			int grade = 0;
			if(gradecheck != null) {
				grade = Integer.parseInt(multi.getParameter("grade"));
			}

			reviewVO vo = new reviewVO();
			vo.setContent(content);
			if(grade != 0) {
				vo.setGrade(grade);
			}
			vo.setReviewNum(reNum);
			vo.setEmail(email);
			reviewService service= new reviewService();
			service.reviewUpdate(vo);
			response.sendRedirect("/middleProject/detailProduct.do?proDuctNum=" + prodNum);
			
		}
	}

}
